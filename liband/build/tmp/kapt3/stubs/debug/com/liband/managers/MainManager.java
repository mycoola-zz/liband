package com.liband.managers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\fH&J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014H&J$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0016\u001a\u00020\u0004H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J#\u0010\u0018\u001a\u00028\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH&\u00a2\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u00028\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H&J\u0015\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010#R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006$"}, d2 = {"Lcom/liband/managers/MainManager;", "T", "", "isOlderData", "", "()Z", "topThreeEntities", "", "getTopThreeEntities", "()Ljava/util/List;", "checkValidateResponce", "response", "Lretrofit2/Response;", "Ljava/util/ArrayList;", "filterEntitiesData", "", "pageNumber", "", "categeoryId", "apiCallback", "Lcom/liband/interfaces/ApiCallback;", "getAllEntitiesData", "isHome", "getAllEntitiesFromDB", "getEntityDetails", "id", "apiDetailCallback", "Lcom/liband/interfaces/ApiDetailCallback;", "(Ljava/lang/Integer;Lcom/liband/interfaces/ApiDetailCallback;)Ljava/lang/Object;", "getEntityDetailsFromDB", "(Ljava/lang/Integer;)Ljava/lang/Object;", "insertEntitiesToDB", "entities", "insertEntityToDB", "entity", "(Ljava/lang/Object;)Z", "liband_debug"})
public abstract interface MainManager<T extends java.lang.Object> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<T> getTopThreeEntities();
    
    public abstract boolean isOlderData();
    
    public abstract boolean insertEntitiesToDB(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> entities);
    
    public abstract boolean insertEntityToDB(T entity);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<T> getAllEntitiesFromDB(int pageNumber);
    
    public abstract void getAllEntitiesData(int pageNumber, @org.jetbrains.annotations.NotNull()
    com.liband.interfaces.ApiCallback<?> apiCallback, boolean isHome);
    
    public abstract void filterEntitiesData(int pageNumber, int categeoryId, @org.jetbrains.annotations.NotNull()
    com.liband.interfaces.ApiCallback<?> apiCallback);
    
    public abstract boolean checkValidateResponce(@org.jetbrains.annotations.NotNull()
    retrofit2.Response<java.util.ArrayList<T>> response);
    
    public abstract T getEntityDetails(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id, @org.jetbrains.annotations.NotNull()
    com.liband.interfaces.ApiDetailCallback<?> apiDetailCallback);
    
    public abstract T getEntityDetailsFromDB(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id);
}