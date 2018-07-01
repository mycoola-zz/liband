package com.liband.interfaces;

import java.util.ArrayList;


public interface ApiDetailCallback<T> extends FailureListener {
    public void onSuccess(final T result);

}
