package org.ict.myday.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("TodaysWeather")
    @Expose
    private TodaysWeather todaysWeather;

    public TodaysWeather getTodaysWeather() { return  todaysWeather; }

    public void setTodaysWeather(TodaysWeather todaysWeather) {
        this.todaysWeather = todaysWeather;
    }

}
