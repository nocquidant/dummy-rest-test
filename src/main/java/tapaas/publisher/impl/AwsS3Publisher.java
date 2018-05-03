package tapaas.publisher.impl;

import tapaas.env.Environment;
import tapaas.publisher.Publisher;

public class AwsS3Publisher implements Publisher {
	final Environment context;

	AwsS3Publisher(Environment context) {
		this.context = context;
	}

	@Override
	public void publish() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}