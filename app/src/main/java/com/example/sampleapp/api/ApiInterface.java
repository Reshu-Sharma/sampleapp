package com.example.sampleapp.api;

import com.example.sampleapp.model.DataModel;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("facts")
    Observable<DataModel> fetchData();


}
