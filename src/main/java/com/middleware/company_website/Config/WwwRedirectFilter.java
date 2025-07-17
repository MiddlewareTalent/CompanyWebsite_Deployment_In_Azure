package com.middleware.company_website.Config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class WwwRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String host = req.getHeader("host");

        if ("talentflow-hr.com".equalsIgnoreCase(host)) {
            String redirectURL = "https://www.talentflow-hr.com" + req.getRequestURI();
            if (req.getQueryString() != null) {
                redirectURL += "?" + req.getQueryString();
            }

            res.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            res.setHeader("Location", redirectURL);
            
        } else {
            chain.doFilter(request, response);
        }
    }
}
