package api;

import com.google.gson.Gson;
import entity.Auth;
import httpClient.HttpClient;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class BaseApi {
    public static String baseUrl = "https://freelance.lsrv.in.ua/v3/api-docs/";

    @Step("Выполняем get запрос")
    public String get(String url, String token) throws IOException {
        String request = new HttpClient().getRequest(url, token);
        return request;
    }

    public String returnValue(String object, String key) {
        JSONObject jsonObject = new JSONObject(object);
        String value = jsonObject.get(key).toString();
        return value;
    }

    public String returnValueFromArray(String object, String key) {
        JSONArray jsonArray = new JSONArray(object);
        String value = jsonArray.getJSONObject(0).getString(key);
        return value;
    }

    @Step("создание токена")
    public String token() {
        Auth auth = new Auth();
        auth.setUsername("artemTest1");
        auth.setPassword("987654321");
        String json = new Gson().toJson(auth);

        AuthController authController = new AuthController();
        String token = null;
        try {
            token = authController.singUp("https://freelance.lsrv.in.ua/api/auth/signin", json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = returnValue(token, "token");
        return value;
    }
}
