/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: SpringAmqProducer.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 20:03
 * @lastdate:
 */

@Component
public class SpringAmqProducer {
    @Resource
    private JmsTemplate jmsTemplate;

    private String des = "Test.foo";

    public boolean send(final String msg){
        jmsTemplate.send(des,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        return true;
    }
}
