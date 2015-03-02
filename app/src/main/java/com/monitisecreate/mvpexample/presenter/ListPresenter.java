package com.monitisecreate.mvpexample.presenter;

/**
 * Created by palmierif on 20/02/2015.
 */
public interface ListPresenter {

    void retrieveItems();

    void onProductSelected(int position);
}
