package com.marketplace.MarketPlaceProject.error;

public class AnnouncementNotFoundException extends Exception{
    public AnnouncementNotFoundException() {
        super();
    }

    public AnnouncementNotFoundException(String message) {
        super(message);
    }

    public AnnouncementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnnouncementNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AnnouncementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

