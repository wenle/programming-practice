/**
* @file GenericEval.java
* 
* @author wbao
* 
* @date Oct 12, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import java.util.HashMap;


public class GenericEval {
  
  public static void main(String[] args) {
    
    HashMap map = new HashMap();
    map.put(1, 2);
    map.put("kdfjl", 0);
    test(map);
  }

  public static void test(HashMap<String, Object> aa) {
    
    
    System.out.println("xxx");
    System.out.println(aa.size());
  }
  
}
