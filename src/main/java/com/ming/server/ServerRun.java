package com.ming.server;

import com.ming.commons.BaseServer;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

/**
 * Created by chenmingcan on 2017/2/13.
 */
public class ServerRun extends BaseServer{

    private int SERVER_PORT;

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseServer.class);
    public void run() {
        try {

            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            TServerTransport t = new TServerSocket(SERVER_PORT);
            InetAddress addr = InetAddress.getLocalHost();
            String ip = addr.getHostAddress().toString();
//            ProductLogic productLogic = new ProductLogicImpl();
//            productLogic.registerProductService(ip + ":" + SERVER_PORT);
            LOGGER.info("the service register at " + ip + ":" + SERVER_PORT + "...");
        } catch(Exception e){
            LOGGER.info("the service register ip:port error ...");
        }
    }
    @Override
    public void reinitialize() {

    }

    @Override
    public void stop() {

    }
}
