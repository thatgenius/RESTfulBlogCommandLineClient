package com.company.entity;

public class AuthToken {

    private AuthToken() {}

    public static String login;
    public static String pass;

    public static String encoded;

    public static boolean isSet() {
        return (login != null && pass!= null) ? true: false;
    }

    public static String getEncoded() {
        byte[] encodedBytes = (login + ":" + pass).getBytes();
        encoded = javax.xml.bind.DatatypeConverter.printBase64Binary(encodedBytes);
        return encoded;
    }
}
