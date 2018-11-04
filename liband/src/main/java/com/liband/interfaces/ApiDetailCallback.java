package com.liband.interfaces;


public interface ApiDetailCallback<T> extends FailureListener {
    void onSuccess(final T result);

}
