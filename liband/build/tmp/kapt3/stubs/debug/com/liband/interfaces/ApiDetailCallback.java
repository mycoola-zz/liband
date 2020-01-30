package com.liband.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/liband/interfaces/ApiDetailCallback;", "T", "Lcom/liband/interfaces/FailureListener;", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "liband_debug"})
public abstract interface ApiDetailCallback<T extends java.lang.Object> extends com.liband.interfaces.FailureListener {
    
    public abstract void onSuccess(T result);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        public static <T extends java.lang.Object>void onSuccess(com.liband.interfaces.ApiDetailCallback<T> $this, T result) {
        }
        
        @java.lang.Override()
        public static <T extends java.lang.Object>void onFailure(com.liband.interfaces.ApiDetailCallback<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
    }
}