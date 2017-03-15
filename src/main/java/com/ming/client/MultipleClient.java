package com.ming.client;

import com.ming.thrift.service.Topic;
import com.ming.thrift.service.TopicService;
import com.ming.thrift.service.User;
import com.ming.thrift.service.UserService;
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

        TSocket transport = new TSocket( "192.168.62.224" ,9090);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol mp1 = new TMultiplexedProtocol (protocol, "TopicService" );
        TopicService.Iface service1 = new TopicService.Client(mp1);
        TMultiplexedProtocol mp2 = new TMultiplexedProtocol (protocol, "UserService" );
        UserService.Iface service2 = new UserService.Client(mp2);

        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        try {
//            service1.sayHello("hello");
            service1.store( new Topic(668, "test topic" , "just a test!" ));
        } catch (TException e) {
            e.printStackTrace();
        }

        try {
//            service2.doString("world");
            service2.store1( new User(888, "tom" , "haha" ));
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

