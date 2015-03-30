package com.citzag.controller;

import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.citzag.businessdelegate.RestClientServices;
import com.citzag.daos.CzUsers;
import com.citzag.daos.CzZag;
import com.citzag.model.CzUser;
import com.citzag.model.FetchZagsModelRS;
import com.citzag.model.instagram.Zag;
import com.citzag.utils.JSONizer;
import com.citzag.utils.QRGenerator;


/**
 * @author Jonas Canyellas, jonas.canyellas@gmail.com 
 * Copyright 2015, all rights reserved. 
 *
 */

@RequestMapping("/zags")
@Controller
public class ZagController   {

	@Autowired 
	RestClientServices services;
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> fetch(HttpServletRequest  request) {        
        HttpHeaders headers = new HttpHeaders();   
        headers.add("Content-Type", "application/json; charset=utf-8");
        //List<CzZag> zags = CzZag.findAllCzZags();
        List<CzZag> zags = CzZag.findByTag("");
        FetchZagsModelRS res = new FetchZagsModelRS();               
        for ( CzZag z: zags ){
        	try {
				res.getZags(). add( (Zag) JSONizer.fromJson( z.getContent(),Zag.class ) );
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new ResponseEntity<String>(JSONizer.toJson(res), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fetch/{tag}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> 
	fetchByTag(HttpServletRequest  request,@PathVariable("tag") String tag) {      
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<CzZag> zags = CzZag.findByTag(tag);
        FetchZagsModelRS res = new FetchZagsModelRS();    
        Zag temp = null;
        for ( CzZag z: zags ){
        	try {
        		temp = (Zag) JSONizer.fromJson( z.getContent(),Zag.class );
				res.getZags(). add( temp );
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new ResponseEntity<String>(JSONizer.toJson(res), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fetch/radius/{lat}/{longe}/{radius}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> fetchByRadius(HttpServletRequest  request,@PathVariable("lat") BigDecimal lat,
			  @PathVariable("longe") BigDecimal lon, @PathVariable("radius") Integer radius) {        
        HttpHeaders headers = new HttpHeaders();        
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<Integer> zagsIds = CzZag.getZagsByRadius(lat, lon, radius);
       
        FetchZagsModelRS res = new FetchZagsModelRS();   
        
        if ( zagsIds != null && zagsIds.size() > 0 ){
        	List<CzZag> zags = CzZag.findByIds(zagsIds);
        
	        for ( CzZag z: zags ){
	        	try {	        		
					res.getZags(). add( (Zag) JSONizer.fromJson( z.getContent(),Zag.class ) );
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
        }
        System.out.println( JSONizer.toJson(res) );
        return new ResponseEntity<String>(JSONizer.toJson(res), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fetch/user/{idUser}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> fetchByUser(HttpServletRequest  request,@PathVariable("idUser") Integer idUser) {        
        HttpHeaders headers = new HttpHeaders();       
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<CzZag> zags = CzZag.findByIdInstagramUser(idUser);
        FetchZagsModelRS res = new FetchZagsModelRS();               
        for ( CzZag z: zags ){
        	try {
				res.getZags(). add( (Zag) JSONizer.fromJson( z.getContent(),Zag.class ) );
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new ResponseEntity<String>(JSONizer.toJson(res), headers, HttpStatus.OK);
	}
	
	@ExceptionHandler (Exception.class)    
    public ResponseEntity<String> handleControlledExceptions(Exception ex,HttpServletRequest request,HttpServletResponse response) {		
		ex.printStackTrace();		
		HttpHeaders headers = new HttpHeaders();					
    	headers.add("error", ex.getLocalizedMessage() );              
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
}
