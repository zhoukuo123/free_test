package org.xiyoulinux.freetest.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderZk
 */

@WebServlet("/check_question4")
public class CheckQuestion4Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String input = req.getParameter("ans");
        Map<String, Object> map = new HashMap<>();
        String ans = "RSAis1Public-KeyCrypt0systemThat1sWidelyusedForSecureDa7aTransmission.";
        if (ans.equals(input)) {
            map.put("code", "1");
            map.put("message", "答案正确, 即将跳转下一关");
            map.put("redirect_url", "/ieskd");
        } else {
            map.put("code", "0");
            map.put("message", "答案错误");
        }
        String jsonString = JSON.toJSONString(map);
        resp.getWriter().println(jsonString);
    }
}
