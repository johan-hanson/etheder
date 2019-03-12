package se.webinfostudio.game.etheder;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.cache.CacheBuilderSpec;

import de.spinscale.dropwizard.jobs.JobConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class ApiConfiguration extends Configuration implements JobConfiguration {

	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	@JsonProperty("quartz")
	private Map<String, String> quartz;

	@JsonProperty("jobs")
	private Map<String, String> jobs;

	@JsonProperty("authCacheConfiguration")
	private CacheBuilderSpec authCacheConfiguration;

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

	@Override
	public Map<String, String> getJobs() {
		return jobs;
	}

	public Map<String, String> getQuartzConfiguration() {
		return quartz;
	}

	@JsonProperty("database")
	public void setDataSourceFactory(final DataSourceFactory database) {
		this.database = database;
	}

	public void setJobs(final Map<String, String> jobs) {
		this.jobs = jobs;
	}

	public CacheBuilderSpec getAuthCacheConfiguration() {
		return authCacheConfiguration;
	}

	public void setAuthCacheConfiguration(CacheBuilderSpec authCacheConfiguration) {
		this.authCacheConfiguration = authCacheConfiguration;
	}

}
