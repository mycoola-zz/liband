package com.liband.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.liband.room.converters.TimestampConverter;
import com.liband.utils.LangUtils;

import java.util.Date;


@Entity(primaryKeys = {"id", "language"})
class BaseModel {

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
