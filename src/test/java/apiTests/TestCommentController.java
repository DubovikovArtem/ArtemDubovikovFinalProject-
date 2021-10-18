package apiTests;

import api.BaseApi;
import api.CommentController;
import com.google.gson.Gson;

import entity.Comment;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCommentController {
    private final String token = new BaseApi().token();
    private final int id = 71;

    @Test
    public void createNewComment() throws IOException {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUsername("sdcn");
        comment.setMessage("testststststststststststs");
        comment.setCommentDate("50");

        String jsonObject = new Gson().toJson(comment);
        CommentController commentController = new CommentController();
        commentController.createComment("https://freelance.lsrv.in.ua/api/comment/" + id + "/create", jsonObject, token);

        String title = new BaseApi().returnValue(jsonObject, "message");
        Assert.assertEquals(title, "testststststststststststs");
    }

    @Test
    public void testGetComment() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/comment/" + 71 + "/all", token);
        System.out.println(jsonObject);

        String message = new BaseApi().returnValueFromArray(jsonObject, "message");
        Assert.assertEquals(message, "testststststststststststs");
    }
}
