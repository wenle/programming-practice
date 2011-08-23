/**
* @file SingletonTest.java
* 
* @author wbao
* 
* @date Aug 23, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package com.github.nexus85.programmingpractice.javatest.designpattern;

/**
 * Singleton is a type of object creation pattern
 * 1. Singleton class has only one instance
 * 2. There is only one access to the instance
 * @author wbao
 *
 */
public class Singleton {
  
  private static Singleton instance;
  
  /**
   * hide constructor
   */
  protected Singleton() {
    
  }
  
  public static Singleton getInstance() {
    
    if(instance == null) {
      instance  = new Singleton();
    }
    return instance;
  }
}
