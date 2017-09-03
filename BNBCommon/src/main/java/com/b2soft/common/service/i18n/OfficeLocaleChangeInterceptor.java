package com.b2soft.common.service.i18n;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;


public class OfficeLocaleChangeInterceptor extends LocaleChangeInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        // TODO Auto-generated method stub
        String reqLocaleStr = request.getParameter(super.getParamName());
        String newLocaleStr = "";
        if(reqLocaleStr != null){
            newLocaleStr = reqLocaleStr;

            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if(localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }
            localeResolver.setLocale(request, response, new Locale(newLocaleStr));
        }
        return true;
    }

    @Override
    public void setParamName(String paramName) {
        // TODO Auto-generated method stub
        super.setParamName(paramName);
    }

    @Override
    public String getParamName() {
        // TODO Auto-generated method stub
        return super.getParamName();
    }

}
