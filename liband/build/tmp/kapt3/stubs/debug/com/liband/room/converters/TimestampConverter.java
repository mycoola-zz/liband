package com.liband.room.converters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/liband/room/converters/TimestampConverter;", "", "()V", "dateToTimestamp", "", "dateFormat", "Ljava/text/DateFormat;", "value", "Ljava/util/Date;", "fromTimestamp", "liband_debug"})
public final class TimestampConverter {
    public static final com.liband.room.converters.TimestampConverter INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.util.Date fromTimestamp(@org.jetbrains.annotations.NotNull()
    java.text.DateFormat dateFormat, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String dateToTimestamp(@org.jetbrains.annotations.NotNull()
    java.text.DateFormat dateFormat, @org.jetbrains.annotations.Nullable()
    java.util.Date value) {
        return null;
    }
    
    private TimestampConverter() {
        super();
    }
}