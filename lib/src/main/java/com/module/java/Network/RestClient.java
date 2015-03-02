package com.module.java.Network;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

public class RestClient implements RestInterface {

    private Scheduler mSubscribeOnScheduler;
    private Scheduler mObserveOnScheduler;

    public RestClient(Scheduler mSubscribeOnScheduler, Scheduler mObserveOnScheduler) {
        this.mSubscribeOnScheduler = mSubscribeOnScheduler;
        this.mObserveOnScheduler = mObserveOnScheduler;
    }

    @Override
    public Observable<List<String>> getProducts() {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }
                List<String> stringList = new ArrayList<>();
                stringList.add("Item 1");
                stringList.add("Item 2");
                stringList.add("Item 3");
                stringList.add("Item 4");
                stringList.add("Item 5");
                stringList.add("Item 6");
                stringList.add("Item 7");
                subscriber.onNext(stringList);
                subscriber.onCompleted();
            }
        }).subscribeOn(mSubscribeOnScheduler).observeOn(mObserveOnScheduler);
    }



    @Override
    public Observable<Object> login() {
        return Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    subscriber.onError(e);
                }
                subscriber.onNext(new Object());
                subscriber.onCompleted();
            }
        }).subscribeOn(mSubscribeOnScheduler).observeOn(mObserveOnScheduler);
    }
}
