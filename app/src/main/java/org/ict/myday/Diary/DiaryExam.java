package org.ict.myday.Diary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiaryExam {

    @SerializedName("diaryList")
    @Expose
    private List<Diary> diaryList = null;


    public List<Diary> getDiaryList() {
        return diaryList;
    }

    public void setDiaryList(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

}