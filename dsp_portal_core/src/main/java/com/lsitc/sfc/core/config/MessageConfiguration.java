package com.lsitc.sfc.core.config;

import com.lsitc.sfc.core.service.PropertyService;
import com.lsitc.sfc.core.support.CustomReloadableMessageSource;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

@Configuration
@AllArgsConstructor
public class MessageConfiguration {

    private PropertyService propertyService;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new CustomReloadableMessageSource();
        messageSource.setBasename("classpath:/" + propertyService.getString("spring.messages.basename"));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);

        Locale.setDefault(Locale.KOREAN);
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("lang");
        return localeResolver;
    }
}
