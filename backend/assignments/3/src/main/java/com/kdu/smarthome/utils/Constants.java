package com.kdu.smarthome.utils;

public class Constants {

    private Constants(){}

    // Constants for Json Web Token [JWT] Authentication
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String SECRET_KEY = "mysecretkey123";
    public static final long EXPIRY_TIME = (long) 60*(60*1000);
}
