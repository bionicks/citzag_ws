package com.citzag.businessdelegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

	
	@Configurable
	public class UpdateContentService extends Thread{
		
		@Autowired 
		RestClientServices services;
	 
		@Override
		public void run() {
			System.out.println(getName() + " dwdwg");
			
				for ( ;; ){
					try {
						Thread.sleep(5000);
						System.out.println(getName() + " is running");
						services.updateZags(null, 50);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
										
		}
	 
	}


