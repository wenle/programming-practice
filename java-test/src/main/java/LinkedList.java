import java.util.List;


/**
 * @file LinkedList.java
 * 
 * @author wbao
 * 
 * @date Aug 10, 2012
 * 
 * Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */

public class LinkedList {
  
  Node head;

  public LinkedList() {
  }
  
  public LinkedList(Node head) {
    this.head = head;
  }
  
  
  public Node getHead() {
  
    return head;
  }
  
  protected void setHead(Node head) {
  
    this.head = head;
  }
  
  public void append(Node n) {
    if(head == null) {
      head = n;
    } else {
      head.setNext(n);
    }
  }
  
  public static LinkedList createLinkedList(List<Node> nodeList) {
    LinkedList ll = new LinkedList(null);
    for(Node n : nodeList) {
      ll.append(n);
    }
    return ll;
  }
  
  public void print()  {
    Node n = head;
    
    System.out.println("print linked list:");
    while(n!=null) {
      System.out.println(n.getId());
      n = n.getNext();
    }
    System.out.println("linked list end.");
  }

}
