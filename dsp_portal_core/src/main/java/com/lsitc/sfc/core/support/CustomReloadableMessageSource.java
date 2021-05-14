package com.lsitc.sfc.core.support;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

public class CustomReloadableMessageSource extends ReloadableResourceBundleMessageSource implements ExposedMessageSource {

    @Override
    public Map<String, String> getAllMessage(Locale locale) {
        Properties properties = Optional.ofNullable(getMergedProperties(locale).getProperties()).orElse(new Properties());
        return properties.entrySet().stream().collect(Collectors.toMap(
                e -> String.valueOf(e.getKey()),
                e -> String.valueOf(e.getValue()))
        );
    }

}
