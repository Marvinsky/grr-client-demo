package com.spring.demo.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.demo.api.service.BeanService;
import com.spring.demo.beans.service.BeanResponse;
import com.spring.demo.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanServiceClient {
    private Retrofit retrofit;

    public BeanServiceClient() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(BeanResponse.class, new BeanResponseTypeAdapter())
                .create();
        retrofit = new Retrofit.Builder().baseUrl(Constant.URI_BEANS_DEMO)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        /*
        BeanResponseTypeAdapter adapter = new BeanResponseTypeAdapter();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(BeanResponse.class, adapter)
                .create();
        retrofit = new Retrofit.Builder().baseUrl(Constant.URI_BEANS_DEMO)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        */



        /*
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URI_BEANS_DEMO)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        */
    }

    public BeanService getService() {
        return retrofit.create(BeanService.class);
    }

}
