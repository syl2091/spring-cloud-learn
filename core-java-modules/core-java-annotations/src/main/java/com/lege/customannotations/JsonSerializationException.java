package com.lege.customannotations;

/**
 * @author lege
 * @Description
 * @create 2022-08-17 13:50
 */
public class JsonSerializationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public JsonSerializationException(String message) {
        super(message);
    }
}
