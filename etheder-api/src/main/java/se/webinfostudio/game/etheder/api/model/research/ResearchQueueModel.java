package se.webinfostudio.game.etheder.api.model.research;

public class ResearchQueueModel {

	public static final class Builder {

		private String researchQueueId;
		private Long researchId;
		private String researchName;
		private String description;
		private String playerId;

		public ResearchQueueModel build() {
			final ResearchQueueModel researchQueueModel = new ResearchQueueModel();
			researchQueueModel.researchQueueId = researchQueueId;
			researchQueueModel.researchId = researchId;
			researchQueueModel.researchName = researchName;
			researchQueueModel.playerId = playerId;
			researchQueueModel.description = description;
			return researchQueueModel;
		}

		public Builder withDescription(final String description) {
			this.description = description;
			return this;
		}

		public Builder withPlayerId(final String playerId) {
			this.playerId = playerId;
			return this;
		}

		public Builder withResearchId(final Long researchId) {
			this.researchId = researchId;
			return this;
		}

		public Builder withResearchName(final String researchName) {
			this.researchName = researchName;
			return this;
		}

		public Builder withResearchQueueId(final String researchQueueId) {
			this.researchQueueId = researchQueueId;
			return this;
		}
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	private String researchQueueId;

	private Long researchId;

	private String researchName;

	private String playerId;

	private String description;

	public String getDescription() {
		return description;
	}

	public String getPlayerId() {
		return playerId;
	}

	public Long getResearchId() {
		return researchId;
	}

	public String getResearchName() {
		return researchName;
	}

	public String getResearchQueueId() {
		return researchQueueId;
	}

}
