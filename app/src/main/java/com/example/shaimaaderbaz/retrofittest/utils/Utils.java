package com.example.shaimaaderbaz.retrofittest.utils;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class Utils {

    public static final String BASE_URL = "https://earthquake.usgs.gov/fdsnws/event/1/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
