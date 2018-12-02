package com.liband.interfaces


interface ApiDetailCallback<T> : FailureListener {
    fun onSuccess(result: T)

}
