/**
 * @file Task.java
 * 
 * @author wbao
 * 
 * @date Feb 2, 2012
 * 
 *       Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */

package others;

public class Task implements Runnable {

  public void run() {

    int counter = 0;

    while (true) {
      
      if(Thread.interrupted()) {
        return;
      }

      if ((counter++) % 1000 == 0) {
        System.out.print(">");
      }
      if (counter == Integer.MAX_VALUE) {
        counter = 0;
      }
    }

  }

}
