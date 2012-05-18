/**
 * @file TestSSL.java
 * 
 * @author wbao
 * 
 * @date May 17, 2012
 * 
 *       Copyright (C) 2010-2011, Bytemobile, Inc. All rights reserved.
 */

package others;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftSSL {

  private static TTransport getTransport(boolean enableSSL) throws TTransportException {
    TTransport transport;
    if (enableSSL) {
      TSSLTransportFactory.TSSLTransportParameters params =
          new TSSLTransportFactory.TSSLTransportParameters();
      params.setTrustStore("/home/user/truststore.jks", "password");
      transport = TSSLTransportFactory.getClientSocket("10.11.0.44", 55555, 10000, params);
//      transport = TSSLTransportFactory.getClientSocket("10.11.0.44", 55555);
    } else {
      transport = new TSocket("10.11.0.44", 55555);
    }
    return transport;
  }

  public static void test(boolean enableSSL) {

    System.out.println("try to connect " + (enableSSL? "through ssl" : "not through ssl"));
    try {
      TTransport transport = getTransport(enableSSL);
      if(!enableSSL) {
        transport.open();
      }
      TProtocol protocol = new TBinaryProtocol(transport);
      DetectorClient.Client client = new DetectorClient.Client(protocol);
      NeInfo info = client.GetNeInfo();
      System.out.println("api version: " + info.getApiVersion());
      System.out.println("device type: " + info.getType());
      System.out.println("product version: " + info.getProductVersion());

      transport.close();
    }
    catch (Exception e) {
      e.printStackTrace();
      System.out.println("Can't connect " + (enableSSL? "through ssl" : "not through ssl"));
    }
  }

  public static void main(String[] args) {

    test(true);
    test(false);
  }

}
