package com.company.service;

import com.company.entity.AuthToken;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientService {
    public static boolean isAuthorized() {
        if (AuthToken.isSet()) {
            return true;
        }
        return false;
    }

    public static void authorize(BufferedReader br) throws IOException {
        System.out.print("enter login:");
        String login = br.readLine();
        System.out.print("enter password:");
        String pass = br.readLine();
        AuthToken.login = login;
        AuthToken.pass = pass;
    }
}
