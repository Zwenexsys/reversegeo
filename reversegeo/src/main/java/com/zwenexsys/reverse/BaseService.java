package com.zwenexsys.reverse;

import com.squareup.okhttp.OkHttpClient;
import retrofit.client.OkClient;

/**
 * Created by Ye Lin Aung on 14/11/07.
 */
public class BaseService {

  private static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/";
  private static OkHttpClient okHttpClient = new OkHttpClient();

  public BaseService() {
  }

  public static MapServiceAsync buildMapsAsync() {
    return new retrofit.RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(okHttpClient))
        .setLogLevel(retrofit.RestAdapter.LogLevel.BASIC)
        .build()
        .create(MapServiceAsync.class);
  }

  public static MapServiceSync buildMapsSync() {
    return new retrofit.RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(okHttpClient))
        .build()
        .create(MapServiceSync.class);
  }
}
