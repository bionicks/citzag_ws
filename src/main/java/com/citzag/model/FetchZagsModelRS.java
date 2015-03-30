package com.citzag.model;

import java.util.ArrayList;
import java.util.List;

import com.citzag.model.instagram.Zag;

public class FetchZagsModelRS {
	
	private List<Zag> zags = new ArrayList<Zag>();
	private PaginatedResponseInfo pagination = new PaginatedResponseInfo();
	
	public List<Zag> getZags() {
		return zags;
	}
	public void setZags(List<Zag> zags) {
		this.zags = zags;
	}
	public PaginatedResponseInfo getPagination() {
		return pagination;
	}
	public void setPagination(PaginatedResponseInfo pagination) {
		this.pagination = pagination;
	}
	
	

}
