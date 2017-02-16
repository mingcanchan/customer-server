package com.ming.client;

import com.ming.thrift.test.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by chenmingcan on 2017/2/16.
 */
public class MultipleClient {

    public static void main(String[] args) {
        TSocket transport = new TSocket( "localhost" ,1234);

        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        TMultiplexedProtocol mp1 = new TMultiplexedProtocol (protocol, "Hello" );

        Hello.Client service1 = new Hello.Client(mp1);

        TMultiplexedProtocol mp2 = new TMultiplexedProtocol (protocol, "DoSomething" );

        DoSomething.Client service2 = new DoSomething.Client(mp2);

        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        try {
            service1.sayHello("hello");
//            service1.store( new Topic(668, "test topic" , "just a test!" ));
        } catch (TException e) {
            e.printStackTrace();
        }

        try {
            service2.doString("world");
//            service2.store1( new User(888, "tom" , "haha" ));
        } catch (TException e) {
            e.printStackTrace();
        }

//        try {
//            System. out .println(service1.retrieve(168));
//        } catch (TException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System. out .println(service2.retrieve1(999));
//        } catch (TException e) {
//            e.printStackTrace();
//        }

        transport.close();
    }
}

