package org.example.service;

public interface UrlShortener {
    String getShortenedUrl(String uri, String seoKeyword);

    String getUrlWithRandomPath(String uri);
}

