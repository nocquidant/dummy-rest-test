package tapaas.env;

public class Environment {
	private static Integer KARATE_THREAD_COUNT_DEFAULT = 1;
	private static String KARATE_REPORT_PATH_DEFAULT = "target";
	private static String KARATE_PROJECT_NAME_DEFAULT = "testing-karate";

	private boolean isNotEmpty(String arg) {
		if (arg == null) {
			return false;
		}
		return !arg.isEmpty();
	}

	public Integer karateThreadCount() {
		if (isNotEmpty(System.getenv("karate.thread.count"))) {
			return Integer.parseInt(System.getenv("karate.thread.count"));
		}
		if (isNotEmpty(System.getProperty("karate.thread.count"))) {
			return Integer.parseInt(System.getProperty("karate.thread.count"));
		}
		return KARATE_THREAD_COUNT_DEFAULT;
	}

	public String karateOutputPath() {
		// TODO
		return "target/surefire-reports";
	}

	public String karateReportPath() {
		if (isNotEmpty(System.getenv("karate.report.path"))) {
			return System.getenv("karate.report.path");
		}
		if (isNotEmpty(System.getProperty("karate.report.path"))) {
			return System.getProperty("karate.report.path");
		}
		return KARATE_REPORT_PATH_DEFAULT;
	}

	public String karateProjectName() {
		if (isNotEmpty(System.getenv("karate.project.name"))) {
			return System.getenv("karate.project.name");
		}
		if (isNotEmpty(System.getProperty("karate.project.name"))) {
			return System.getProperty("karate.project.name");
		}
		return KARATE_PROJECT_NAME_DEFAULT;
	}

	@Override
	public String toString() {
		return String.format("Environment object[" + //
				"karate.thread.count=%d," + //
				"karate.report.path=%s," + //
				"karate.project.name=%s]", //
				karateThreadCount(), //
				karateReportPath(), //
				karateProjectName());
	}
}