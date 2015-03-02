package com.monitisecreate.mvpexample.view;

import java.util.List;

/**
 * Created by palmierif on 20/02/2015.
 */
public interface ListViewInterface {

    public void showProgress();

    public void hideProgress();

    public void showList(List<String> items);

    public void hideList();

    public void navigateToProductDetail();

    public void showToast();
}
