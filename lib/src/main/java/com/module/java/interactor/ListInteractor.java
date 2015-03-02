package com.module.java.interactor;

import com.module.java.listener.OnProductSelecteListener;
import com.module.java.listener.OnRetrieveItemFinishedListener;

/**
 * Created by palmierif on 20/02/2015.
 */
public interface ListInteractor {

    public void getItems(OnRetrieveItemFinishedListener onRetrieveItemFinishedListener);

    public void showToastOrDetails(int position, OnProductSelecteListener onProductSelecteListener);
}
