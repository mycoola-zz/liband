package com.liband.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/liband/interfaces/ApiCallback;", "T", "Lcom/liband/interfaces/FailureListener;", "onSuccess", "", "resultList", "Ljava/util/ArrayList;", "liband_debug"})
public abstract interface ApiCallback<T extends java.lang.Object> extends com.liband.interfaces.FailureListener {
    
    public abstract void onSuccess(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<T> resultList);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static <T extends java.lang.Object>void onSuccess(com.liband.interfaces.ApiCallback<T> $this, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<T> resultList) {
        }
        
        @java.lang.Override()
        public static <T extends java.lang.Object>void onFailure(com.liband.interfaces.ApiCallback<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
    }
}