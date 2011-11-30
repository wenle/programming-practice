/**
 *      Copyright (C) 2008 10gen Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package others;

import java.util.*;
import java.net.*;

import com.mongodb.*;
import com.mongodb.util.*;


public class Capped {

    public static void main(String[] args) 
        throws MongoException , UnknownHostException {

        MongoURI uri = new MongoURI("mongodb://10.11.0.52:27017/test");
        DB db = new Mongo(uri).getDB("test");
        DBObject foo = new BasicDBObject();
        foo.put( "create", "capped1" );
        foo.put( "capped", true );
        foo.put( "size", 100000000 );
        DBObject dbobj = db.command( foo );
        DBCollection c = db.getCollection( "capped1" );
        
        DBObject obj = new BasicDBObject();
        Date begin = new Date();
        for(int i=1;i<=1000000;i++) {
          obj.removeField("x");
          obj.put("x", i);
          c.insert(obj);
        }
        Date end = new Date();
        System.out.println("One by one:" + ((end.getTime()-begin.getTime())/1000));


        DBObject foo2 = new BasicDBObject();
        foo.put( "create", "capped2" );
        foo.put( "capped", true );
        foo.put( "size", 100000000 );
        DBObject dbobj2 = db.command( foo );
        DBCollection c2 = db.getCollection( "capped2" );
        

        begin = new Date();
        for(int i=1;i<=1000;i++) {
          List<DBObject> list = new ArrayList<DBObject>(1000);
          for(int j=1;j<=1000;j++) {
            DBObject dbo = new BasicDBObject();
            dbo.put("x", j+(i-1)*1000);
            list.add(dbo);
          }
          c2.insert(list);
        }
        end = new Date();
        System.out.println("Batch(per 1000):" + ((end.getTime()-begin.getTime())/1000));
    }
}
