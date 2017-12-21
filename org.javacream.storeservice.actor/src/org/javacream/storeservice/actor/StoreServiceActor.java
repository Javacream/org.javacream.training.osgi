package org.javacream.storeservice.actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.javacream.storeservice.StoreService;

public class StoreServiceActor {

	private StoreService storeService;
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	private ScheduledExecutorService executorService;
	
	
	public void startup(){
		executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println(storeService.getStock("ITEM-ID"));
			}
			
		}, 0, 5, TimeUnit.SECONDS);
	}
	
	public void finish(){
		executorService.shutdown();
	}
}
