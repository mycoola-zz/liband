package com.liband.interfaces

import java.util.*


interface ApiCallback<T> : FailureListener {
    fun onSuccess(resultList: ArrayList<T>) {}

}
