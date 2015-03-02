package com.module.java.Network;

import java.util.List;

import rx.Observable;

/**
 * Created by palmierif on 02/03/2015.
 */
public interface RestInterface {

    Observable<List<String>> getProducts();

    Observable<Object> login();
}
