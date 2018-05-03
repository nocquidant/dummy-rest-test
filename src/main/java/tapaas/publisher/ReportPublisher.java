package tapaas.publisher;

import tapaas.env.Environment;
import tapaas.publisher.impl.PublisherFactory;

//
// SHOULD BE IN A LIBRARY
//
public class ReportPublisher {
	
	public static void generateReport(Environment env ) {
		PublisherFactory.create(env).publish();
	}

	public static void main(String[] args) {
			// TODO
	}
}