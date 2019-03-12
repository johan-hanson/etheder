package se.webinfostudio.game.etheder.api.resources;

import static java.util.stream.Collector.Characteristics.UNORDERED;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResponseCollector implements Collector<Object, List<Object>, Response> {

	private static Response ok(final JsonNode node, final ObjectMapper mapper) {
		return Response.ok(treeToString(node, mapper)).build();
	}

	/**
	 * Convert a json node tree to a string. The toString method on JsonNode do not
	 * work in the general case. Sometimes it will just stop recursion and just do a
	 * simple toString on some POJO and the output won't even be valid json.
	 *
	 * @param tree   The node tree
	 * @param mapper Object mapper to use
	 * @return The json in string format
	 */
	private static String treeToString(final JsonNode tree, final ObjectMapper mapper) {
		try {
			final StringWriter writer = new StringWriter();
			mapper.writeTree(mapper.getFactory().createGenerator(writer), tree);

			return writer.toString();
		} catch (final IOException e) {
			throw new IllegalArgumentException("Could not convert this tree to a string", e);
		}
	}

	private final String name;

	private final ObjectMapper mapper;

	ResponseCollector(final String name, final ObjectMapper mapper) {
		this.name = name;
		this.mapper = mapper;
	}

	@Override
	public BiConsumer<List<Object>, Object> accumulator() {
		return List::add;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return EnumSet.of(UNORDERED);
	}

	@Override
	public BinaryOperator<List<Object>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	@Override
	public Function<List<Object>, Response> finisher() {
		return resources -> {
			final ObjectNode root = mapper.createObjectNode();
			final ArrayNode node = root.putArray(name);

			resources.forEach(r -> node.add(mapper.valueToTree(r)));

			return ok(root, mapper);
		};
	}

	@Override
	public Supplier<List<Object>> supplier() {
		return ArrayList::new;
	}

}
