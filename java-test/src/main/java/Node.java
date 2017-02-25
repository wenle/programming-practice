
/**
 * @file Node.java
 * 
 * @author wbao
 * 
 * @date Aug 10, 2012
 * 
 */

public class Node {

  private int id;
  Node next;
  
  
  public Node(int id) {
    this.id = id;
    this.next = null;
  }
  
  public int getId() {
  
    return id;
  }

  
  public void setId(int id) {
  
    this.id = id;
  }
  
  public Node getNext() {
  
    return next;
  }

  
  public void setNext(Node next) {
  
    this.next = next;
  }
  
}
