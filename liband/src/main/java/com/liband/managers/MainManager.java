package com.liband.managers;


import com.liband.interfaces.ApiCallback;
import com.liband.interfaces.ApiDetailCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;


public interface MainManager<T> {

    boolean insertEntitiesToDB(List<T> entities);

    boolean insertEntityToDB(T entity);

    List<T> getAllEntitiesFromDB(final int pageNumber);

    List<T> getTopThreeEntities();

    void getAllEntitiesData(final int pageNumber, final ApiCallback apiCallback, final boolean isHome);

    void filterEntitiesData(final int pageNumber, int categeoryId, final ApiCallback apiCallback);

    boolean checkValidateResponce(final Response<ArrayList<T>> response);

    T getEntityDetails(final Integer id, final ApiDetailCallback apiDetailCallback);

    T getEntityDetailsFromDB(final Integer id);

    boolean isOlderData();
}
