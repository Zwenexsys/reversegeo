package com.zwenexsys.reverse.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class AddressComponent {
  @SerializedName("long_name") private String longName;
  @SerializedName("short_name") private String shortName;

  private List<String> types = new ArrayList<String>();

  /**
   * @return The longName
   */
  public String getLongName() {
    return longName;
  }

  /**
   * @param longName The long_name
   */
  public void setLongName(String longName) {
    this.longName = longName;
  }

  /**
   * @return The shortName
   */
  public String getShortName() {
    return shortName;
  }

  /**
   * @param shortName The short_name
   */
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  /**
   * @return The types
   */
  public List<String> getTypes() {
    return types;
  }

  /**
   * @param types The types
   */
  public void setTypes(List<String> types) {
    this.types = types;
  }
}
