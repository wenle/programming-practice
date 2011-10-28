/**
* @file Sort1.java
* 
* @author wbao
* 
* @date Oct 28, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package examination;

/**
 * A length-N array with value<=N numbers in it
 * How to check if there are duplicate numbers?
 * @author wbao
 *
 */

public class Sort1 {

  public static void main(String[] args) {
    
    int[] hasDupArray = new int[]{1,4,2,3,4,1};
    int[] noDupArray = new int[]{1,2,3,4,5};
    
    System.out.println("examination.Sort1:");
    
    if(!hasDuplicate(hasDupArray)) {
      System.out.println("Check error1");
    }
    if(hasDuplicate(noDupArray)) {
      System.out.println("Check error2");
    }
    
    System.out.println("end.");
  }
  
  /**
   * if has duplicate numbers, return true
   * @param array
   * @param i
   * @return
   */
  private static boolean arrange(int[] array, int i) {
    if(array[i] == i+1) {
      return false;
    }
    int current = array[i];
    while(true) {
      //loop, no duplicate
      if(current == i) {
        array[i] = current;
        return false;
      }
      //duplicate
      if(array[current-1] == current) {
        return true;
      } else {
        int temp = array[current-1];
        array[current-1] = current;
        current = temp;
      }
    }
  }
  
  /**
   * O(n)
   * @param array
   * @return
   */
  private static boolean hasDuplicate(int[] array) {
    
    if(array == null) {
      return false;
    }
    int size = array.length;
    if(size == 0) {
      return false;
    }
    for(int i=0;i<size;i++) {
      if(arrange(array, i)){
        return true;
      }
    }
    return false;
  }
  
}
