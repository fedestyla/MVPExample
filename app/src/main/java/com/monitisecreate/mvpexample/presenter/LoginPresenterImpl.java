package com.monitisecreate.mvpexample.presenter;

import com.module.java.Network.RestClient;
import com.module.java.interactor.LoginInteractor;
import com.module.java.interactor.LoginInteractorImpl;
import com.module.java.listener.OnLoginFinishedListener;
import com.monitisecreate.mvpexample.view.LoginView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by palmierif on 09/02/2015.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl(new RestClient(Schedulers.io(),
                AndroidSchedulers.mainThread()));
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        loginView.hideProgress();
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgress();
        loginView.setPasswordError();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.navigateSomewhere();
    }

    @Override
    public void onLoginError() {
        loginView.showToastError();
    }
}
