package com.example.myapplication.API;

import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ApiHandler
{
    private static Webservices apiService;
    public static final String BASE_URL ="http://192.168.0.124/abc/";
    public static Webservices getApiService()
    {
        if (apiService == null)
        {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(BASE_URL)

                    .setConverter(new GsonConverter(new Gson()))
                    .build();
            apiService = restAdapter.create(Webservices.class);
            return apiService;
        }
        else
            {
            return apiService;
        }
    }
}
