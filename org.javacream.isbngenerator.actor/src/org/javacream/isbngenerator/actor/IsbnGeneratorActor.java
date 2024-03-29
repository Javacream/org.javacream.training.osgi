package org.javacream.isbngenerator.actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.isbngenerator.IsbnGenerator;

public class IsbnGeneratorActor {

	private ScheduledExecutorService executorService;

	private IsbnGenerator isbnGenerator;
	
	
	public void setIsbnGenerator(IsbnGenerator isbnGenerator) {
		this.isbnGenerator = isbnGenerator;
	}

	public void startup(){
		executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println(isbnGenerator.nextIsbn());
			}
			
		}, 0, 5, TimeUnit.SECONDS);
	}
	
	public void finish(){
		executorService.shutdown();
	}
}
