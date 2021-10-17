package api;

import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class AuthController {
    public String postRequestAuth(String baseUrl, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(baseUrl)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response);
        return response.body().string();
    }

    @Step("Method singUp/singIn")
    public String singUp(String url, String jsonObject) throws IOException {

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        String requestAuth = postRequestAuth(url, requestBody);
        System.out.println(requestAuth);
        return requestAuth;
    }
}

