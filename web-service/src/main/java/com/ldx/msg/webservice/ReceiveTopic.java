/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: ReceiveTopic.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 22:41
 * @lastdate:
 */

public class ReceiveTopic implements MessageListener {
    private static final String url = "tcp://localhost:61616";
    private static final String TOPIC_NAME = "choice.topic";

    private boolean stop = false;

    public void receiveMessage() {
        (new Thread(new ReceiveTopicRunnable())).start();
    }

    public void onMessage(Message message) {
//		try {
//			if (message instanceof TextMessage) {
//				TextMessage txtMsg = (TextMessage) message;
//				String msg = txtMsg.getText();
//				System.out.println("Received: " + msg);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage objMsg = (ObjectMessage)message;
                Serializable obj = objMsg.getObject();
                if (obj instanceof JmsTestMessage) {
                    JmsTestMessage testMessage = (JmsTestMessage)obj;
                    System.out.println("Received new msg id is " + testMessage.getId() + ",msg is " + testMessage.getMsg() + ",status is " + testMessage.getStatus());
                    if ("stop".equals(testMessage.getMsg())) {
                        this.stop = true;
                    }
                } else {
                    System.out.println("it is not JmsTestMessage");
                }

            } else {
                System.out.println("other type message with type is " + message.getJMSType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ReceiveTopic rm = new ReceiveTopic();
        rm.receiveMessage();
    }

    private class ReceiveTopicRunnable implements Runnable {

        public void run() {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    url);
            try {
                connection = connectionFactory.createConnection();
                Session session = connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);
                Topic topic = session.createTopic(TOPIC_NAME);
                MessageConsumer consumer = session.createConsumer(topic);
                consumer.setMessageListener(ReceiveTopic.this);
                connection.start();
                while (!ReceiveTopic.this.stop) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Closing connection");
                consumer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }


        }

    }
}
