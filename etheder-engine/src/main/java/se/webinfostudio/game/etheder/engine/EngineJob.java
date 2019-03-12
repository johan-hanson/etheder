package se.webinfostudio.game.etheder.engine;

import static org.slf4j.LoggerFactory.getLogger;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;

import de.spinscale.dropwizard.jobs.Job;
import de.spinscale.dropwizard.jobs.annotations.DelayStart;
import de.spinscale.dropwizard.jobs.annotations.Every;

/**
 * The engine job that runs every tick and updates queues and creates building
 * and units. https://github.com/spinscale/dropwizard-jobs
 *
 * @author Johan Hanson
 *
 */
@Singleton
@DelayStart("60s")
@Every("${engineJob}")
public class EngineJob extends Job {

	private static final Logger LOGGER = getLogger(EngineJob.class);

	@Inject
	private EngineService ethederEngineService;

	@Override
	public void doJob(final JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("Job is started");
		// logic run every time and time again
		ethederEngineService.runService();
	}
}
