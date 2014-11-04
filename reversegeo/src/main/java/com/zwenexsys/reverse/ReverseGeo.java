package com.zwenexsys.reverse;

import com.squareup.okhttp.OkHttpClient;
import com.zwenexsys.reverse.models.AddressComponent;
import com.zwenexsys.reverse.models.Maps;
import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class ReverseGeo {

  // There are more attributes depends on location
  public static final String ROUTE = "route";
  public static final String NEIGHBORHOOD = "neighborhood";
  public static final String SUBLOCALITY = "sublocality";
  public static final String LOCALITY = "locality";
  public static final String COUNTRY = "country";

  private static final String BASE_URL = "http://maps.googleapis.com/maps/api/geocode/";
  private final OkHttpClient client = new OkHttpClient();
  private String shortName;
  private String latLng;
  private String type;

  public ReverseGeo(String latLng) {
    this.latLng = latLng;
  }

  public ReverseGeo(double lat, double lng) {
    this.latLng = String.valueOf(lat) + "," + String.valueOf(lng);
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    if (type == null) {
      throw new NullPointerException("Type may not be null.");
    } else if (type.equals(ROUTE)) {
      this.type = ROUTE;
    } else if (type.equals(NEIGHBORHOOD)) {
      this.type = NEIGHBORHOOD;
    } else if (type.equals(SUBLOCALITY)) {
      this.type = SUBLOCALITY;
    } else if (type.equals(LOCALITY)) {
      this.type = LOCALITY;
    } else if (type.equals(COUNTRY)) {
      this.type = COUNTRY;
    } else {
      this.type = LOCALITY;
    }
  }

  public String getShortNameAsync() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(client))
        .setLogLevel(RestAdapter.LogLevel.BASIC)
        .build();

    MapServiceAsync service = restAdapter.create(MapServiceAsync.class);
    service.getResult(latLng, new Callback<Maps>() {
      @Override public void success(Maps maps, Response response) {
        List<AddressComponent> components = maps.getResults().get(0).getAddressComponents();
        for (AddressComponent component : components) {
          List<String> types = component.getTypes();
          for (String s : types) {
            if (type.equalsIgnoreCase(ROUTE) && s.equalsIgnoreCase(ROUTE)) {
              shortName = component.getShortName();
            } else if (type.equalsIgnoreCase(NEIGHBORHOOD) && s.equalsIgnoreCase(NEIGHBORHOOD)) {
              shortName = component.getShortName();
            } else if (type.equalsIgnoreCase(LOCALITY) && s.equalsIgnoreCase(LOCALITY)) {
              shortName = component.getShortName();
            } else if (type.equalsIgnoreCase(COUNTRY) && s.equalsIgnoreCase(COUNTRY)) {
              shortName = component.getShortName();
            }
          }
        }
      }

      @Override public void failure(RetrofitError error) {
        error.printStackTrace();
      }
    });

    return shortName;
  }

  public String getShortNameSync() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL)
        .setClient(new OkClient(client))
        .setLogLevel(RestAdapter.LogLevel.BASIC)
        .build();

    MapServiceSync service = restAdapter.create(MapServiceSync.class);
    Maps maps = service.getResult(latLng);

    List<AddressComponent> components = maps.getResults().get(0).getAddressComponents();
    for (AddressComponent component : components) {
      List<String> types = component.getTypes();
      for (String s : types) {
        if (type.equalsIgnoreCase(ROUTE) && s.equalsIgnoreCase(ROUTE)) {
          shortName = component.getShortName();
        } else if (type.equalsIgnoreCase(NEIGHBORHOOD) && s.equalsIgnoreCase(NEIGHBORHOOD)) {
          shortName = component.getShortName();
        } else if (type.equalsIgnoreCase(LOCALITY) && s.equalsIgnoreCase(LOCALITY)) {
          shortName = component.getShortName();
        } else if (type.equalsIgnoreCase(COUNTRY) && s.equalsIgnoreCase(COUNTRY)) {
          shortName = component.getShortName();
        }
      }
    }

    return shortName;
  }
}
