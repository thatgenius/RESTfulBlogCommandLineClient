package commandLineClient;

import commandLineClient.entity.AuthToken;
import commandLineClient.service.ClientService;
import commandLineClient.service.ParamsParser;
import org.springframework.web.client.HttpClientErrorException;
import java.io.IOException;
import static commandLineClient.service.ClientService.*;

public class BlogClient {

    private static String[] params;
    private static String greetingLine = "REST Blog client ('x' to exit):";

    public static void main(String[] args) {
        BlogClient.run();
    }

    private static boolean quitDemanded() {
        if ("x".equalsIgnoreCase(params[0])) {
            System.out.println("Bye!");
            return true;
        }
        return false;
    }

    private static boolean emptyRequest() {
        if (params.length == 0) return true;
        return false;
    }

    private static void run() {
            while (true) {
                System.out.print(greetingLine);
                try {
                    params = ParamsParser.getParams();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    if (emptyRequest()) continue;
                    if (quitDemanded()) break;
                    try {
                        boolean supported;
                        supported = ParamsParser.parse(params);
                        if (!supported) {
                            System.out.print("not suported" + ClientService.newline);
                            printCommandList();
                        }
                    } catch (HttpClientErrorException e) {
                        System.out.println("not authorized");
                        AuthToken.login = null;
                        AuthToken.pass = null;
                    }
            }
    }




}
