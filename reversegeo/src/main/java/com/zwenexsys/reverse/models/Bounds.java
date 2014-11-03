package com.zwenexsys.reverse.models;

import com.google.gson.annotations.Expose;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class Bounds {
  @Expose
  private Northeast northeast;
  @Expose
  private Southwest southwest;

  /**
   * @return The northeast
   */
  public Northeast getNortheast() {
    return northeast;
  }

  /**
   * @param northeast The northeast
   */
  public void setNortheast(Northeast northeast) {
    this.northeast = northeast;
  }

  /**
   * @return The southwest
   */
  public Southwest getSouthwest() {
    return southwest;
  }

  /**
   * @param southwest The southwest
   */
  public void setSouthwest(Southwest southwest) {
    this.southwest = southwest;
  }
}
