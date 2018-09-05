package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by i-feng on 2018/9/4.
 */


@Log4j2
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");

        if (accessToken == null) {
            log.warn("access token is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }

        log.info("access token is ok");

        return null;
    }


}
