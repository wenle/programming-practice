package others;

import java.util.Date;

public class MyTest {
  
  private int a;
  private String b;
  
  {
    a = 1;
    b = "hello";
  }
  
  public void abc(int a, long... b) {
    
    if(b == null) {
      System.out.print("===============!!!!");
      
    } else if(b.length == 0) {
      System.out.print("!!!!");
    } 
    
  }
  
  
  public MyTest() {
    System.out.println("Initialized without parameter");
    abc(1);
  }
  
  public MyTest(int i) {
    System.out.println("Initialized with one int parameter");
  }
  
  public void test() {
    
    class abc {
      
    }
    
  }

	public static void main(String[] args){
	  
	  Class ret = TestInterface.class.getMethods()[0].getReturnType();
	  if(ret.getComponentType() == byte.class) {
	    System.out.println("return is a byte type ");
	  }
	  System.out.println("return: " + ret);
	  
	  
	}
	
}
