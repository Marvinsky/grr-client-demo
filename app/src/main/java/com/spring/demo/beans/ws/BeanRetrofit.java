package com.spring.demo.beans.ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.demo.beans.service.BeanResponse;
import com.spring.demo.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mabisrror on 1/14/17.
 */

public class BeanRetrofit {
    private Retrofit retrofit;

    public BeanRetrofit() {
        BeanResponseTypeAdapter adapter = new BeanResponseTypeAdapter();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(BeanResponse.class, new BeanResponseTypeAdapter())
                .create();
        retrofit = new Retrofit.Builder().baseUrl(Constant.URI_BEANS_DEMO)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public BeanEndPointInterface getService() {
        return retrofit.create(BeanEndPointInterface.class);
    }
}
