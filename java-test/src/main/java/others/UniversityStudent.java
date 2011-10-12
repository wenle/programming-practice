/**
* @file UniversityStudent.java
* 
* @author wbao
* 
* @date Aug 23, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import java.io.Serializable;


public class UniversityStudent extends Student implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private String university;

  public UniversityStudent(String name, int id) {

    super(name, id);
    this.setUniversity("test university");
  }
  
  public UniversityStudent(String name, int id, String university) {

    super(name, id);
    this.setUniversity(university);
  }

  public void setUniversity(String university) {

    this.university = university;
  }

  public String getUniversity() {

    return university;
  }
  
  public String toString() {
    
    return super.toString() + ", university: " + this.university;
  }

}
