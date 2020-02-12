package com.example.sampleapp.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ContentListViewModel extends ViewModelProvider.AndroidViewModelFactory {

    public ContentListViewModel(@NonNull Application application) {
        super(application);
    }
}
