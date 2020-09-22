package se.webinfostudio.game.etheder.api.transformer.research;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.research.ResearchQueueModel;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

public class ResearchQueueTransformer implements Function<ResearchQueueModel, ResearchQueue> {

	@Override
	public ResearchQueue apply(final ResearchQueueModel researchQueueModel) {
		final ResearchQueue researchQueue = new ResearchQueue();
		researchQueue.setResearchId(researchQueueModel.getResearchId());
		researchQueue.setPlayerId(fromString(researchQueueModel.getPlayerId()));
		return researchQueue;
	}

}
