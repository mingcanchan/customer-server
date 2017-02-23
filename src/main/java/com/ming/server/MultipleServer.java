package com.ming.server;

import com.ming.impl.TopicImpl;
import com.ming.impl.UserImpl;
import com.ming.thrift.test.TopicService;
import com.ming.thrift.test.UserService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenmingcan on 2017/2/16.
 */
public class MultipleServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(MultipleServer.class);
    public static void main(String[] args) {
        LOGGER.info("server starting......");
        TMultiplexedProcessor processor = new TMultiplexedProcessor();
        TServerTransport t = null;
        try {
            t = new TServerSocket(9090);
        } catch (TTransportException e) {
            LOGGER.error("sever exception!!!");
            e.printStackTrace();
        }

        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(t).processor(processor));

        processor.registerProcessor("TopicService", new TopicService.Processor<TopicService.Iface>(new TopicImpl()));

        processor.registerProcessor("UserService", new UserService.Processor<UserService.Iface>(new UserImpl()));

//         TSimpleServer server = new TSimpleServer(new Args (t).processor(processor));

        LOGGER.debug("server running now");
        server.serve();
    }
}
