package com.bookmyshow.util;

import org.springframework.web.util.UriComponentsBuilder;

public final class BookingUtil {
    public static UriComponentsBuilder getBaseUrl(String uri, int port) {

        return UriComponentsBuilder.fromHttpUrl("http://localhost:" + port + uri);
    }
}
