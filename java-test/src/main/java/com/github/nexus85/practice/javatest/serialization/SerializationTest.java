/**
* @file SerializationTest.java
* 
* @author wbao
* 
* @date Aug 23, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package com.github.nexus85.practice.javatest.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationTest {
  
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    SerializationTest test = new SerializationTest();
    String file = test.createTmpFile();
    test.serialize(file);
    test.deserialize(file);
  }
  
  public String createTmpFile(){
    
    return "/tmp/SerializationTest." + System.currentTimeMillis();
  }
  
  public void serialize(String file) throws IOException {
    
    FileOutputStream outstream = new FileOutputStream(file);
    ObjectOutputStream out = new ObjectOutputStream(outstream);
    UniversityStudent stu = new UniversityStudent("William", 123);
    System.out.println("Before serialization: " + stu.toString());
    out.writeObject(stu);
  }
  
  public void deserialize(String file) throws IOException, ClassNotFoundException {
    
    FileInputStream instream = new FileInputStream(file);
    ObjectInputStream in = new ObjectInputStream(instream);
    UniversityStudent stu = (UniversityStudent)in.readObject();
    System.out.println("After serialization" + stu.toString());
  }
  
}
