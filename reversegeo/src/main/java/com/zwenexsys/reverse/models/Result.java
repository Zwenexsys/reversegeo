package com.zwenexsys.reverse.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class Result {
  @SerializedName("address_components")
  private List<AddressComponent> addressComponents = new ArrayList<AddressComponent>();
  @SerializedName("formatted_address")
  private String formattedAddress;

  private Geometry geometry;
  private List<String> types = new ArrayList<String>();

  /**
   * @return The addressComponents
   */
  public List<AddressComponent> getAddressComponents() {
    return addressComponents;
  }

  /**
   * @param addressComponents The address_components
   */
  public void setAddressComponents(List<AddressComponent> addressComponents) {
    this.addressComponents = addressComponents;
  }

  /**
   * @return The formattedAddress
   */
  public String getFormattedAddress() {
    return formattedAddress;
  }

  /**
   * @param formattedAddress The formatted_address
   */
  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }

  /**
   * @return The geometry
   */
  public Geometry getGeometry() {
    return geometry;
  }

  /**
   * @param geometry The geometry
   */
  public void setGeometry(Geometry geometry) {
    this.geometry = geometry;
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
