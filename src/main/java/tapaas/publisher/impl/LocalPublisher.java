package tapaas.publisher.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import tapaas.env.Environment;
import tapaas.publisher.Publisher;


public class LocalPublisher implements Publisher {

	final Environment context;

	LocalPublisher(Environment context) {
		this.context = context;
	}

	@Override
	public void publish() {
		String karateOutputPath = context.karateOutputPath();
		String karateReportPath = context.karateReportPath();
		String karateProjectName = context.karateProjectName();

		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
		List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File(karateReportPath), karateProjectName);
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		reportBuilder.generateReports();
	}
}