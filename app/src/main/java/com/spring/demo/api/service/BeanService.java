package com.spring.demo.api.service;

import com.spring.demo.beans.service.BeanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mabisrror on 1/14/17.
 */

public interface BeanService {

    @GET("bean.json")
    Call<BeanResponse> getBeans();

}
