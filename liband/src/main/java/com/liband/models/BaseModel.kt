package com.liband.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.liband.room.converters.TimestampConverter
import com.liband.utils.LangUtils
import java.util.*


@Entity(primaryKeys = arrayOf("id", "language"))
internal class BaseModel {

    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("Id")
    @Expose
    var id: Int? = null

    @NonNull
    @ColumnInfo(name = "language")
    var language = LangUtils.currentLanguage

    @ColumnInfo(name = "modified_date")
    @TypeConverters(TimestampConverter::class)
    var modifiedDate = Date()

    @ColumnInfo(name = "creation_date")
    @TypeConverters(TimestampConverter::class)
    var creationDate = Date()
}
