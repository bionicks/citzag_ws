
package com.citzag.model.instagram;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Pagination {

private String next_max_tag_id;
private String deprecation_warning;
private String next_max_id;
private String next_min_id;
private String min_tag_id;
private String next_url;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The next_max_tag_id
*/
public String getNext_max_tag_id() {
return next_max_tag_id;
}

/**
* 
* @param next_max_tag_id
* The next_max_tag_id
*/
public void setNext_max_tag_id(String next_max_tag_id) {
this.next_max_tag_id = next_max_tag_id;
}

/**
* 
* @return
* The deprecation_warning
*/
public String getDeprecation_warning() {
return deprecation_warning;
}

/**
* 
* @param deprecation_warning
* The deprecation_warning
*/
public void setDeprecation_warning(String deprecation_warning) {
this.deprecation_warning = deprecation_warning;
}

/**
* 
* @return
* The next_max_id
*/
public String getNext_max_id() {
return next_max_id;
}

/**
* 
* @param next_max_id
* The next_max_id
*/
public void setNext_max_id(String next_max_id) {
this.next_max_id = next_max_id;
}

/**
* 
* @return
* The next_min_id
*/
public String getNext_min_id() {
return next_min_id;
}

/**
* 
* @param next_min_id
* The next_min_id
*/
public void setNext_min_id(String next_min_id) {
this.next_min_id = next_min_id;
}

/**
* 
* @return
* The min_tag_id
*/
public String getMin_tag_id() {
return min_tag_id;
}

/**
* 
* @param min_tag_id
* The min_tag_id
*/
public void setMin_tag_id(String min_tag_id) {
this.min_tag_id = min_tag_id;
}

/**
* 
* @return
* The next_url
*/
public String getNext_url() {
return next_url;
}

/**
* 
* @param next_url
* The next_url
*/
public void setNext_url(String next_url) {
this.next_url = next_url;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}