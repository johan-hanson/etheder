package se.webinfostudio.game.etheder.health;

import com.codahale.metrics.health.HealthCheck;

public class TestHealthCheck extends HealthCheck {

	private final String test;

	public TestHealthCheck(final String test) {
		this.test = test;
	}

	@Override
	protected Result check() throws Exception {
		final String saying = String.format(test, "TEST");
		if (!saying.contains("TEST")) {
			return Result.unhealthy("template doesn't include a name");
		}
		return Result.healthy();
	}

}
