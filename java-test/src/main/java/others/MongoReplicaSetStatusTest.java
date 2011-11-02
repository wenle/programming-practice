/**
* @file AutoIncrementTest.java
* 
* @author wbao
* 
* @date May 13, 2011
* 
* Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
*/

package others;

import java.util.Iterator;

import org.bson.BSONObject;
import org.junit.Test;

import com.mongodb.BasicDBList;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import com.mongodb.ReplicaSetStatus;

public class MongoReplicaSetStatusTest {

  @Test
  public void testGetMongoNodeStatus() throws Exception{
    
    MongoURI uri = new MongoURI("mongodb://10.11.0.22:27017/EMSDB");
    Mongo mongo = new Mongo(uri);
    
    ReplicaSetStatus status = mongo.getReplicaSetStatus();
    DB emsdb = mongo.getDB("admin");
    CommandResult result = emsdb.command("replSetGetStatus");
    BasicDBList list = (BasicDBList)result.get("members");
    if(!list.isEmpty()) {
      Iterator it = list.iterator();
      System.out.println("Node status:");
      while(it.hasNext()) {
        BSONObject obj = (BSONObject)it.next();
        System.out.println();
        System.out.println("name: " + obj.get("name"));
        System.out.println("state: " +obj.get("state"));
        System.out.println("health: " +obj.get("health"));
        System.out.println("errmsg: " +obj.get("errmsg"));
      }
    }
  }
  
}
