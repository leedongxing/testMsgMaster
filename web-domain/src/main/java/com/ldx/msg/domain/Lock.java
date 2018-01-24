/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: Lock.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2018/1/23
 */

package com.ldx.msg.domain;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2018-01-23 19:42
 * @lastdate:
 */

public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
