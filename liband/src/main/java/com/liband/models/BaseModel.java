package com.liband.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.liband.room.converters.TimestampConverter;
import com.liband.utils.LangUtils;

import java.util.Date;


@Entity(primaryKeys = {"id", "language"})
public class BaseModel {

    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("Id")
    @Expose
    private Integer id;

    @NonNull
    @ColumnInfo(name = "language")
    private String language = LangUtils.getCurrentLanguage();

    @ColumnInfo(name = "modified_date")
    @TypeConverters({TimestampConverter.class})
    private Date modifiedDate = new Date();

    @ColumnInfo(name = "creation_date")
    @TypeConverters({TimestampConverter.class})
    private Date creationDate = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
