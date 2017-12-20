package org.javacream.training.util.id.impl;

import org.javacream.training.util.id.IdGenerator;

public class SequenceIdGenerator implements IdGenerator {

	private Integer counter = 0;
	@Override
	public String next() {
		return "SequenceId:" + counter++;
	}

}
