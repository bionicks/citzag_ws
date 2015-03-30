package com.citzag.businessdelegate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.citzag.builder.ZagBuilder;
import com.citzag.daos.CzUsers;
import com.citzag.daos.CzZag;
import com.citzag.model.FetchZagsModelRS;
import com.citzag.model.instagram.FetchUsersRS;
import com.citzag.model.instagram.FetchZagsRS;
import com.citzag.model.instagram.Zag;
import com.citzag.utils.JSONizer;
import com.citzag.utils.StaticContent;

@Configurable
public class RestClientServicesImpl implements RestClientServices  {
	
	private final String INSTAGRAM_URL = "https://api.instagram.com/v1/";
	private final String keyaccesToken = "access_token";
		
	public FetchUsersRS searchUsers( String userName ){					
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(INSTAGRAM_URL+ "users/search")
        .queryParam(keyaccesToken, StaticContent.authToken)
        .queryParam("q", userName );        
		RestTemplate restTemplate = new RestTemplate();
        FetchUsersRS emp = restTemplate.getForObject( builder.build().toString() , FetchUsersRS.class);               				             
		return emp;
	}
	
	@Transactional
	public void  addUsers( String userName ){	
		
		FetchUsersRS res = this.searchUsers(userName);
		System.out.println(JSONizer.toJson(res));
		if ( res != null && res.getData() != null && res.getData().size() >0  ){
			CzUsers u = new CzUsers();
			u.setIdInstagram( Integer.valueOf( res.getData().get(0).getId() ) );
			u.setContent(JSONizer.toJson( res.getData().get(0) ));
			u.persist();
		}
	}
	
	public FetchZagsRS searchZags( String url, Integer maxResults ){
		UriComponentsBuilder builder = null;
		if ( url == null){
			builder = UriComponentsBuilder.fromHttpUrl(INSTAGRAM_URL+ "tags/citzag/media/recent")
	        .queryParam(keyaccesToken, StaticContent.authToken)
	        .queryParam("count", maxResults );						
		}else{
			builder = UriComponentsBuilder.fromHttpUrl( url );
		}
		RestTemplate restTemplate = new RestTemplate();
		FetchZagsRS emp = restTemplate.getForObject( builder.build().toString() , FetchZagsRS.class); 		
		return emp;
	}
	
	@Transactional		
	public void updateZags( String url, Integer maxResults ){		

		List<BigDecimal> ids = CzZag.findIds(); 
		if ( ids == null ) ids = new ArrayList<BigDecimal>();
		String nextUrl = null;
		boolean first = true;		
		CzZag zag_dao = null;
		while ( first ||  nextUrl != null ){
			first = false;
			FetchZagsRS tmpRes = this.searchZags(nextUrl, 50);
			
			if ( tmpRes.getPagination() != null && tmpRes.getPagination().getNext_url() != null ){
				nextUrl = tmpRes.getPagination().getNext_url();						
			}else{
				nextUrl = null;
			}
			
			for ( Zag zag: tmpRes.getData()){
				if ( ids.contains( new BigDecimal( zag.getId().split("_")[0] ))){
				//esta
					ids.remove( new BigDecimal( zag.getId().split("_")[0] ) );
				}else{
					if ( StaticContent.getCustomersIds().contains( Integer.valueOf( zag.getUser().getId()) ) ){					
						zag_dao = ZagBuilder.buildDao(zag);
						zag_dao.persist();
					}
				}
			}
			
			if ( ids.size() >0 ) CzZag.deleteByIds(ids);
		}		
		
	}
	
	
	
	public static void main(String[] args ){
		
		
		ClassPathXmlApplicationContext cs = new 			
				ClassPathXmlApplicationContext("classpath*:META-INF/spring/applicationContext*.xml");
		/*
		RestClientServicesImpl  i = new RestClientServicesImpl();
		i.updateZags(null, 50);
		StaticContent.updater.start();
		*/
		
		List<Integer> zagsIds = CzZag.getZagsByRadius( new BigDecimal("39.569719"),new BigDecimal("2.649958"),500);
	       
        FetchZagsModelRS res = new FetchZagsModelRS();   
        
        if ( zagsIds != null && zagsIds.size() > 0 ){
        	List<CzZag> zags = CzZag.findByIds(zagsIds);
        	zags = CzZag.findByTag("working");
        	//zags = CzZag.findAllCzZags();
        
	        for ( CzZag z: zags ){
	        	try {	        		
					res.getZags(). add( (Zag) JSONizer.fromJson( z.getContent(),Zag.class ) );
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
        }
        System.out.println( JSONizer.toJson(res) );
		
		
	}
	

}
