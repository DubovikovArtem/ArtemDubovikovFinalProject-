package apiTests;

import api.BaseApi;
import api.UserController;
import com.google.gson.Gson;
import entity.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserController {
    private final String token = new BaseApi().token();

    @Test
    public void testUserUpdate() throws IOException {
        User user = new User();
        user.setId(1);
        user.setUsername("artemTest1");
        user.setName("ArtemTest");
        user.setLastname("Blabla");

        String jsonObject = new Gson().toJson(user);
        UserController userController = new UserController();
        userController.update("https://freelance.lsrv.in.ua/api/user/update", jsonObject, token);

        String username = new BaseApi().returnValue(jsonObject, "username");
        String name = new BaseApi().returnValue(jsonObject, "name");

        Assert.assertEquals(username, "artemTest1");
        Assert.assertEquals(name, "ArtemTest");

    }

    @Test
    public void testGetUserId() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/user/71", token);
        System.out.println(jsonObject);

        String username = new BaseApi().returnValue(jsonObject, "username");
        String name = new BaseApi().returnValue(jsonObject, "name");

        Assert.assertEquals(username, "artemTest1");
        Assert.assertEquals(name, "ArtemTest");
    }

    @Test
    public void testGetUser() throws IOException {
        BaseApi baseApi = new BaseApi();
        String jsonObject = baseApi.get("https://freelance.lsrv.in.ua/api/user/", token);
        System.out.println(jsonObject);

        String username = new BaseApi().returnValue(jsonObject, "username");
        String name = new BaseApi().returnValue(jsonObject, "name");

        Assert.assertEquals(username, "artemTest1");
        Assert.assertEquals(name, "ArtemTest");
    }
}
