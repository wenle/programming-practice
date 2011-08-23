import org.easymock.EasyMock;
import org.junit.Test;
import static org.easymock.EasyMock.*;
/**
 * @file CustomMatcher.java
 * 
 * @author wbao
 * 
 * @date Jun 24, 2011
 * 
 *       Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */


public class Sample{
  
  public void print(String str){
   
    /*Maybe complicated in real production code*/
    System.out.println(str);
  }
  
  public String hi(String str){
    print("Hello, " + str);
    return str;
  }
  
  private class MyChecker implements Checker{
    public boolean check(Object expected, Object actual){
      System.out.println("you see");
      return !(actual instanceof String);
    }
  }
  
  @Test
  public void sampleTest(){
    
    Sample sampleMock = EasyMock.createMock(Sample.class);
    
    expect(sampleMock.hi(CustomMatcher.customMatcher(new MyChecker(), "xxx")));
    
    sampleMock.hi("abcde");
    
    replay(sampleMock);
    
    verify(sampleMock);
    
  }
  
 
}
