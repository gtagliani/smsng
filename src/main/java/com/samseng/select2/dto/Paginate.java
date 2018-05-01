
package com.samseng.select2.dto;

import java.util.HashMap;
import java.util.Map;

public class Paginate {

    private Boolean more;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
