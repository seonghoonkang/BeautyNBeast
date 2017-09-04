package com.b2soft.common.log;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.http.HttpMethod;

import net.sf.json.JSONObject;

public class MDCFilter implements Filter {


    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    private String getBody(MDCRequestWrapper requestWrapper) throws IOException {
        //        StringBuilder buffer = new StringBuilder();
        //        BufferedReader reader = requestWrapper.getReader();
        //        String line;
        //        while((line = reader.readLine()) != null) {
        //            buffer.append(line);
        //        }
        //
        //        return buffer.toString().length() == 0 ? "none" : buffer.toString();

        return requestWrapper.getReaderForMDC().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    private String getClientIp(HttpServletRequest req) {

        String req_ip = req.getHeader("X-Forwarded-For");
        String ip = "";

        if(req_ip != null) {
            ip = req_ip.split(",")[0];
        }

        if(ip == null || ip.length() == 0) {
            ip = req.getRemoteAddr();
        }

        return ip;
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        String requestMethod = httpRequest.getMethod();
        String remoteIP = this.getClientIp(httpRequest);
        String queryString = "".equals(httpRequest.getQueryString()) || httpRequest.getQueryString() == null ? ""
                : "?" + httpRequest.getQueryString();
        String requestURI = httpRequest.getRequestURI() + queryString;
        String body = null;
        String parameters = "";
        JSONObject headers = JSONObject.fromObject(this.getHeadersInfo(httpRequest));

        if(!requestMethod.equals(HttpMethod.GET.toString())) {
            String contentType = httpRequest.getContentType() == null || "".equals(httpRequest.getContentType()) ? ""
                    : httpRequest.getContentType().toLowerCase();
            if(!contentType.startsWith("multipart/form-data")) {
                MDCRequestWrapper requestWrapper = new MDCRequestWrapper((HttpServletRequest) request);
                body = this.getBody(requestWrapper);
                httpRequest = requestWrapper;
            }
        }

        for(String name : Collections.<String>list(httpRequest.getParameterNames())) {
            String value = httpRequest.getParameter(name);

            parameters += name + "=" + value + "&";
        }

        MDC.put("**remoteIP", remoteIP);
        MDC.put("**requestURI", requestURI);
        MDC.put("**requestMethod", requestMethod);
        MDC.put("**headers", headers.toString());
        MDC.put("**parameters", "".equals(parameters) ? "none" : parameters);
        MDC.put("**body", body);

        try {
            chain.doFilter(httpRequest, response);
        } finally {
            MDC.clear();
        }	
	}
}
