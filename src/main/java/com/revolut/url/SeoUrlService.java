package com.revolut.url;

import java.util.concurrent.ConcurrentHashMap;

public class SeoUrlService {
    ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<>();

    public String createShortUrl(String sourceUrl, String seoWord) {
        checkSeoWord(seoWord);
        String urlKey = ShortUrlConst.BASE_URL + seoWord;
        urlMap.put(seoWord, sourceUrl);
        return urlKey;
    }

    public String getOriginalUrl(String seoWord) {
        return urlMap.get(seoWord);
    }

    private void checkSeoWord(String seoWord) {
        if (seoWord == null) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_NULL);
        }
        if (seoWord.isEmpty()) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_EMPTY);
        }
        if (seoWord.length() > ShortUrlConst.MAX_SEO_WORD_LENGTH) {
            throw new IllegalArgumentException(ShortUrlConst.ERROR_MESSAGE_MAX_LENGTH);
        }
    }

}
