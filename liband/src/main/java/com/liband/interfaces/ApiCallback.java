package com.liband.interfaces;

import java.util.ArrayList;
import java.util.List;


public interface ApiCallback<T> extends FailureListener {
    public void onSuccess(final ArrayList<T> resultList, boolean isLoadYes);

}
