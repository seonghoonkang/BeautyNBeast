package com.b2soft.common.security.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CORSFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

    private FilterConfig filterConfig;

    private String accessControlAllowMethods;
    private String accessControlMaxAge;
    private String accessControlAllowHeaders;
    private String accessControlAllowOrigin;
    private String accessControlAllowCredentials;
    private String allowDomain;
//    private List<String> whiteList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

        this.accessControlAllowMethods = filterConfig.getInitParameter("allowMethods");
        this.accessControlMaxAge = filterConfig.getInitParameter("maxAge");
        this.accessControlAllowHeaders = filterConfig.getInitParameter("allowHeaders");
        this.accessControlAllowCredentials = filterConfig.getInitParameter("allowCredentials");
        this.allowDomain = filterConfig.getInitParameter("allowDomain");
//        this.whiteList = Arrays.asList(filterConfig.getInitParameter("whiteList").split(","));
        
        LOGGER.info("=================CORS Filter Configuration infomation==================");
        LOGGER.info("accessControlAllowMethods     : " + accessControlAllowMethods);
        LOGGER.info("accessControlMaxAge           : " + accessControlMaxAge);
        LOGGER.info("accessControlAllowHeaders     : " + accessControlAllowHeaders);
        LOGGER.info("allowDomain     : " + allowDomain);
//        LOGGER.info("accessControlAllowOrigin      : " + this.whiteList);
        LOGGER.info("accessControlAllowCredentials : " + accessControlAllowCredentials);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String originDomain = req.getHeader("Origin");
        
        LOGGER.debug("request origin::"+ originDomain);
        res.setHeader("Access-Control-Allow-Methods", accessControlAllowMethods);
        res.setHeader("Access-Control-Max-Age", accessControlMaxAge);
        res.setHeader("Access-Control-Allow-Headers", accessControlAllowHeaders);
        res.setHeader("Access-Control-Allow-Credentials", accessControlAllowCredentials);
        res.setHeader("Access-Control-Allow-Origin", allowDomain);

        chain.doFilter(request, response);
    }

    /**
     * FilterConfig를 반환한다.
     * 
     * @return the FilterConfig instance 또는 없을 경우, <code>null</code>
     * @see javax.servlet.GenericServlet#getServletConfig()
     */
    public final FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    /**
     * 현재 Filter의 name을 반환한다.
     * 
     * @return the filter name 또는 없을 경우, <code>null</code>.
     * @see javax.servlet.GenericServlet#getServletName()
     * @see javax.servlet.FilterConfig#getFilterName()
     */
    public final String getFilterName() {
        return this.filterConfig != null ? this.filterConfig.getFilterName() : null;
    }


}
