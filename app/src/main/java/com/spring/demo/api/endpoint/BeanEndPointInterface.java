package com.spring.demo.api.endpoint;

import com.spring.demo.beans.service.BeanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by mabisrror on 1/14/17.
 */

public interface BeanEndPointInterface {

    @GET("getBeans/")
    Call<BeanResponse> getBeans();

}
