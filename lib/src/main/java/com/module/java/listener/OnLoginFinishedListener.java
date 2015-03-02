package com.module.java.listener;

/**
 * Created by palmierif on 09/02/2015.
 */
public interface OnLoginFinishedListener {

        public void onUsernameError();

        public void onPasswordError();

        public void onSuccess();

        public void onLoginError();
}
