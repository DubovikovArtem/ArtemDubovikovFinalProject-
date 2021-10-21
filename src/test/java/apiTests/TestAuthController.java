package apiTests;

import api.AuthController;
import api.BaseApi;
import com.google.gson.Gson;
import entity.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static apiTests.BaseTestApi.urlCreate;

public class TestAuthController {

    @Test
    public void testSingUp() throws IOException {
        Auth auth = new Auth();
        auth.setUsername("artemTest4");
        auth.setPassword("987654321");
        auth.setConfirmPassword("987654321");
        String json = new Gson().toJson(auth);

        AuthController authController = new AuthController();
        String singUp = authController.singUp(urlCreate("/auth/signup"), json);

        String value = new BaseApi().returnValue(singUp, "message");
        Assert.assertEquals(value, "User registered successfully");
    }

    @Test
    public void testSingIn() throws IOException {
        Auth auth = new Auth();
        auth.setUsername("artemTest1");
        auth.setPassword("987654321");
        String jsonObject = new Gson().toJson(auth);

        AuthController authController = new AuthController();
        String logIn = authController.singUp(urlCreate("/auth/signin"), jsonObject);

        String value = new BaseApi().returnValue(logIn, "success");
        Assert.assertEquals(value, "true");
    }
}
