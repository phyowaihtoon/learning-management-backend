package com.creatip.lms.controller.util;

import org.springframework.http.HttpHeaders;

public class HeaderUtil {

    private HeaderUtil() {}

    public static HttpHeaders createAlert(String applicationName, String message, String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-alert", message);
        headers.add("X-" + applicationName + "-params", username);
        return headers;
    }

}
