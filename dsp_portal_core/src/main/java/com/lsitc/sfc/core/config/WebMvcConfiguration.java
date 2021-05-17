package com.lsitc.sfc.core.config;

import com.lsitc.sfc.core.config.interceptor.JsonBodyLoggingInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@AllArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private JsonBodyLoggingInterceptor jsonBodyLoggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jsonBodyLoggingInterceptor);
    }
}
