package com.jawg.electricalshow.Entries;

import java.io.Serializable;

/**
 * Created by dell-pc on 2016/2/2.
 */
public class FacItem implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id : 01
     * type : 室内消火栓系统
     */

    private String id;
    private String type;

    public FacItem(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public FacItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

