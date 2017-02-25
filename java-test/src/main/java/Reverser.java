
/**
 * @file Reverser.java
 * 
 * @author wbao
 * 
 * @date Aug 10, 2012
 * 
 */

public class Reverser {

  public static void reverse(LinkedList list) {
    
    if(list == null || list.getHead() == null) {
      return;
    }

    Node pre = null;
    Node current = list.getHead();
    Node head = current;
    
    while(current != null) {
      
      Node currentNext = current.getNext();
      current.setNext(pre);
      
      head = current;
      pre = current;
      current = currentNext;
    }
    
    list.setHead(head);
  }
  
}
