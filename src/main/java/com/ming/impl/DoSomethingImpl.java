package com.ming.impl;

import com.ming.thrift.test.DoSomething;
import org.apache.thrift.TException;

/**
 * Created by chenmingcan on 2017/2/15.
 */
public class DoSomethingImpl implements DoSomething.Iface {
    @Override
    public String doString(String word) throws TException {
        System.out.println("这里编写业务方法!!!");
        return "hello";
    }
}
