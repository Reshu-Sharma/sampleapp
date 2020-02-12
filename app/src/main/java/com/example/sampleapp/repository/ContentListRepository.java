package com.example.sampleapp.repository;

import com.example.sampleapp.api.ApiInterface;
import com.example.sampleapp.api.RestApiClient;
import com.example.sampleapp.model.DataModel;

import io.reactivex.Observable;

public class ContentListRepository {

    private static ContentListRepository instance;

    public static ContentListRepository getInstance(){
        if(instance==null){
            instance = new ContentListRepository();
        }return instance;
    }

    public Observable<DataModel> getmDataModel(){
        return RestApiClient.getClient().create(ApiInterface.class).fetchData();
    }
}
