/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: WelcomeController.java project: test-msg-master
 * @creator: lidongxing
 * @date: 2017/12/19
 */

package com.ldx.msg.webapp.ctroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: lidongxing
 * @requireNo:
 * @createdate: 2017-12-19 17:57
 * @lastdate:
 */

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
    @Value("${spring.application.name}")
    String appName;

    @RequestMapping(value = "index")
    @ResponseBody
    public String nativeIndex(HttpServletRequest request, HttpServletResponse response) {
        return appName;
    }
}
