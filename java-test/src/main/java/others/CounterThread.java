/**
* @file CounterThread.java
* 
* @author wbao
* 
* @date Nov 28, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

class CounterThread extends Thread {
  String name;
  public CounterThread(String name) {
    super();
    this.name = name;
    
  }

  public void run() {
    int count = 0;
    while (true) {
      try {
        sleep(100);
      } catch (InterruptedException e) {
      }
      if (count == 50000)
        count = 0;
      System.out.println(name+":" + count++);
    }
  }
  
  public static void main(String[] args) {
    CounterThread thread1 = new CounterThread("thread1");
    thread1.setPriority(10);
    CounterThread thread2 = new CounterThread("thread2");
    thread2.setPriority(1);
    thread2.start();
    thread1.start();
  }
}


