package com.revolut.url;

import java.util.concurrent.ConcurrentHashMap;

public class ShortUrlService {

    private static String baseUrl = "http://short.com/";
    private ConcurrentHashMap<String, String> linkMap = new ConcurrentHashMap<>();

    private ShortUrlGenerator generator;

    public ShortUrlService(ShortUrlGenerator shortUrlGenerator) {
        generator = shortUrlGenerator;
    }

    public String generateShortLink(String sourceUrl) {
        String shortUrl = baseUrl + generator.generate();
        linkMap.put(shortUrl, sourceUrl);
        return shortUrl;
    }

    public String getSourceUrl(String shortLink) {
        return linkMap.get(shortLink);
    }
}
