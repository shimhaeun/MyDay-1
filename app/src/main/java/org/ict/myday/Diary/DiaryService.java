package org.ict.myday.Diary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DiaryService {
    @GET("diary/{mno}")
    Call<DiaryExam> getDiaryService(@Path("mno") int mno);

    @POST("diary/")
    Call<DiaryExam> setDiary(@Body Diary diaryData);
}
