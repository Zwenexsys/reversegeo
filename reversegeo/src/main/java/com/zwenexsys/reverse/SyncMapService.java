package com.zwenexsys.reverse;

import com.zwenexsys.reverse.models.Maps;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public interface SyncMapService {
  @GET("/json") Maps getResult(@Query("latlng") String latLng);
}
