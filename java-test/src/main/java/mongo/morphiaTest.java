/**
* @file morphiaTest.java
* 
* @author wbao
* 
* @date Dec 21, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package mongo;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import com.google.code.morphia.AdvancedDatastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;


public class morphiaTest {
    
  private Mongo mongo;
  private AdvancedDatastore ads;
  private DB db;

  public morphiaTest() {
    MongoURI uri = new MongoURI("mongodb://127.0.0.1:9488/test");
    try {
      mongo = new Mongo(uri);
    }
    catch (MongoException e) {
      e.printStackTrace();
      return;
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
      return;
    }
    Morphia morphia = new Morphia();
    if(uri.getUsername() == null){
    //connect to database
      ads = (AdvancedDatastore) morphia.createDatastore(mongo, uri.getDatabase());
    }else{
      //connect to database and do authentication
      ads = (AdvancedDatastore) morphia.createDatastore(mongo, uri.getDatabase(), uri.getUsername(), uri.getPassword());
    }
    db = mongo.getDB("test");
  }
  
  public void test() {
    Dummy d1 = new Dummy(new Date(1L), new Timestamp(1L));
    Dummy d2 = new Dummy(new Date(10L), new Timestamp(10L));
    Dummy d3 = new Dummy(new Date(100L), new Timestamp(100L));
    ads.save(d1);
    ads.save(d2);
    ads.save(d3);
    
    long count = 0;
    Query q = ads.createQuery(Dummy.class);
    q.criteria("ts").lessThan(new Timestamp(100L));
    count = q.countAll();
    System.out.println("========>" + count);

    count = 0;
    q = ads.createQuery(Dummy.class);
    q.criteria("ts").greaterThan(new Timestamp(100L));
    count = q.countAll();
    System.out.println("========>" + count);
  }
  
  public void test2() {
    
  }
  
  public static void main(String[] args) {
    new morphiaTest().test();
  }
  
}
