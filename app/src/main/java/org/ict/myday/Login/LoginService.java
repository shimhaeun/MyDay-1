package org.ict.myday.Login;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {
    @POST("member/loginPost")
    Call<LoginDTO> getLoginResponse(@Body Map<String, String> map);

    @POST("member/joinMem")
    Call<LoginDTO> joinMem(@Body Map<String, String> map);
}
