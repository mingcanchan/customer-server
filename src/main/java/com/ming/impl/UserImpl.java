package com.ming.impl;

import com.ming.thrift.test.User;
import com.ming.thrift.test.UserService;
import org.apache.thrift.TException;

/**
 * Created by chenmingcan on 2017/2/16.
 */
public class UserImpl implements UserService.Iface{
    @Override
    public void store1(User user) throws TException {
        System.out.println("theinput user: ");

        System.out.println("uid:"+user.getUid());

        System.out.println("name:"+user.getName());

        System.out.println("blur:"+user.getBlurb());
    }

    @Override
    public User retrieve1(int uid) throws TException {

        System.out.println("theinput uid: "+uid);

        return new User(uid,"tom","123");
    }
}
