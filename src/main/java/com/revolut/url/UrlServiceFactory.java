package com.revolut.url;

public class UrlServiceFactory {


    //посмотреть через стратегию
    public static ShortUrlService getIncrementUrlService() {
       return new ShortUrlService(new IncrementUrlGenerator());
    }

    public static ShortUrlService getRandomUrlService() {
        return new ShortUrlService(new RandomSequenceGenerator());
    }
}
