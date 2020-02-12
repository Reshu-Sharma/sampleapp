package com.example.sampleapp.viewmodels;

import android.app.Application;

import com.example.sampleapp.model.DataModel;
import com.example.sampleapp.repository.ContentListRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ContentListViewModel extends AndroidViewModel {
    private MutableLiveData<DataModel> modelMutableLiveData;
    private ContentListRepository mContentListRepository;
    private MutableLiveData<Boolean> isUpdatiing = new MutableLiveData<>();

    public ContentListViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        if(modelMutableLiveData!=null){
            return;
        }
        mContentListRepository = ContentListRepository.getInstance();
        modelMutableLiveData = new MutableLiveData<>();
        getLiveData();

    }
    public LiveData<DataModel> getContetList(){
        return modelMutableLiveData;
    }

    private void getLiveData(){
        isUpdatiing.postValue(true);
        Observable<DataModel> mDataModel=mContentListRepository.getmDataModel();
        mDataModel.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<DataModel>() {
                    @Override
                    protected void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onNext(DataModel dataModel) {
                        isUpdatiing.postValue(false);
                        modelMutableLiveData.postValue(dataModel);
                    }

                    @Override
                    public void onComplete() {
                        isUpdatiing.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isUpdatiing.postValue(false);
                    }
                });

    }

    public LiveData<Boolean> isUpdating(){
        return isUpdatiing;
    }



}
