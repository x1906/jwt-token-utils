package com.ybveg.jwt;

import java.io.Serializable;

/**
 * @auther zbb
 * @create 2017/8/8
 */
public class Token implements Serializable {

  private static final long serialVersionUID = 6434548804089711719L;

  /**
   * ID
   */
  private String id;

  private String dataCode;

  private String depId;

  private String type;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDataCode() {
    return dataCode;
  }

  public void setDataCode(String dataCode) {
    this.dataCode = dataCode;
  }

  public String getDepId() {
    return depId;
  }

  public void setDepId(String depId) {
    this.depId = depId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
