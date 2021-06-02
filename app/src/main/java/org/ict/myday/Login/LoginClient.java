package org.ict.myday.Login;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    private static LoginClient instance = null;
    private static LoginService loginService;
    private static String baseUrl = "http://10.0.2.2:8181";

    private LoginClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);
    }

    public static LoginClient getInstance() {
        if(instance == null){
            instance = new LoginClient();
        }
        return instance;
    }

    public static LoginService getLoginService() { return loginService; }
}
