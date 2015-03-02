package com.module.java.interactor;


import com.module.java.listener.OnLoginFinishedListener;

import rx.Scheduler;

public interface LoginInteractor {

    public void login(String username, String password, OnLoginFinishedListener
                      listener);
}
