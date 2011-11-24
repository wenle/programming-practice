/**
* @file TimestampTest.java
* 
* @author wbao
* 
* @date Nov 3, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others.protectedTest;

import others.ProtectedTest;


public class ProtectedTest2 extends ProtectedTest {
  
  public void test() {
    //this.abc = "xx"; //not visiable
    this.def = "ee";
  }
  
  @Override
  public void method1() {
    
  }
  
  @Override
  protected void method2() {
    
  }
  void method3() {
    
  }
  private void method4() {
    
  }
  
  public static void main(String[] args) {
    
    System.out.println("protected test");
    ProtectedTest2 tt = new ProtectedTest2();
    tt.test();
    
  }

}
