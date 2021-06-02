package org.ict.myday;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.ict.myday.Login.LoginClient;
import org.ict.myday.Login.LoginDTO;
import org.ict.myday.Login.LoginService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JoinActivity extends AppCompatActivity {

    EditText join_ID, join_PW;
    Button btn_joinMem;
    private LoginClient loginClient;
    private LoginService loginService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_ID = findViewById(R.id.join_ID);
        join_PW = findViewById(R.id.join_PW);
        btn_joinMem = findViewById(R.id.btn_joinMem);

        loginClient = LoginClient.getInstance();
        loginService = LoginClient.getLoginService();

        btn_joinMem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> map = new HashMap();
                String userID = join_ID.getText().toString().trim();
                String userPassword = join_PW.getText().toString().trim();
                map.put("mid", userID);
                map.put("mpw", userPassword);
                loginService.joinMem(map).enqueue(new Callback<LoginDTO>() {
                    @Override
                    public void onResponse(Call<LoginDTO> call, Response<LoginDTO> response) {
                        join_ID.setText("");
                        join_PW.setText("");
                        finish();
                    }

                    @Override
                    public void onFailure(Call<LoginDTO> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

    }
}
