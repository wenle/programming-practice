/**
* @file Prime.java
* 
* @author wbao
* 
* @date Nov 2, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package examination;


public class PrimeNumber {
  
  public static void main(String[] args) {
    
    for(int i=2;i<Integer.MAX_VALUE;i++) {
      if(prime(i)) {
        System.out.println(i);
      }
    }
    
    
  }
  
  private static boolean prime(int n) {
    int middle = (int)Math.sqrt(n);
    for(int i=2;i<=middle;i++) {
      if(n%i == 0) {
        return false;
      }
    }
    return true;
  }

}
