package com.zwenexsys.reverse.models;

import com.google.gson.annotations.Expose;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class Location {
  @Expose
  private Double lat;
  @Expose
  private Double lng;

  /**
   * @return The lat
   */
  public Double getLat() {
    return lat;
  }

  /**
   * @param lat The lat
   */
  public void setLat(Double lat) {
    this.lat = lat;
  }

  /**
   * @return The lng
   */
  public Double getLng() {
    return lng;
  }

  /**
   * @param lng The lng
   */
  public void setLng(Double lng) {
    this.lng = lng;
  }
}
