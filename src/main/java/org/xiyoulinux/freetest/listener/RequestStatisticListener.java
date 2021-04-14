package org.xiyoulinux.freetest.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author CoderZk
 */
@SuppressWarnings("unchecked")
@WebListener
public class RequestStatisticListener implements ServletContextListener, ServletRequestListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<String> timeList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        sce.getServletContext().setAttribute("timeList", timeList);
        sce.getServletContext().setAttribute("valueList", valueList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String url = req.getRequestURL().toString();
        if (url.endsWith("/rt") || url.contains("img") || url.contains("file") || url.contains("lay")) {
            return;
        }

        List<String> timeList = (List<String>) sre.getServletContext().getAttribute("timeList");
        List<Integer> valueList = (List<Integer>) sre.getServletContext().getAttribute("valueList");
        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
        String time = sdf.format(data);
        if (!timeList.contains(time)) {
            timeList.add(time);
            valueList.add(1);
        } else {
            int index = timeList.indexOf(time);
            int value = valueList.get(index);
            valueList.set(index, ++value);
        }
        sre.getServletContext().setAttribute("timeList", timeList);
        sre.getServletContext().setAttribute("valueList", valueList);
    }
}
