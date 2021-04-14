package org.xiyoulinux.freetest.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author CoderZk
 */
public class DeviceAdapterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request, response);
    }
}
