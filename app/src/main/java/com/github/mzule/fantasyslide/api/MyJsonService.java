package com.github.mzule.fantasyslide.api;

/**
 * Created by scheng on 3/11/17.
 */

import com.github.mzule.fantasyslide.model.Event;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Raquib-ul-Alam Kanak on 1/3/16.
 * Website: http://alamkanak.github.io
 */
public interface MyJsonService {

    @GET("/1kpjf")
    void listEvents(Callback<List<Event>> eventsCallback);

}