package com.spring.demo.beans;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.spring.demo.R;
import com.spring.demo.api.BeanServiceClient;
import com.spring.demo.api.endpoint.BeanEndPointInterface;
import com.spring.demo.api.http.HttpManager;
import com.spring.demo.api.parser.BeanJsonParser;
import com.spring.demo.beans.adapter.BeanAdapterRecyclerView;
import com.spring.demo.beans.model.Bean;
import com.spring.demo.beans.service.BeanResponse;
import com.spring.demo.utils.Constant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BeanActivity extends AppCompatActivity {

    RecyclerView beanRecycler;
    LinearLayoutManager linearLayoutManager;
    BeanAdapterRecyclerView adapterRecyclerView;
    ArrayList<Bean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bean);

        beans = new ArrayList<Bean>();

        beanRecycler = (RecyclerView)findViewById(R.id.beanRecycler);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        beanRecycler.setLayoutManager(linearLayoutManager);
        //retrofitPopulate();
        parserPopulateData();
        adapterRecyclerView = new BeanAdapterRecyclerView(beans, R.layout.listitem_bean);
        beanRecycler.setAdapter(adapterRecyclerView);
    }

    private void httpUrlConnectionPopulate() {
        ConnectWebServiceTask task = new ConnectWebServiceTask();
        task.execute(Constant.URI_BEANS_DEMO);
    }

    public void retrofitPopulate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.URI_BEANS_DEMO)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BeanEndPointInterface service = retrofit.create(BeanEndPointInterface.class);

        Call<BeanResponse> responseCall = service.getBeans();
        responseCall.enqueue(new Callback<BeanResponse>() {
            @Override
            public void onResponse(Call<BeanResponse> call, Response<BeanResponse> response) {
                if (response.isSuccessful()) {
                    BeanResponse result = response.body();
                    beans.clear();
                    beans.addAll(result.getBeans());
                    adapterRecyclerView.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BeanResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    public void parserPopulateData() {
        BeanEndPointInterface service = (new BeanServiceClient()).getService();
        Call<BeanResponse> responseCall = service.getBeans();
        responseCall.enqueue(new Callback<BeanResponse>() {
            @Override
            public void onResponse(Call<BeanResponse> call, Response<BeanResponse> response) {
                if (response.isSuccessful()) {
                    BeanResponse result = response.body();
                    beans.clear();
                    beans.addAll(result.getBeans());
                    adapterRecyclerView.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<BeanResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    //Connect to the web service using AsyncTask
    public class ConnectWebServiceTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            String content = HttpManager.getData(params[0]);
            return content;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            BeanResponse beanResponse = BeanJsonParser.parse(result);
            beans.clear();
            beans.addAll(beanResponse.getBeans());
            adapterRecyclerView.notifyDataSetChanged();

        }
    }
}
