/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: JmsTestMessage.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/10
 */

package com.ldx.msg.webservice;

import java.io.Serializable;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-10 22:41
 * @lastdate:
 */

public class JmsTestMessage implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String msg;
    private int status;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
