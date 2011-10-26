/**
* @file TestLoggingInSureFireJunit.java
* 
* @author wbao
* 
* @date Oct 26, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import org.junit.Test;


public class TestLoggingInSureFireJunit {
  
  @Test
  public void testLogging() {
    new MyTest().testLogger();
  }

}
