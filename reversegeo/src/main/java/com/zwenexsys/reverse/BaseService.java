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

  public static AsyncMapService buildMapsAsync() {
    return new retrofit.RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(okHttpClient))
        .setLogLevel(retrofit.RestAdapter.LogLevel.BASIC)
        .build()
        .create(AsyncMapService.class);
  }

  public static SyncMapService buildMapsSync() {
    return new retrofit.RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(okHttpClient))
        .build()
        .create(SyncMapService.class);
  }
}
