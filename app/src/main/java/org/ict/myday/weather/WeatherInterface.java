package org.ict.myday.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {
        @GET("api.openweathermap.org/data/2.5/weather")
        Call getWeatherService(@Query("lat") String lat, @Query("lon") String lon, @Query("APPID") String app_id);
    }
