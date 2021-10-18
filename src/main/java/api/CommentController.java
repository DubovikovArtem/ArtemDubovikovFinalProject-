package api;

import httpClient.HttpClient;
import io.qameta.allure.Step;
import okhttp3.RequestBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CommentController {

    @Step("Create comment")
    public String createComment(String url, String jsonObject, String token) throws IOException {
        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));
        String createComment = new HttpClient().postRequest(url, requestBody, token);
        System.out.println(createComment);
        return createComment;
    }
}
