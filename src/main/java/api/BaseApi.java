package api;

import httpClient.HttpClient;

import java.io.IOException;

public class BaseApi {
    public static String baseUrl = "https://freelance.lsrv.in.ua/v3/api-docs/";

    public String get(String url) throws IOException {
        String request = new HttpClient().getRequest(url);
        return request;
    }
}
