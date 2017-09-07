package com.b2soft.common.service.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;


public class BnbCookieLocaleResolver extends CookieLocaleResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(BnbCookieLocaleResolver.class);
    private String supportedLocale;
    private String defaultLocaleLang;
    
    public BnbCookieLocaleResolver() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public String getSupportedLocale() {
        return supportedLocale;
    }

    
    public void setSupportedLocale(String supportedLocale) {
        this.supportedLocale = supportedLocale;
    }

    
    public String getDefaultLocaleLang() {
        return defaultLocaleLang;
    }

    
    public void setDefaultLocaleLang(String defaultLocaleLang) {
        this.defaultLocaleLang = defaultLocaleLang;
    }

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest request) {
        Locale defaultLocale = super.determineDefaultLocale(request);
        defaultLocale = checkSupportedLocale(defaultLocale); 

        return defaultLocale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // TODO Auto-generated method stub
        if(locale != null){
            locale = checkSupportedLocale(locale);
            LOGGER.debug("locale = " + locale);
        }else{
            locale = new Locale(this.defaultLocaleLang);
            LOGGER.debug("set Default locale["+locale+"] because locale is null ");
        }
        super.setLocale(request, response, locale);
    }
    
    private Locale checkSupportedLocale(Locale locale) {
        LOGGER.debug("START check locale = " + locale);

        String language = locale.getLanguage();
        if(language == null || "".equals(language) || language.length() < 2) {
            return new Locale(this.defaultLocaleLang);
        }

        Locale supportedLocale = null;

        String[] supportLocaleString = this.supportedLocale.split(",");
        for(int i = 0; i < supportLocaleString.length; i++) {
            if(supportLocaleString[i].equals(language)) {
                supportedLocale = locale;
                break;
            }
        }

        if(supportedLocale == null) {
            supportedLocale = new Locale(this.defaultLocaleLang);
        }
        return supportedLocale;
    }
}
