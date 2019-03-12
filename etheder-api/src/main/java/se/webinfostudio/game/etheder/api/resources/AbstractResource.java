package se.webinfostudio.game.etheder.api.resources;

import static javax.ws.rs.core.Response.Status.FORBIDDEN;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

import java.util.List;
import java.util.stream.Collector;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 *
 * @author Johan Hanson
 *
 */
public abstract class AbstractResource {

	private final ObjectMapper mapper;

	protected AbstractResource(final ObjectMapper mapper) {
		this.mapper = mapper;
	}

	/**
	 * Create an FORBIDDEN response.
	 *
	 * @return The response
	 */
	protected Response forbidden(final Object... messages) {
		return status(FORBIDDEN, messages);
	}

	/**
	 * Create an NOT FOUND response.
	 *
	 * @return The response
	 */
	protected Response notFound(final Object... messages) {
		return status(NOT_FOUND, messages);
	}

	/**
	 * Create an OK response
	 *
	 * @return The response
	 */
	protected Response ok() {
		return Response.status(OK).build();
	}

	protected Response okFlat(final Object resource) {
		try {
			return Response.ok(mapper.writeValueAsString(resource)).build();
		} catch (final JsonProcessingException e) {
			throw new IllegalArgumentException("Could not convert a resource to JSON.", e);
		}
	}

	protected Collector<Object, List<Object>, Response> okFlat(final String name) {
		return new ResponseCollector(name, mapper);
	}

	protected Response status(final Status status, final Object... messages) {
		final ResponseBuilder builder = Response.status(status);

		final ObjectNode root = mapper.createObjectNode();
		final ArrayNode errors = root.putArray("errors");

		for (final Object message : messages) {
			errors.addObject().put("detail", message.toString());
		}

		builder.entity(root);

		return builder.build();
	}

}
