package com.example.shaimaaderbaz.retrofittest.utils;

/**
 * Created by Shaimaa Derbaz on 2/21/2018.
 */

import com.example.shaimaaderbaz.retrofittest.models.BaseResponseResult;
import com.example.shaimaaderbaz.retrofittest.models.FeaturesResults;
import com.example.shaimaaderbaz.retrofittest.models.PropertiesEarthquake;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {


    @GET("query?format=geojson&starttime=2016-01-01&endtime=2016-01-31&minmagnitude=5&limit=10")
    Call<BaseResponseResult> getEarthquake();

    /*Call<BaseResponseResult> getEarthquake(@Query("type")double type,
                                           @Query("features")FeaturesResults features,
                                           @Query("bbox")int [] bbox
                                   );*/

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<PropertiesEarthquake> getAnswers(@Query("tagged") String tags);
}