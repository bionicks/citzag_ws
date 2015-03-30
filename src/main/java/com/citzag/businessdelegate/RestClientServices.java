package com.citzag.businessdelegate;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.citzag.model.instagram.FetchUsersRS;
import com.citzag.utils.JSONizer;
import com.citzag.utils.StaticContent;

@Configurable
public interface RestClientServices  {
		
	public FetchUsersRS searchUsers( String userName );	
	@Transactional
	public void  addUsers( String userName );
	@Transactional		
	public void updateZags( String url, Integer maxResults );
	

}
