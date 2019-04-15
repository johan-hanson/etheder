package se.webinfostudio.game.etheder.api.transformer.research;

import static java.util.UUID.fromString;

import java.util.function.Function;

import se.webinfostudio.game.etheder.api.model.research.ResearchQueueModel;
import se.webinfostudio.game.etheder.entity.player.PlayerRef;
import se.webinfostudio.game.etheder.entity.research.Research;
import se.webinfostudio.game.etheder.entity.research.ResearchQueue;

public class ResearchQueueTransformer implements Function<ResearchQueueModel, ResearchQueue> {

	@Override
	public ResearchQueue apply(final ResearchQueueModel researchQueueModel) {
		final ResearchQueue researchQueue = new ResearchQueue();
		researchQueue.setResearch(createResearch(researchQueueModel));
		researchQueue.setPlayer(new PlayerRef(fromString(researchQueueModel.getPlayerId())));
		return researchQueue;
	}

	private Research createResearch(final ResearchQueueModel researchQueueModel) {
		final Research research = new Research();
		research.setId(researchQueueModel.getResearchId());
		research.setName(researchQueueModel.getResearchName());
		research.setDescription(researchQueueModel.getDescription());
		return research;
	}

}
