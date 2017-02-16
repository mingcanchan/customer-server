package com.ming.client;

import com.ming.thrift.test.DoSomething;
import com.ming.thrift.test.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by chenmingcan on 2017/2/15.
 */
public class Client {
    public void startClient() {
        TTransport transport;
        try {
            System.out.println("thrift client connext server at 1234 port ");
            transport = new TSocket("localhost", 1234);
            TBinaryProtocol protocol = new TBinaryProtocol(transport);
            TMultiplexedProtocol mp1 = new TMultiplexedProtocol(protocol, "Hello");
            DoSomething.Client service1 = new DoSomething.Client(mp1);
            TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol, "DoSomething");
            Hello.Client service2 = new Hello.Client(mp2);
            transport.open();
            System.out.println(service2.sayHello("mingcanchen"));
            System.out.println(service1.doString("hello world"));
            transport.close();
            System.out.println("thrift client close connextion");
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("thrift client init ");
        Client client = new Client();
        System.out.println("thrift client start ");
        client.startClient();
        System.out.println("thrift client end ");
    }
}
