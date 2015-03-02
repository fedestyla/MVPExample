package com.monitisecreate.mvpexample.presenter;

import com.module.java.interactor.ListInteractor;
import com.module.java.interactor.ListInteractorImpl;
import com.module.java.listener.OnProductSelecteListener;
import com.module.java.listener.OnRetrieveItemFinishedListener;
import com.monitisecreate.mvpexample.view.ListViewInterface;

import java.util.List;

/**
 * Created by palmierif on 20/02/2015.
 */
public class ListPresenterImpl implements ListPresenter, OnRetrieveItemFinishedListener, OnProductSelecteListener {

    private ListViewInterface listViewInterface;
    private ListInteractor listInteractor;

    public ListPresenterImpl(ListViewInterface listViewInterface) {
        this.listViewInterface = listViewInterface;
        this.listInteractor = new ListInteractorImpl();
    }

    @Override
    public void onSuccess(List<String> items) {
        listViewInterface.hideProgress();
        listViewInterface.showList(items);
    }

    @Override
    public void onError(Throwable throwable) {
        // show empty view message
    }

    @Override
    public void retrieveItems() {
        listInteractor.getItems(this);
    }

    @Override
    public void onProductSelected(int position) {
        listInteractor.showToastOrDetails(position, this);
    }

    @Override
    public void showToast() {
        listViewInterface.showToast();
    }

    @Override
    public void showDetails() {
        listViewInterface.navigateToProductDetail();
    }
}
