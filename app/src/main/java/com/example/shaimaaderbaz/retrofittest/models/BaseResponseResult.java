package com.example.shaimaaderbaz.retrofittest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/22/2018.
 */

public class BaseResponseResult {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("features")
    @Expose
    private List<FeaturesResults>  features;

    public BaseResponseResult(List<FeaturesResults> features, String type) {
        this.features = features;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FeaturesResults> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturesResults> features) {
        this.features = features;
    }

    }
