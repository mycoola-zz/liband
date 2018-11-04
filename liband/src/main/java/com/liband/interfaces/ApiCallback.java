package com.liband.interfaces;

import java.util.ArrayList;


public interface ApiCallback<T> extends FailureListener {
    void onSuccess(final ArrayList<T> resultList);

}
