package com.lsitc.sfc.core.support;

import java.util.Locale;
import java.util.Map;

public interface ExposedMessageSource {
    Map<String, String> getAllMessage(Locale locale);
}
