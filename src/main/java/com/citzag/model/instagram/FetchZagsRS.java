package com.citzag.model.instagram;

import java.util.ArrayList;
import java.util.List;

public class FetchZagsRS {
	
	private Pagination pagination;
	private List<Zag> data = new ArrayList<Zag>();
	private Meta meta;
	
	
	
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	public List<Zag> getData() {
		return data;
	}
	public void setData(List<Zag> data) {
		this.data = data;
	}
	
	
	

}
