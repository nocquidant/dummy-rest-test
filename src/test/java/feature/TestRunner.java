package feature;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@CucumberOptions(tags = { "~@ignore" })
public class TestRunner {

	static Logger logger = LoggerFactory.getLogger(TestRunner.class);

	// We should probably use a logback.xml here
	//static {
	//	Set<String> loggers = new HashSet<>(Arrays.asList("org.apache.http", "groovyx.net.http"));
  //  
  //  for(String log:loggers) { 
  //  	Logger logger = (Logger)LoggerFactory.getLogger(log);
  //  	logger.setLevel(Level.INFO);
  //  	logger.setAdditive(false);
	//	}
	//}

	@Test
	public void testParallel() {
		KarateStats stats = CucumberRunner.parallel(getClass(), Environment.KARATE_THREAD_COUNT, "target/surefire-reports");
		generateReport("target/surefire-reports");
		assertTrue("there are scenario failures", stats.getFailCount() == 0);
	}

	private static void generateReport(String karateOutputPath) {
		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
		List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File(Environment.KARATE_REPORT_PATH), Environment.KARATE_PROJECT_NAME);
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		logger.info("Generating report in: " + Environment.KARATE_REPORT_PATH);
		reportBuilder.generateReports();
	}
}