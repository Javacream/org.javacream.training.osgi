package org.javacream.training.util.id.impl;

import java.util.Random;

import org.javacream.training.util.id.IdGenerator;

public class RandomIdGenerator implements IdGenerator {

	private Random random;
	
	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	@Override
	public String next() {
		return "RandomId:" + random.nextLong();
	}

}
