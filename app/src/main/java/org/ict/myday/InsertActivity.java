package org.ict.myday;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.ict.myday.weather.Coord;
import org.ict.myday.weather.Example;
import org.ict.myday.weather.TodaysWeather;
import org.ict.myday.weather.WeatherInterface;
import org.ict.myday.weather2.Exam;
import org.ict.myday.weather2.Items;
import org.ict.myday.weather2.WeatherClient;
import org.ict.myday.weather2.WeatherService;

import java.lang.ref.Reference;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InsertActivity extends AppCompatActivity {

        Button insBtn2, imgInsBtn;
        TextView tdDate, tdWeather;
        ImageView insImg;

        private WeatherClient weatherClient;
        private WeatherInterface weatherInterface;
        private final int GET_GALLERY_IMAGE = 200;

        public static String BaseUrl = "http://api.openweathermap.org/";
        public static String AppId = "44e02f3ac9644a3424e2cda1d4e9078a";
        public static String lat = "35";
        public static String lon = "139";

        public static Context mContext;
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
        String formatDate = sdf.format(date);

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_insert);
            insBtn2 = (Button) findViewById(R.id.insBtn2);
            tdDate = (TextView)findViewById(R.id.tdDate);
            tdWeather = (TextView)findViewById(R.id.tdWeather);
            imgInsBtn = (Button) findViewById(R.id.imgInsBtn);
            insImg = (ImageView) findViewById(R.id.insImg);
            mContext = this;

            tdDate.setText(formatDate);

            // 레이아웃 생성
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.VERTICAL);


            weatherClient = WeatherClient.getInstance();
            if (weatherClient == null){
                Log.d("dd", "onCreate: dddd");
            }

            weatherInterface = WeatherClient.getWeatherInterface;
            if (weatherInterface == null){
                Log.d("dd", "onCreate: gggg");
            }

/*                        @Override
                        public void onResponse(Call<Exam> call, Response<Exam> response) {
                            Exam exam = response.body();

                            Log.d("check", response.body()+"");

                        @Override
                        public void onFailure(Call<Exam> call, Throwable t) {
                            Log.d("check", t+"");
                            Toast.makeText(InsertActivity.this,"호출 실패",Toast.LENGTH_SHORT).show();
                        }
                    });*/
            final Call call = weatherInterface.getWeatherService(lat,lon,AppId);
            Retrofit.Builder BaseUrl = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/");
            call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful())
                            Log.e("Success", new Gson().toJson(response.body()));
                        else
                            Log.e("unSuccess", new Gson().toJson(response.errorBody()));

                    Example example = response.body();
                    TodaysWeather todaysWeather = example.getTodaysWeather();
                    }


                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.e("onFailure", t.toString());
                    }
                });


            // 레이아웃 파라미터 생성
            LinearLayout.LayoutParams linearLayoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT);

            // EditText를 생성한 후 파라미터 설정
            EditText editText = new EditText(this);
            editText.setHint("제목");


            insBtn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext,"등록되었습니다!",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            imgInsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent intent = new Intent(Intent.ACTION_PICK);
                    //intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent, GET_GALLERY_IMAGE);
                }
            });
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {

                Uri selectedImageUri = data.getData();
                insImg.setImageURI(selectedImageUri);
                insImg.setVisibility(View.VISIBLE);
            }

        }
    }