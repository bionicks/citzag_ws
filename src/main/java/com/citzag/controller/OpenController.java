package com.citzag.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citzag.businessdelegate.RestClientServices;
import com.citzag.daos.CzUsers;
import com.citzag.model.CzUser;
import com.citzag.utils.JSONizer;
import com.citzag.utils.QRGenerator;
import com.citzag.utils.StaticContent;


/**
 * @author Jonas Canyellas, jonas.canyellas@gmail.com 
 * Copyright 2015, all rights reserved, this code can not be redistributed. 
 *
 */

@RequestMapping("/users")
@Controller
public class OpenController   {

	@Autowired 
	RestClientServices services;
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> fetch(HttpServletRequest  request) {        
        HttpHeaders headers = new HttpHeaders();        
        headers.add("Content-Type", "application/json; charset=utf-8");
        List<CzUsers> users = CzUsers.findAllCzUserses();
        List<CzUser> users_model = new ArrayList<CzUser>();               
        for ( CzUsers u: users ){
        	try {
				users_model.add( (CzUser) JSONizer.fromJson( u.getContent(),CzUser.class ) );
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        return new ResponseEntity<String>(JSONizer.toJson(users_model), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add/{username}", method = RequestMethod.GET,produces = "application/json; charset=utf-8")    
	@ResponseBody
	  public ResponseEntity<String> add(@PathVariable("username") String username,HttpServletRequest  request) {  
		  HttpHeaders headers = new HttpHeaders(); 
        services.addUsers(username);
        List<CzUsers> users =  CzUsers.findAllCzUserses();        
		for ( CzUsers u : users ){
			StaticContent.getCustomersIds().add(u.getIdInstagram() );
		}
        return new ResponseEntity<String>( headers, HttpStatus.OK);
	}
	
	@RequestMapping("/qr/{text}")
	@ResponseBody
	public ResponseEntity<byte[]> testphoto(HttpServletRequest request,@PathVariable("text") String text) throws IOException {
	
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( QRGenerator.gen (text) , "png", baos);
		InputStream is = new ByteArrayInputStream(baos.toByteArray());	    
	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(is), headers, HttpStatus.CREATED);
	}

	
}
