package org.ict.myday.Diary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiaryClient {

    private static DiaryClient instance = null;
    private static DiaryService diaryService;
    private static String baseUrl = "http://10.0.2.2:8181";
    Gson gson = new GsonBuilder().setLenient().create();

    private DiaryClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        diaryService = retrofit.create(DiaryService.class);
    }

    public static DiaryClient getInstance(){
        if(instance == null){
            instance = new DiaryClient();
        }
        return instance;
    }

    public static DiaryService getDiaryService() { return  diaryService; }
}
