package com.demo.minispringmvc.controller;

/**
 * Controller
 *
 * @Author: zhangb
 * @Date: 2019-03-26 15:57
 */

import com.demo.minispringmvc.annotation.MiniController;
import com.demo.minispringmvc.annotation.MiniRequestMapping;
import com.demo.minispringmvc.annotation.MiniRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MiniController
@MiniRequestMapping("/test")
public class ControllerTests {
    @MiniRequestMapping("/doTest1")
    public void test1(HttpServletRequest request, HttpServletResponse response,
                      @MiniRequestParam("param") String param) {
        System.out.println(param);
        try {
            response.getWriter().write("doTest1 method success! param:" + param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @MiniRequestMapping("/doTest2")
    public void test2(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.getWriter().println("doTest2 method success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
