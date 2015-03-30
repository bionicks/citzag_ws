package com.citzag.utils;

import java.util.ArrayList;
import java.util.List;

import com.citzag.businessdelegate.UpdateContentService;
import com.citzag.daos.CzUsers;

public class StaticContent {
	
	
	public static String authToken = "177382734.1fb234f.840ef02c62804bc791d6b2c8371c95bb";	
	public static String clientId = null;
	
	private static List<Integer> customersIds = new ArrayList<Integer>();
	
	public static UpdateContentService updater = new UpdateContentService(); 
	
	
	
	public static List<Integer> getCustomersIds() {
		return customersIds;
	}



	public static void setCustomersIds(List<Integer> customersIds) {
		StaticContent.customersIds = customersIds;
	}



	static{		
		if ( System.getenv("authToken") != null ){
			authToken = System.getenv("authToken");
		}
		if ( System.getenv("clientId") != null ){
			clientId = System.getenv("clientId");
		}		
		List<CzUsers> users =  CzUsers.findAllCzUserses();
		for ( CzUsers u : users ){
			customersIds.add(u.getIdInstagram() );
		}
	}

}
