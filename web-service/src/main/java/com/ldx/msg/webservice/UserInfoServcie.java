/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: UserInfoServcie.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2018/1/23
 */

package com.ldx.msg.webservice;

import com.ldx.msg.domain.Lock;
import com.ldx.msg.webservice.lock.DistributedLockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2018-01-23 19:49
 * @lastdate:
 */

@Component
public class UserInfoServcie {
    private static Logger logger = LoggerFactory.getLogger(UserInfoServcie.class);
    @Autowired
    DistributedLockHandler distributedLockHandler;

    public String getUserInfo() {
        String userInfo = "longke";
        return userInfo;
    }

    public String getUserInfoWithLock() {
        Lock lock=new Lock("lockk","sssssssss");
        String userInfo = "";
        if(distributedLockHandler.tryLock(lock)){
            userInfo = "longke get lock";
            try {
                Thread.sleep(3000);
            } catch (Exception e){
                logger.error("sleep error",e);
            }
            logger.info("get lock");
            distributedLockHandler.releaseLock(lock);
        }else{
            logger.info("can't get lock");
            userInfo = "can't get lock";
        }

        return userInfo;
    }
}
