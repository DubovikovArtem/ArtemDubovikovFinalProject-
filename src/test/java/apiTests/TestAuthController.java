package apiTests;

import api.AuthController;
import com.google.gson.Gson;
import entity.Auth;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAuthController {

    @Test
    public void testSingUp() throws IOException {
        Auth auth = new Auth();
        auth.setUsername("artemTest1");
        auth.setPassword("987654321");
        auth.setConfirmPassword("987654321");
        String json = new Gson().toJson(auth);

        AuthController authController = new AuthController();
        authController.singUp("https://freelance.lsrv.in.ua/api/auth/signup", json);
    }

    @Test
    public void testSingIn() throws IOException {
        Auth auth = new Auth();
        auth.setUsername("artemTest1");
        auth.setPassword("987654321");
        String json = new Gson().toJson(auth);

        AuthController authController = new AuthController();
        authController.singUp("https://freelance.lsrv.in.ua/api/auth/signin", json);
    }
}
