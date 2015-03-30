package com.citzag.model.instagram;

import java.util.ArrayList;
import java.util.List;

public class FetchUsersRS {
	
	public Meta meta;
	
	public List<FetchUserRS> data = new ArrayList<FetchUserRS>();
	
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public List<FetchUserRS> getData() {
		return data;
	}
	public void setData(List<FetchUserRS> data) {
		this.data = data;
	}
	
	
 
	
	

}
