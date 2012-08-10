
/**
 * @file Test.java
 * 
 * @author wbao
 * 
 * @date Aug 10, 2012
 * 
 * Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */

public class Test {
  
  public static void main(String[] args) {
    
   LinkedList ll = new LinkedList();
   Node pre = new Node(0);
   ll.setHead(pre);
   for(int i=1; i<10; i++) {
     Node n = new Node(i);
     pre.setNext(n);
     pre = n;
   }
   
   System.out.println("Before reverse:");
   ll.print();
   
   System.out.println();
   
   new Reverser().reverse(ll);

   System.out.println();
   
   System.out.println("After reverse:");
   ll.print();
    
  }

}
