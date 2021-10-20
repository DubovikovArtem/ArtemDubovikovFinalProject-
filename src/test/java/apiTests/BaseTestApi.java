package apiTests;

public class BaseTestApi {
    public static String startUrl = "https://freelance.lsrv.in.ua/api";

    public static String urlCreate(String endPoint){
        String url = startUrl+ endPoint;
        return url;
    }
}
