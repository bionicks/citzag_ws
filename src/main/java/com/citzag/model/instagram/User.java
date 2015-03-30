
package com.citzag.model.instagram;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class User {

    private String username;
    private String profile_picture;
    private String id;
    private String full_name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The profile_picture
     */
    public String getProfile_picture() {
        return profile_picture;
    }

    /**
     * 
     * @param profile_picture
     *     The profile_picture
     */
    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The full_name
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * 
     * @param full_name
     *     The full_name
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
