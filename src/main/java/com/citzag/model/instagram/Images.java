
package com.citzag.model.instagram;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Images {

    private Low_resolution low_resolution;
    private Thumbnail thumbnail;
    private Standard_resolution standard_resolution;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The low_resolution
     */
    public Low_resolution getLow_resolution() {
        return low_resolution;
    }

    /**
     * 
     * @param low_resolution
     *     The low_resolution
     */
    public void setLow_resolution(Low_resolution low_resolution) {
        this.low_resolution = low_resolution;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The standard_resolution
     */
    public Standard_resolution getStandard_resolution() {
        return standard_resolution;
    }

    /**
     * 
     * @param standard_resolution
     *     The standard_resolution
     */
    public void setStandard_resolution(Standard_resolution standard_resolution) {
        this.standard_resolution = standard_resolution;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
