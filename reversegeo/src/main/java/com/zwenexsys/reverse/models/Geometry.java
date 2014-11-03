package com.zwenexsys.reverse.models;

import android.location.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class Geometry {
  @Expose
  private Bounds bounds;
  @Expose
  private Location location;
  @SerializedName("location_type") @Expose
  private String locationType;
  @Expose
  private Viewport viewport;


  /**
   * @return The bounds
   */
  public Bounds getBounds() {
    return bounds;
  }

  /**
   * @param bounds The bounds
   */
  public void setBounds(Bounds bounds) {
    this.bounds = bounds;
  }

  /**
   * @return The location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location The location
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return The locationType
   */
  public String getLocationType() {
    return locationType;
  }

  /**
   * @param locationType The location_type
   */
  public void setLocationType(String locationType) {
    this.locationType = locationType;
  }

  /**
   *
   * @return
   * The viewport
   */
  public Viewport getViewport() {
    return viewport;
  }

  /**
   *
   * @param viewport
   * The viewport
   */
  public void setViewport(Viewport viewport) {
    this.viewport = viewport;
  }

}
