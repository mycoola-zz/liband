package com.liband.interfaces

import java.util.ArrayList


interface ApiCallback<T> : FailureListener {
    fun onSuccess(resultList: ArrayList<T>)

}
