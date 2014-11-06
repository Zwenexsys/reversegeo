package com.zwenexsys.reverse;

import com.zwenexsys.reverse.models.Maps;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public interface AsyncMapService {
  @GET("/json") void getResult(@Query("latlng") String latLng, Callback<Maps> maps);
}
