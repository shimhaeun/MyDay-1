package org.ict.myday.weather2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("http://apis.data.go.kr/1360000/AsosHourlyInfoService/getWthrDataList")
    Call<Exam> getWeatherService(@Query("ServiceKey") String serviceKey, @Query("dataCd") String dataCd,
                                 @Query("dateCd") String dateCd, @Query("startDt") String startDt,
                                 @Query("startHh") String startHh, @Query("endDt") String endDt,
                                 @Query("endHh") String endHh, @Query("stnIds") String stnIds,
                                 @Query("dataType") String dataType);

}