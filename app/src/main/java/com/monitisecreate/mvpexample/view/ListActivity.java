package com.monitisecreate.mvpexample.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.monitisecreate.mvpexample.R;
import com.monitisecreate.mvpexample.presenter.ListPresenter;
import com.monitisecreate.mvpexample.presenter.ListPresenterImpl;
import com.monitisecreate.mvpexample.adapter.ListProductAdapter;

import java.util.List;


public class ListActivity extends ActionBarActivity implements ListViewInterface {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private ListPresenter mListPresenter;
    private ListProductAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static Intent newInstance(Context context) {
        return new Intent(context, ListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mListPresenter = new ListPresenterImpl(this);
        mListPresenter.retrieveItems();
        mAdapter = new ListProductAdapter(mListPresenter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showList(List<String> items) {
        // set the adapter and show the list
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter.setList(items);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideList() {
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void navigateToProductDetail() {

    }

    @Override
    public void showToast() {

    }
}
