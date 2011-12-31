/**
* @file Dummy.java
* 
* @author wbao
* 
* @date Dec 21, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package mongo;

import java.sql.Timestamp;
import java.util.Date;


public class Dummy {

  private Date date;
  private java.sql.Timestamp ts;
  
  public Dummy(Date date, Timestamp ts) {

    this.date = date;
    this.ts = ts;
  }

  public Date getDate() {
  
    return date;
  }
  
  public void setDate(Date date) {
  
    this.date = date;
  }
  
  public java.sql.Timestamp getTs() {
  
    return ts;
  }
  
  public void setTs(java.sql.Timestamp ts) {
  
    this.ts = ts;
  }
  
  
}
