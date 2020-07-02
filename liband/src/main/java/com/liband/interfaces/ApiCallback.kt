package com.liband.interfaces



interface ApiCallback<Any> : FailureListener {
    fun onSuccess(resultList: ArrayList<Any>) {}

}
