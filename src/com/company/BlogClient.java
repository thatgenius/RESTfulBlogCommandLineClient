package com.company;

import com.company.entity.AuthToken;
import com.company.service.ParamsParser;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static com.company.service.ClientService.*;

public class BlogClient {

    public static void main(String[] args) {
        BlogClient.run();
    }


    private static void run() {

        boolean supported;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("REST Blog client ('x' to exit):");
                String str = br.readLine();
                if (!isAuthorized()) authorize(br);
                try {
                    String[] params = ParamsParser.getParams(str);
                    if (params.length == 0) continue;
                    if ("x".equalsIgnoreCase(params[0])) {
                        System.out.println("Bye!");
                        break;
                    }
                    supported = ParamsParser.parse(params);
                    System.out.print(supported == false ? "not suported \n" : "");
                }
                catch(HttpClientErrorException e) {
                    System.out.println("not authorized");
                    AuthToken.login = null;
                    AuthToken.pass = null;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
