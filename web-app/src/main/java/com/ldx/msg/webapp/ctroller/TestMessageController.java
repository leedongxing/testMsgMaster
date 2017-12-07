/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: TestMessageController.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/11/9
 */

package com.ldx.msg.webapp.ctroller;

import com.ldx.msg.webservice.mq.NativeAmqProducer;
import com.ldx.msg.webservice.mq.SpringAmqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-11-09 18:10
 * @lastdate:
 */

@Controller
@RequestMapping(value = "/mq")
public class TestMessageController {
    @Autowired
    private NativeAmqProducer nativeAmqProducer;

    @Autowired
    private SpringAmqProducer springAmqProducer;

    @RequestMapping(value = "/native/")
    public String nativeIndex(HttpServletRequest request, HttpServletResponse response) {
        return "nativesend";
    }

    @RequestMapping(value = "/spring")
    public String springIndex(HttpServletRequest request, HttpServletResponse response) {
        return "springsend";
    }

    @RequestMapping(value = "/native/p2p/send")
    @ResponseBody
    public String nativeP2pSend(HttpServletRequest request, HttpServletResponse response, String msg) {
        boolean result = nativeAmqProducer.send(msg);
        return "result:" + result;
    }

    @RequestMapping(value = "/native/p2p/sendTopic")
    @ResponseBody
    public String nativeP2pSendTopic(HttpServletRequest request, HttpServletResponse response, String msg) {
        boolean result = nativeAmqProducer.sendTopic(msg);
        return "result:" + result;
    }

    @RequestMapping(value = "/spring/p2p/send")
    @ResponseBody
    public String springP2pSend(HttpServletRequest request, HttpServletResponse response, String msg) {
        boolean result = springAmqProducer.send(msg);
        return "result:" + result;
    }
}
