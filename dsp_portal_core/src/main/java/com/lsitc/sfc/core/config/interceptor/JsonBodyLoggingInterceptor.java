package com.lsitc.sfc.core.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@AllArgsConstructor
@Component
public class JsonBodyLoggingInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final ContentCachingRequestWrapper cachingRequest = (ContentCachingRequestWrapper) request;
        final ContentCachingResponseWrapper cachingResponse = (ContentCachingResponseWrapper) response;

        if (cachingRequest.getContentType() != null
                && cachingRequest.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)
                && cachingRequest.getContentAsByteArray().length != 0) {
            log.debug("Request Body : {}", objectMapper.readTree(cachingRequest.getContentAsByteArray()));
        }

        if (cachingResponse.getContentType() != null
                && cachingResponse.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)
                && cachingResponse.getContentAsByteArray().length != 0) {
            log.debug("Response Body : {}", objectMapper.readTree(cachingResponse.getContentAsByteArray()));
        }
    }
}
