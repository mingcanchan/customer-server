package com.ming.impl;
import com.ming.thrift.service.Topic;
import com.ming.thrift.service.TopicService;
import org.apache.thrift.TException;

/**
 * Created by chenmingcan on 2017/2/16.
 */
public class TopicImpl implements TopicService.Iface {
    @Override
    public void store(Topic topic) throws TException {

        System.out.println("theinput topic: ");

        System.out.println("id:"+topic.getUid());

        System.out.println("name:"+topic.getName());

        System.out.println("content:"+topic.getContent());
    }

    @Override
    public Topic retrieve(int uid) throws TException {

        System.out.println("theinput uid: "+uid);

        return new Topic(uid,"test","test");
    }
}
