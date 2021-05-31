package com.bootcamp.linktracker.utils;

import org.apache.commons.validator.UrlValidator;

import java.util.UUID;

public class LinkUtil {
    public static String generateLinkId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 6);
    }

    public static boolean isValid(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }
}
