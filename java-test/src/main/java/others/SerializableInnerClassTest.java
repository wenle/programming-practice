/**
* @file SerializableInnerClassTest.java
* 
* @author wbao
* 
* @date Sep 29, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.ObjectOutputStream;  
import java.io.Serializable;  
import java.util.concurrent.TimeUnit;

import org.junit.Test;

  
  
public class SerializableInnerClassTest implements Serializable
{  
    
  //enum is Serializable
  public static enum Strategy {
    MEMBER,
    KEY,
    ANY_MEMBER,
    LOCAL // default option
  };
  
  private Strategy abc = Strategy.ANY_MEMBER;
  private TimeUnit unit = TimeUnit.DAYS;
  
    class Person implements Serializable{  
        String name;  
        String password;  
        public String getName()  
        {  
            return name;  
        }  
        public void setName(String name)  
        {  
            this.name = name;  
        }  
        public String getPassword()  
        {  
            return password;  
        }  
        public void setPassword(String password)  
        {  
            this.password = password;  
        }  
    }  
      
    @Test
    public void testSerializable(){  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        ObjectOutputStream oos;  
        try  
        {  
            oos = new ObjectOutputStream(out);  
            oos.writeObject(new Person());  
            oos.close();  
        }  
        catch (IOException e)  
        {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        assertTrue(out.toByteArray().length > 0);     
    }  
}  