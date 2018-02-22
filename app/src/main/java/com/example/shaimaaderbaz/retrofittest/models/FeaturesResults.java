package com.example.shaimaaderbaz.retrofittest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/22/2018.
 */

public class FeaturesResults {
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("properties")
    @Expose
    PropertiesEarthquake properties;
    //String geometry;
    @SerializedName("id")
    @Expose
    String id;

    public FeaturesResults(String type,PropertiesEarthquake properties, String id) {
        this.type = type;
        this.properties = properties;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertiesEarthquake getProperties() {
        return properties;
    }

    public void setProperties(PropertiesEarthquake properties) {
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
