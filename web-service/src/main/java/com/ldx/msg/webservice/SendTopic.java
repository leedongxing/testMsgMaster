/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: SendTopic.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 22:39
 * @lastdate:
 */

public class SendTopic {
    private static final String url = "tcp://localhost:61616";
    private static final String TOPIC_NAME = "choice.topic";
    //private String expectedBody = "<hello>world!two</hello>";
    //private String expectedBody = "stop";

    public void sendMessage() throws JMSException {
        Connection connection = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    url);
            connection = (Connection) connectionFactory.createConnection();
            connection.start();
            Session session = (Session) connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(TOPIC_NAME);
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//			TextMessage message = session.createTextMessage(expectedBody);
//			message.setStringProperty("headname", "remoteB");
            JmsTestMessage testMessage = new JmsTestMessage();
            testMessage.setId("1234567");
            testMessage.setMsg("stop");
            testMessage.setStatus(1);
            ObjectMessage message = session.createObjectMessage(testMessage);
            producer.send(message);
            producer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendTopic sndMsg = new SendTopic();
        try {
            sndMsg.sendMessage();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
