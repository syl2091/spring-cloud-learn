package com.lege.rate.exception;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 10:08
 */
public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException() {
        super();
    }

    public ProviderNotFoundException(String message) {
        super(message);
    }
}
