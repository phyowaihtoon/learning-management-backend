package com.creatip.lms.controller.util;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.data.domain.Page;

public class PaginationUtil {
    public static HttpHeaders generatePaginationHttpHeaders(ServletUriComponentsBuilder uriBuilder, Page<?> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        String link = "";
        if (page.hasNext()) {
            int nextPage = page.getNumber() + 1;
            link += "<" + uriBuilder.replaceQueryParam("page", nextPage).toUriString() + ">; rel=\"next\",";
        }
        if (page.hasPrevious()) {
            int prevPage = page.getNumber() - 1;
            link += "<" + uriBuilder.replaceQueryParam("page", prevPage).toUriString() + ">; rel=\"prev\",";
        }
        int lastPage = page.getTotalPages() - 1;
        link += "<" + uriBuilder.replaceQueryParam("page", lastPage).toUriString() + ">; rel=\"last\",";
        link += "<" + uriBuilder.replaceQueryParam("page", 0).toUriString() + ">; rel=\"first\"";
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }
}