package org.xiyoulinux.freetest.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author CoderZk
 */
@WebServlet("/check_question3")
public class CheckQuestion3Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String input = request.getParameter("ans");
        String ans = "122332312";
        HashMap<String, Object> map = new HashMap<>();
        if (ans.equals(input)) {
            map.put("code", "1");
            map.put("message", "答案正确, 即将跳转到下一页面");
            map.put("redirect_url", "/e9ON0C");
        } else {
            map.put("code", "0");
            map.put("message", "答案错误");
        }
        String jsonString = JSON.toJSONString(map);
        response.getWriter().println(jsonString);
    }
}
