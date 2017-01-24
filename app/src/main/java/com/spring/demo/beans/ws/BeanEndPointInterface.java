package com.spring.demo.beans.ws;

import com.spring.demo.beans.service.BeanResponse;
import com.spring.demo.model.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mabisrror on 1/14/17.
 */

public interface BeanEndPointInterface {

    @POST("getBeans/")
    Call<BeanResponse> getBeans(@Body Task task, @Header("token") String token);

}
