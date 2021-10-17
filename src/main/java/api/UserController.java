package api;

import httpClient.HttpClient;
import io.qameta.allure.Step;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UserController {

    @Step("User controller")
    public String update(String url, String jsonObject, String token) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        String userUpdate = new HttpClient().postRequest(url, requestBody, token);
        System.out.println(userUpdate);
        return userUpdate;
    }
}
