package com.citzag.utils;
import java.io.IOException;
import java.nio.charset.Charset;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class JSONizer { 
	
	public static String toJson(Object o){
		
		String r = null;
		try{
			r = toJson(o,o.getClass());
		}catch(Exception e){
			e.printStackTrace();
		}				
		
		if ( r!= null )Charset.defaultCharset().encode(r);
		System.out.println( ("Using charset:" + Charset.defaultCharset().displayName() ));
	    	
	    return r;
	}
	
	private static String toJson(Object o,Class dummy) throws JsonGenerationException, JsonMappingException, IOException{		
		
			return new JSONSerializer().exclude("*.class").deepSerialize(o);
			    			
	}
	
	
	public static <T> Object fromJson(String json,Class<T> c) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
				
			 	
		    	return new JSONDeserializer<T>().use(null, c).deserialize(json);		   
					
		
		
	}
	
	
	
	public static void main(String[] args){
		String as = "{ \"a\":{ cacs }";		
		System.out.println( "{" + as.substring(as.indexOf("\"a\":{") + "\"a\":{".length(),  as.lastIndexOf("}") ) +"}" );		
	}

}
