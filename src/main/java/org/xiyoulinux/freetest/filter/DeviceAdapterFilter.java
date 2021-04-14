package org.xiyoulinux.freetest.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CoderZk
 */
@WebFilter(filterName = "DeviceAdapterFilter", urlPatterns = "/index.html")
public class DeviceAdapterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String userAgent = req.getHeader("user-agent");
        if (userAgent.contains("iPhone") || userAgent.contains("Android") || userAgent.contains("iPad")) {
            resp.sendRedirect("mobile_access.html");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
