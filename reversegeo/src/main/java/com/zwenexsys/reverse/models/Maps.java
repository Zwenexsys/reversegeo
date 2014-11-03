package com.zwenexsys.reverse.models;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ye Lin Aung on 14/11/02.
 */
public class Maps {
  @Expose
  private List<Result> results = new ArrayList<Result>();
  @Expose
  private String status;

  /**
   * @return The results
   */
  public List<Result> getResults() {
    return results;
  }

  /**
   * @param results The results
   */
  public void setResults(List<Result> results) {
    this.results = results;
  }

  /**
   * @return The status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status The status
   */
  public void setStatus(String status) {
    this.status = status;
  }
}
