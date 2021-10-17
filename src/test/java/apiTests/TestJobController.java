package apiTests;

import api.BaseApi;
import api.UserController;
import com.google.gson.Gson;
import entity.Job;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestJobController {
    private final String token = new BaseApi().token();

    @Test
    public void testUserUpdate() throws IOException {
        Job job = new Job();
        job.setId(1);
        job.setTitle("ApiTitle");
        job.setDescription("ApiDescription");
        job.setPrice(999666);
        job.setUser("ApiUser");
        job.setNoOfComments(2);

        String jsonObject = new Gson().toJson(job);
        UserController userController = new UserController();
        userController.update("https://freelance.lsrv.in.ua/api/job/create", jsonObject, token);

        String title = new BaseApi().returnValue(jsonObject, "title");
        Assert.assertEquals(title, "ApiTitle");
    }

    @Test
    public void testGetJobId() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/199", token);
        System.out.println(jsonObject);

        String title = new BaseApi().returnValue(jsonObject, "title");
        Assert.assertEquals(title, "ApiTitle");
    }

    @Test
    public void testGetJobUser() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/user/jobs", token);
        System.out.println(jsonObject);

        String user = new BaseApi().returnValue(jsonObject, "user");
        Assert.assertEquals(user, "ArtemTest");
    }

    @Test
    public void testGetJobAll() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/all", token);
        System.out.println(jsonObject);

        String user = new BaseApi().returnValue(jsonObject, "user");
        Assert.assertEquals(user, "ArtemTest");
    }
}
