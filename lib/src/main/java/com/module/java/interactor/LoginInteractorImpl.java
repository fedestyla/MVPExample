package com.module.java.interactor;


import com.module.java.Network.RestInterface;
import com.module.java.listener.OnLoginFinishedListener;

import rx.Observer;


public class LoginInteractorImpl implements LoginInteractor {

    RestInterface restInterface;

    public LoginInteractorImpl(RestInterface restInterface) {
        this.restInterface = restInterface;
    }

    @Override
    public void login(final String username, final String password,
                      final OnLoginFinishedListener listener) {
        if ("".equals(username)){
            listener.onUsernameError();
        }
        if ("".equals(password)){
            listener.onPasswordError();
        }

        restInterface.login().subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                listener.onLoginError();
            }

            @Override
            public void onNext(Object o) {
                listener.onSuccess();
            }
        });
    }

}
