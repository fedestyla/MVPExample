package com.monitisecreate.mvpexample.view;


public interface LoginView {

    public void showProgress();

    public void hideProgress();

    public void setUsernameError();

    public void setPasswordError();

    public void showToastError();

    public void navigateSomewhere();
}
