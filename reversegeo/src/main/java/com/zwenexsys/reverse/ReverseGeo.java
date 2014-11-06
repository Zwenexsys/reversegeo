package com.zwenexsys.reverse;

import com.squareup.okhttp.OkHttpClient;
import com.zwenexsys.reverse.models.AddressComponent;
import com.zwenexsys.reverse.models.Maps;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
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

  private final OkHttpClient client = new OkHttpClient();
  private String shortName;
  private String latLng;
  private String type;

  /**
   * Accept the already concatenated string as param
   *
   * @param latLng the concatenated lat/lng string
   */
  public ReverseGeo(String latLng) {
    this.latLng = latLng;
  }

  /**
   * Accept two double latitude and longitude as param
   *
   * @param lat - latitude
   * @param lng - longitude
   */
  public ReverseGeo(double lat, double lng) {
    this.latLng = String.valueOf(lat) + "," + String.valueOf(lng);
  }

  /**
   * Return the type of location
   *
   * @return type of location
   */
  public String getType() {
    return this.type;
  }

  /**
   * Set type of location
   *
   * @param type - type of location
   */
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

  public String getAsyncShortName() {
    BaseService.buildMapsAsync().getResult(latLng, new Callback<Maps>() {
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

  public String getSyncShortName() {
    Maps maps = BaseService.buildMapsSync().getResult(latLng);

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
