package com.example.sampleapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sampleapp.R;
import com.example.sampleapp.adapter.ContentListAdapter;
import com.example.sampleapp.model.DataModel;
import com.example.sampleapp.viewmodels.ContentListViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeToRefresh;
    private RecyclerView mRecylerView;
    private ContentListViewModel mContentListViewModel;
    private ProgressBar mProgressBar;
    private ContentListAdapter mContentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentListViewModel = ViewModelProviders.of(this).get(ContentListViewModel.class);
        mContentListViewModel.init();
        mSwipeToRefresh = findViewById(R.id.swipeToRefresh);
        mRecylerView = findViewById(R.id.contentList);
        mProgressBar = findViewById(R.id.progressBar);
        mSwipeToRefresh.setOnRefreshListener(this);
        mRecylerView.setHasFixedSize(true);//every item of the RecyclerView has a fix size
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        mContentListViewModel.isUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    mProgressBar.setVisibility(View.VISIBLE);
                }else{
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });

        mContentListViewModel.getContetList().observe(this, new Observer<DataModel>() {
            @Override
            public void onChanged(@Nullable DataModel dataModel) {
                mContentListAdapter = new ContentListAdapter(dataModel.getRows(),MainActivity.this);
                mRecylerView.setAdapter(mContentListAdapter);
            }
        });


    }

    @Override
    public void onRefresh() {
        mSwipeToRefresh.setRefreshing(true);
        mContentListViewModel = ViewModelProviders.of(this).get(ContentListViewModel.class);
        mContentListViewModel.init();
        mSwipeToRefresh.setRefreshing(false);
    }
}
