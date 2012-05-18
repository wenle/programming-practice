/**
* @file FutureCancelTest.java
* 
* @author wbao
* 
* @date Feb 2, 2012
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureCancelTest {
  
  public static void main(String[] args) throws InterruptedException {
    
    Task t = new Task();
    
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future f = executor.submit(t);
    f.cancel(true);
    
    System.out.println("Is it stopped?");
    executor.shutdown();
  }

}
