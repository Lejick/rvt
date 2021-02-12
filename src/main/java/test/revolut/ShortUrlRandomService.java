package test.revolut;

import java.util.concurrent.ConcurrentHashMap;

public class ShortUrlRandomService {
    private static String baseUrl = "http://short.com/";
    private ConcurrentHashMap<String, String> linkMap = new ConcurrentHashMap<>();

    private RandomSequenceGenerator generator = new RandomSequenceGenerator();

    public String generateShortLink(String sourceUrl) {
        String shortUrl = baseUrl + generator.generate();
        linkMap.put(shortUrl, sourceUrl);
        return shortUrl;
    }

    public String getSourceUrl(String shortLink) {
        return linkMap.get(shortLink);
    }
}
