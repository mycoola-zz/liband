package com.liband.models;

import java.lang.System;

@androidx.room.Entity(primaryKeys = {"id", "language"})
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/liband/models/BaseModel;", "", "()V", "creationDate", "Ljava/util/Date;", "getCreationDate", "()Ljava/util/Date;", "setCreationDate", "(Ljava/util/Date;)V", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "language", "getLanguage", "()Ljava/lang/Object;", "setLanguage", "(Ljava/lang/Object;)V", "modifiedDate", "getModifiedDate", "setModifiedDate", "liband_debug"})
public final class BaseModel {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    @androidx.annotation.NonNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "language")
    @androidx.annotation.NonNull()
    private java.lang.Object language;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverters(value = {com.liband.room.converters.TimestampConverter.class})
    @androidx.room.ColumnInfo(name = "modified_date")
    private java.util.Date modifiedDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.TypeConverters(value = {com.liband.room.converters.TimestampConverter.class})
    @androidx.room.ColumnInfo(name = "creation_date")
    private java.util.Date creationDate;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getModifiedDate() {
        return null;
    }
    
    public final void setModifiedDate(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreationDate() {
        return null;
    }
    
    public final void setCreationDate(@org.jetbrains.annotations.NotNull()
    java.util.Date p0) {
    }
    
    public BaseModel() {
        super();
    }
}