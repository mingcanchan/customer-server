package com.ming.impl;

import com.ming.thrift.test.Hello;
import org.apache.thrift.TException;

/**
 * Created by chenmingcan on 2017/2/15.
 */
public class HelloImpl implements Hello.Iface {
    private static int count = 0;

    @Override
    public String sayHello(String word) throws TException {
        // TODO Auto-generated method stub
        count += 1;
        System.out.println("get " + word + " " +count);
        return "hello " + word + " " + count;
    }
}
