/**
* @file Aa.java
* 
* @author wbao
* 
* @date Aug 23, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package com.github.nexus85.practice.javatest.serialization;


public class Sex {

  private String sex;
  
  public Sex() {
    this.setSex("For Test");
  }

  public void setSex(String sex) {

    this.sex = sex;
  }

  public String getSex() {

    return sex;
  }
  
}