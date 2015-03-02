package com.module.java.listener;

import java.util.List;

/**
 * Created by palmierif on 20/02/2015.
 */
public interface OnRetrieveItemFinishedListener {

    void onSuccess(List<String> items);

    void onError(Throwable throwable);
}
