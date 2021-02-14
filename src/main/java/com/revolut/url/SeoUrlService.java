package com.revolut.url;

import java.util.concurrent.ConcurrentHashMap;

/**
 Service provide short link
 */
public class SeoUrlService {
    ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<>();
    public static final String BASE_URL = "http://short.com/";
    /**
     *
     * @param sourceUrl original url
     * @param seoWord key word enter by user
     * @return short version of link
     */
    public String createShortUrl(String sourceUrl, String seoWord) {
        SeoWordChecker.check(seoWord);
        String urlKey = BASE_URL + seoWord;
        urlMap.put(seoWord, sourceUrl);
        return urlKey;
    }

    /**
     * retrieve original url by key - seo word
     * @param seoWord key entered by user
     * @return
     */
    public String getOriginalUrl(String seoWord) {
        return urlMap.get(seoWord);
    }


}
