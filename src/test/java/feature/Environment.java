package feature;

public abstract class Environment {
	static int KARATE_THREAD_COUNT = Integer.parseInt(
		System.getenv("karate.thread.count") == null ? "1" : System.getenv("karate.thread.count")
	);
	
	static String KARATE_REPORT_PATH = 
		System.getenv("karate.report.path") == null ? "target" : System.getenv("karate.report.path");

	static String KARATE_PROJECT_NAME = 
		System.getenv("karate.project.name") == null ? "testing-karate" : System.getenv("karate.project.name");
}