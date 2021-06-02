package org.ict.myday;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.myday.Diary.DiaryClient;
import org.ict.myday.Diary.DiaryExam;
import org.ict.myday.Diary.DiaryService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {

    RecyclerView listRecycler;
    RecyclerView.Adapter lAdapter;
    LinearLayoutManager manager;

    private DiaryClient diaryClient;
    private DiaryService diaryService;

    private int mno = 1;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        initView(rootView);
        setRecycler();

        return rootView;
    }



    public void initView(View v){
        listRecycler = (RecyclerView) v.findViewById(R.id.listRecycler);
    }


    private void setRecycler(){
        manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listRecycler.setLayoutManager(manager);
        // 레트로핏 객체를 생성해 DB와 통신 준비 완료
        diaryClient = DiaryClient.getInstance();

        // 레트로핏 인터페이스를 생성해 DB와 통신시 요청할 메서드 준비 완료
        diaryService = DiaryClient.getDiaryService();

        //$.ajax에 대응하는 레트로핏 문법 작성합니다.
        diaryService.getDiaryService(mno).enqueue(new Callback<DiaryExam>() {
            @Override
            public void onResponse(Call<DiaryExam> call, Response<DiaryExam> response) {
                DiaryExam exam = response.body();
                lAdapter = new ListAdapter(exam.getDiaryList());
                listRecycler.setAdapter(lAdapter);
            }

            @Override
            public void onFailure(Call<DiaryExam> call, Throwable t) {
                Log.d("onFailure",t.getMessage());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
