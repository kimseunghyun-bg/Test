package com.lsitc.sfc.core.util;

import com.lsitc.sfc.core.support.ExposedMessageSource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

@Component
@AllArgsConstructor
public class MessageUtils {

    private static MessageSource messageSource;

    @Autowired
    private MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public static Map<String, String> getAllMessage() {
        return getAllMessage(getLocale());
    }

    public static Map<String, String> getAllMessage(Locale locale) {
        if (messageSource instanceof ExposedMessageSource) {
            return ((ExposedMessageSource) messageSource).getAllMessage(locale);
        } else {
            throw new ClassCastException("MessageSource can not cast ExposedMessageSource.class");
        }
    }

    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, getLocale());
    }

    public static String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, getLocale());
    }

    protected static Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }
}
