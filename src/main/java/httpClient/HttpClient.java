package httpClient;

import okhttp3.*;

import java.io.IOException;

public class HttpClient {

    public String getRequest(String baseUrl) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);
        return response.body().string();
    }

    public String postRequest(String baseUrl, RequestBody body, String token) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);
        return response.body().string();
    }

    public void deleteRequest(String baseUrl) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .delete()
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
}
