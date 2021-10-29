package se.mad.poc.header;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Order(1)
public class HeaderFilter implements Filter {
    private static Logger logger = Logger.getLogger(HeaderFilter.class.getName());

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if (!req.getMethod().equals("GET") && req.getHeader("businessId") == null) {
            logger.log(Level.WARNING, "Business ID is missing");
        }
        chain.doFilter(request, response);

    }

    // other methods
}
