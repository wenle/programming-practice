/**
* @file Student.java
* 
* @author wbao
* 
* @date Aug 23, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

public class Student {

  private static final long serialVersionUID = 1L;
  private String name;
  private int id;
  private Sex sex;
  
  /**
   * conclusion: this constructor is called when deserialization
   * */
  public Student() {
    this.name = "test";
    this.id = 0;
    this.sex = new Sex();
  }
  
  public Student(String name, int id) {
    this.name = name;
    this.id = id;
    this.sex = new Sex();
  }
  
  public String getName() {
  
    return name;
  }
  
  public void setName(String name) {
  
    this.name = name;
  }
  
  public int getId() {
  
    return id;
  }
  
  public void setId(int id) {
  
    this.id = id;
  }
  
  public String toString() {
    return "Stdent: " + this.name + ", id: " + this.id + ", aa: " + this.sex.getSex();
  }
  
}
