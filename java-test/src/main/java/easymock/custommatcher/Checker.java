package easymock.custommatcher;
/**
* @file CheckMethod.java
* 
* @author wbao
* 
* @date Jun 28, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/


public interface Checker {
  /*
   * The method should never assert. It should only return true or false. 
   * AssertionError in this method will make JUnit stop at current test case. 
   */
  boolean check(Object expected, Object actual);
}