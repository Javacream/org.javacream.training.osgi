package org.javacream.training.util.id;

import org.javacream.training.util.id.impl.RandomIdGenerator;
import org.javacream.training.util.id.impl.SequenceIdGenerator;

public class IdGeneratorFactory {

	private static final RandomIdGenerator RANDOM_ID_GENERATOR;
	private static final SequenceIdGenerator SEQUENCE_ID_GENERATOR;
	private static final IdGenerator DEFAULT_ID_GENERATOR;

	static {
		RANDOM_ID_GENERATOR = new RandomIdGenerator();
		SEQUENCE_ID_GENERATOR = new SequenceIdGenerator();
		DEFAULT_ID_GENERATOR = SEQUENCE_ID_GENERATOR;
	}

	public static IdGenerator create(String strategy) {
		switch (strategy) {
		case "random":
			return RANDOM_ID_GENERATOR;
		case "sequence":
			return SEQUENCE_ID_GENERATOR;
		default:
			return DEFAULT_ID_GENERATOR;
		}
	}

}
