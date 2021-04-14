package org.xiyoulinux.freetest.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CoderZk
 */
@SuppressWarnings("unchecked")
@WebServlet("/rt")
public class RequestStatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        List<String> timeList = (List<String>) servletContext.getAttribute("timeList");
        List<Integer> valueList = (List<Integer>) servletContext.getAttribute("valueList");
        resp.setContentType("text/html;charset=utf-8");
        Map<String, List<?>> result = new HashMap<>();
        result.put("timeList", timeList);
        result.put("valueList", valueList);
        String json = JSON.toJSONString(result);
        resp.getWriter().println(json);
    }
}
