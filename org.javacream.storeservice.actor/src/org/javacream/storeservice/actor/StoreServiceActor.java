package org.javacream.storeservice.actor;

import org.javacream.storeservice.api.StoreService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class StoreServiceActor {

	@Reference(target = "(&(type=book))") private StoreService storeService;
	
	@Activate public void startUp() {
		System.out.println(storeService);
		System.out.println(storeService.getStock("ISBN1"));
	}
}
