package tapaas.publisher.impl;

import tapaas.env.Environment;
import tapaas.publisher.Publisher;

public class PublisherFactory {
	public static Publisher create(Environment context) {
		// TODO switch
		return new LocalPublisher(context);		
	}
}