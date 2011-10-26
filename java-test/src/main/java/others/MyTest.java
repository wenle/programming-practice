package others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {

  private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
  
  public void testLogger() {
    logger.debug("THIS IS A DEBUG LOG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    logger.info("THIS IS A INFO LOG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    logger.error("THIS IS A ERROR LOG!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
  }
  
	public static void main(String[] args){
	  Object o = null;
	  Class x = null;
	  MyTest xx = new MyTest();
		System.out.println("First program in github!" + o + x);
		System.out.println("First program in github!" + xx + x);
		stringMatchTest();
		
		
	}
	
	/*
	 *  not Matches: 
	 *  fileName:/bmi/cluster/etc/csm/latest/netcfgdb.xml 
	 *  fileNamePattern:/bmi/cluster/etc/csm/latest/netcfgdb\\.xml

	 */
	
	public static void stringMatchTest() {
	  
	  if("/bmi/cluster/etc/csm/latest/netcfgdb.xml".matches("/bmi/cluster/etc/csm/latest/netcfgdb\\.xml")) {
	    System.out.println("match five2");
	  } else {
	    System.out.println("not match five2");
	  }
	  System.out.println("/bmi/cluster/etc/csm/latest/netcfgdb\\.xml");
	}
	
}
