package feature;

import static org.junit.Assert.assertTrue;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.CucumberOptions;
import tapaas.env.Environment;
import tapaas.publisher.ReportPublisher;

@CucumberOptions(tags = { "~@ignore" })
public class TestRunner {

	static Logger logger = LoggerFactory.getLogger(TestRunner.class);
	static Environment env = new Environment();

	static {
		// debug
		logger.info(env.toString());
	}

	@Test
	public void testParallel() {
		// TODO We could probably execute a group of features only, in order to distribute load and time on several containers
		// ex. packet.current=3 and packet.max=10 with 100 features --> execute in // the packet#3 with numFeatures/10 in it
		KarateStats stats = CucumberRunner.parallel(getClass(), env.karateThreadCount(), env.karateOutputPath());
		ReportPublisher.generateReport(env);
		assertTrue("there are scenario failures", stats.getFailCount() == 0);
	}
}