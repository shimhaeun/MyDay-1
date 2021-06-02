package org.ict.myday.weather2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodaysWeather {

    @SerializedName("response")
    @Expose
    private Exam example;

    public Exam getExample() {
        return example;
    }

    public void setExample(Exam example) {
        this.example = example;
    }

}