package com.lsitc.sfc.core.config;

import com.lsitc.sfc.core.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class MessageConfiguration {

    private final PropertyService propertyService;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/" + propertyService.getString("spring.messages.basename"));
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(0);

        Locale.setDefault(Locale.KOREAN);
        return messageSource;
    }
}
