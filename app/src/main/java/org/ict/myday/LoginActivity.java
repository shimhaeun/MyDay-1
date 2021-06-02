package org.ict.myday;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.ict.myday.Login.LoginClient;
import org.ict.myday.Login.LoginDTO;
import org.ict.myday.Login.LoginService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText idText, passwordText;
    Button btn_login, btn_sign;
    CheckBox checkBox;

    private LoginClient loginClient;
    private LoginService loginService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = findViewById(R.id.insert_id);
        passwordText = findViewById(R.id.insert_password);
        btn_login = findViewById(R.id.btn_login);
        btn_sign = findViewById(R.id.btn_sign);
        checkBox = findViewById(R.id.autoLogin);

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String id = idText.getText().toString();
                String pw = passwordText.getText().toString();
                hideKeyboard();

                //로그인 정보 미입력 시
                if (id.trim().length() == 0 || pw.trim().length() == 0 || id == null || pw == null) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("알림")
                            .setMessage("로그인 정보를 입력바랍니다.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                } else {
                    //로그인 통신

                    LoginResponse();
                }
            }
        });
    }

    public void LoginResponse() {
        String userID = idText.getText().toString().trim();
        String userPassword = passwordText.getText().toString().trim();

        //loginRequest에 사용자가 입력한 id와 pw를 저장

        //retrofit 생성
        loginClient = LoginClient.getInstance();
        loginService = LoginClient.getLoginService();
        HashMap<String, String> map = new HashMap();
        map.put("mid", userID);
        map.put("mpw", userPassword);

        //loginRequest에 저장된 데이터와 함께 init에서 정의한 getLoginResponse 함수를 실행한 후 응답을 받음
        loginService.getLoginResponse(map).enqueue(new Callback<LoginDTO>() {
            @Override
            public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {

                if(response.isSuccessful()) {
                    //response.body()를 result에 저장
                    LoginDTO result = response.body();
                    Log.d("response", response.code()+"");

                    finish();
                } else {
                    Log.d("response", response.code()+"");
                    Log.d("로그인","onResponse: 실패");
                }

            }

            //통신 실패
            @Override
            public void onFailure(Call<LoginDTO> call, Throwable t) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("알림")
                        .setMessage("예기치 못한 오류가 발생하였습니다.")
                        .setPositiveButton("확인", null)
                        .create()
                        .show();
            }
        });
    }


    //키보드 숨기기
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(idText.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(passwordText.getWindowToken(), 0);
    }

    //화면 터치 시 키보드 내려감
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }


}