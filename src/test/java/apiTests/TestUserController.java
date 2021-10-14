package apiTests;

import api.BaseApi;
import api.UserController;
import com.google.gson.Gson;
import entity.User;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserController {
    private String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3MSIsIm5hbWUiOm51bGwsImlkIjoiNzEiLCJ" +
            "1c2VybmFtZSI6ImFydGVtVGVzdDEiLCJsYXN0bmFtZSI6bnVsbCwiaWF0IjoxNjM0MTk5NDYyLCJleHAiOjE" +
            "2MzQyMDMwNjJ9.aYSYfasjFf8xDcp3yd19DMj7fA_TL7rqJoPzLOWoiKlqdNQSgP1WSFm-IFdXXWKJEoReCWTlSEWs1TfUEKpSaA";

    @Test
    public void testUserUpdate() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("artemTest1");
        user.setName("ArtemTest");
        user.setLastname("Blabla");

        String jsonObject = new Gson().toJson(user);
        UserController userController = new UserController();
        userController.update("https://freelance.lsrv.in.ua/api/user/update", jsonObject,token);
    }

    @Test
    public void testGetUserId() throws IOException {
        BaseApi baseApi = new BaseApi();
        String a = baseApi.get("https://freelance.lsrv.in.ua/api/user/70");
        System.out.println(a);
    }

    @Test
    public void testGetUser() throws IOException {
        BaseApi baseApi = new BaseApi();
        String a = baseApi.get("https://freelance.lsrv.in.ua/api/user");
        System.out.println(a);
    }
}
