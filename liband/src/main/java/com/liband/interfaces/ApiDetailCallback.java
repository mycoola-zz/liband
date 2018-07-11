package com.liband.interfaces;

import java.util.ArrayList;


public interface ApiDetailCallback<T> extends FailureListener {
    void onSuccess(final T result);

}
