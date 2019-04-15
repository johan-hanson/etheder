package se.webinfostudio.game.etheder.api.transformer.research;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.research.ResearchQueueModel;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

/**
 *
 * @author Johan Hanson
 *
 */
public class ResearchQueueModelTransformer implements Function<ResearchQueue, ResearchQueueModel> {

	@Override
	public ResearchQueueModel apply(final ResearchQueue researchQueue) {
		return ResearchQueueModel.newBuilder()
				.withResearchQueueId(researchQueue.getId().toString())
				.withResearchId(researchQueue.getResearch().getId())
				.withResearchName(researchQueue.getResearch().getName())
				.withPlayerId(researchQueue.getPlayer().getId().toString())
				.withDescription(researchQueue.getResearch().getDescription())
				.build();
	}

}
