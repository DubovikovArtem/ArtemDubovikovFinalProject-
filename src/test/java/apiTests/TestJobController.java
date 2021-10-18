package apiTests;

import api.BaseApi;
import api.JobController;
import api.UserController;
import com.google.gson.Gson;
import entity.Job;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestJobController {
    private final String token = new BaseApi().token();

    @Test
    public void testJobCreate() throws IOException {
        Job job = new Job();
        job.setId(789456);
        job.setTitle("ApiTitle");
        job.setDescription("ApiDescription");
        job.setPrice(999666);
        job.setUser("ApiUser");
        job.setNoOfComments(2);

        String jsonObject = new Gson().toJson(job);
        JobController jobController = new JobController();
        jobController.jobControllerPost("https://freelance.lsrv.in.ua/api/job/create", jsonObject, token);

        String title = new BaseApi().returnValue(jsonObject, "title");
        Assert.assertEquals(title, "ApiTitle");
    }

    @Test
    public void testJobDelete() throws IOException {
        Job job = new Job();

        String jsonObject = new Gson().toJson(job);
        JobController jobController = new JobController();
        jobController.jobControllerPost("https://freelance.lsrv.in.ua/api/job/delete/298", jsonObject, token);

        String message = new BaseApi().returnValue(jsonObject, "message");
        Assert.assertEquals(message, "Job is deleted");
    }

    @Test
    public void testGetJobId() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/296", token);
        System.out.println(jsonObject);

        String title = new BaseApi().returnValue(jsonObject, "title");
        Assert.assertEquals(title, "ApiTitle");
    }

    @Test
    public void testGetJobUser() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/user/jobs", token);
        System.out.println(jsonObject);

        String user = new BaseApi().returnValueFromArray(jsonObject, "user");
        Assert.assertEquals(user, "ArtemTest Blabla");
    }

    @Test
    public void testGetJobAll() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/job/all", token);
        System.out.println(jsonObject);

        String user = new BaseApi().returnValueFromArray(jsonObject, "user");
        Assert.assertEquals(user, "Al Al");
    }
}
