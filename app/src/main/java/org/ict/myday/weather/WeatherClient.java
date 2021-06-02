package org.ict.myday.weather;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.ict.myday.weather2.WeatherService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    public static WeatherInterface getWeatherInterface;
    private static org.ict.myday.weather2.WeatherClient instance = null;
    private static WeatherService weatherService;
    private String baseUrl = "https://openweathermap.org/";
    private WeatherClient(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }
    public static org.ict.myday.weather2.WeatherClient getInstance(){
        if(instance == null){
            instance = new org.ict.myday.weather2.WeatherClient();
        }
        return  instance;
    }
    public static WeatherInterface getWeatherInterface() { return getWeatherInterface; }

}