package com.liband.managers


import com.liband.interfaces.ApiCallback
import com.liband.interfaces.ApiDetailCallback
import retrofit2.Response
import java.util.*


interface MainManager<T> {

    val topThreeEntities: List<T>

    val isOlderData: Boolean

    fun insertEntitiesToDB(entities: List<T>): Boolean

    fun insertEntityToDB(entity: T): Boolean

    fun getAllEntitiesFromDB(pageNumber: Int): List<T>

    fun getAllEntitiesData(pageNumber: Int, apiCallback: ApiCallback<*>, isHome: Boolean)

    fun filterEntitiesData(pageNumber: Int, categeoryId: Int, apiCallback: ApiCallback<*>)

    fun checkValidateResponce(response: Response<ArrayList<T>>): Boolean

    fun getEntityDetails(id: Int?, apiDetailCallback: ApiDetailCallback<*>): T

    fun getEntityDetailsFromDB(id: Int?): T
}
