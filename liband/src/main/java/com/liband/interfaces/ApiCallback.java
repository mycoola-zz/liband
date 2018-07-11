package com.liband.interfaces;

import java.util.ArrayList;
import java.util.List;


public interface ApiCallback<T> extends FailureListener {
    void onSuccess(final ArrayList<T> resultList, boolean isLoadYes);

}
