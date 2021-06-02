package org.ict.myday.weather2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.ict.myday.weather.WeatherInterface;
import org.ict.myday.weather2.WeatherService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    public static WeatherInterface getWeatherInterface;
    private static WeatherClient instance = null;
    private static WeatherService weatherService;
    private String baseUrl = "http://apis.data.go.kr";
    public WeatherClient(){
        Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }
    public static WeatherClient getInstance(){
        if(instance == null){

            instance = new WeatherClient();
        }
        return  instance;
    }
    public static WeatherService getWeatherService() { return weatherService; }

}
