/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: NativeAmqProducer.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 15:15
 * @lastdate:
 */

@Component
public class NativeAmqProducer {

    @Value("${spring.activemq.broker-url}")
    private String url;

    private String des = "Test.foo";
    private String desTopic = "Test.topic";

    public boolean send(String msg){
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(des);
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage textMessage = session.createTextMessage(msg);
            messageProducer.send(textMessage);
            session.close();
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();;
        }
        return false;
    }

    public boolean sendTopic(String msg){
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(desTopic);
            MessageProducer messageProducer = session.createProducer(destination);
            //messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage textMessage = session.createTextMessage(msg);
            messageProducer.send(textMessage);
            session.close();
            connection.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();;
        }
        return false;
    }
}
