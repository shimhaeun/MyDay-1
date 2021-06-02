package org.ict.myday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.ict.myday.Diary.DiaryClient;
import org.ict.myday.Diary.DiaryExam;
import org.ict.myday.Diary.DiaryService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImageFragment extends Fragment {

    private RecyclerView imageRecycler;
    private RecyclerView.Adapter mAdapter;
    private StaggeredGridLayoutManager manager;
    public ArrayList<Object> mImageList = new ArrayList<>();

    private DiaryClient diaryClient;
    private DiaryService diaryService;

    private  int mno = 1;
    private  String mpw = "1111";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate
                (R.layout.fragment_image, container, false);

        initView(rootView);

        setRecycler();

        return rootView;

    }

    public void initView(View v){
        imageRecycler = (RecyclerView)v.findViewById(R.id.imageRecycler);
    }

    private void setRecycler(){

        manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        imageRecycler.setLayoutManager(manager);

        diaryClient = DiaryClient.getInstance();
        diaryService = DiaryClient.getDiaryService();

        diaryService.getDiaryService(mno).enqueue(new Callback<DiaryExam>() {
            @Override
            public void onResponse(Call<DiaryExam> call, Response<DiaryExam> response) {
                DiaryExam exam = response.body();
                mAdapter = new ImgTabAdapter(exam.getDiaryList());
                imageRecycler.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<DiaryExam> call, Throwable t) {

            }
        });


    }

}