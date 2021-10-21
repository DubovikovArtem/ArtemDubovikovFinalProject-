package apiTests;

import api.BaseApi;
import api.CommentController;
import com.google.gson.Gson;

import entity.Comment;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static apiTests.BaseTestApi.urlCreate;

public class TestCommentController {
    private final String token = new BaseApi().token();

    @Test
    public void createNewComment() throws IOException {
        String url = "/api/comment/" + 71 + "/create";
        Comment comment = new Comment();
        comment.setId(71);
        comment.setUsername("sdcn");
        comment.setMessage("testststststststststststs");
        comment.setCommentDate("50");

        String jsonObject = new Gson().toJson(comment);
        CommentController commentController = new CommentController();
        commentController.createComment(urlCreate(url), jsonObject, token);

        String title = new BaseApi().returnValue(jsonObject, "message");
        Assert.assertEquals(title, "testststststststststststs");
    }

    @Test
    public void testGetComment() throws IOException {
        String url = "/api/comment/" + 71 + "/create";
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get(urlCreate(url), token);
        System.out.println(jsonObject);

        String message = new BaseApi().returnValueFromArray(jsonObject, "message");
        Assert.assertEquals(message, "testststststststststststs");
    }
}
