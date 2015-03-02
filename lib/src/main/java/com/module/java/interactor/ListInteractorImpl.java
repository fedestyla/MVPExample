package com.module.java.interactor;

import com.module.java.Network.RestClient;
import com.module.java.Network.RestInterface;
import com.module.java.listener.OnProductSelecteListener;
import com.module.java.listener.OnRetrieveItemFinishedListener;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by palmierif on 20/02/2015.
 */
public class ListInteractorImpl implements ListInteractor {

    @Override
    public void getItems(final OnRetrieveItemFinishedListener onRetrieveItemFinishedListener) {
        RestInterface restInterface = new RestClient(Schedulers.io(),
                AndroidSchedulers.mainThread());
        restInterface.getProducts().subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                onRetrieveItemFinishedListener.onError(e);
            }

            @Override
            public void onNext(List<String> strings) {
                onRetrieveItemFinishedListener.onSuccess(strings);
            }
        });
    }

    @Override
    public void showToastOrDetails(int position, OnProductSelecteListener
            onProductSelecteListener) {
        if(position % 2 == 0) {
            onProductSelecteListener.showToast();
        } else {
            onProductSelecteListener.showDetails();
        }

    }
}
