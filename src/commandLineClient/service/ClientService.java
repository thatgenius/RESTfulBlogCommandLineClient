package commandLineClient.service;

import commandLineClient.entity.AuthToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientService {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public final static String newline = "\n";
    public final static String indention = "   ";

    private static boolean isAuthorized() {
        if (AuthToken.isSet()) {
            return true;
        }
        return false;
    }

    private static void authorize() {
        try {
            System.out.print("enter login:");
            String login = br.readLine();
            System.out.print("enter password:");
            String pass = br.readLine();
            AuthToken.login = login;
            AuthToken.pass = pass;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkAuthorization() {
        if (!isAuthorized()) authorize();
    }


    public static void printCommandList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type:" + newline);
        sb.append(indention + "get all - to get all posts available in concise form" + newline);
        sb.append(indention + "get *id* - to get a post with the id" + newline);
        sb.append(indention + "delete *id* - to delete a post with the id");
        System.out.println(sb.toString());
    }

    public static BufferedReader getReader() {
        return br;
    }
}
