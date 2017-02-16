package com.ming.server;

import com.ming.impl.DoSomethingImpl;
import com.ming.impl.HelloImpl;
import com.ming.thrift.test.DoSomething;
import com.ming.thrift.test.Hello;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenmingcan on 2017/2/15.
 */
public class Server {
    private final static Logger LOGGER = LoggerFactory.getLogger(Server.class);
    public void startServer() {
        try {
            System.out.println("thrift server open port 1234");
            LOGGER.info("thrift starting");
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            TServerSocket serverTransport = new TServerSocket(1234);

            TServer tServer = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            processor.registerProcessor("Hello", new Hello.Processor<Hello.Iface>(new HelloImpl()));
            processor.registerProcessor("DoSomething", new DoSomething.Processor<DoSomething.Iface>(new DoSomethingImpl()));

//            Factory portFactory = new TBinaryProtocol.Factory(true, true);
//            Args args = new Args(serverTransport);
//            args.processor(process);
//            args.protocolFactory(portFactory);
//            TServer server = new TThreadPoolServer(args);
            System.out.println("the serveris started and is listening at 1234...");
            tServer.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("thrift server init");
        Server server = new Server();
        System.out.println("thrift server start");
        server.startServer();
        System.out.println("thrift server end");
    }
}
