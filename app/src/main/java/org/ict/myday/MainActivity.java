package org.ict.myday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.ict.myday.Login.LoginClient;
import org.ict.myday.Login.LoginService;

public class MainActivity extends AppCompatActivity {

    private LoginClient loginClient;
    private LoginService loginService;
    ViewPager viewPager;
    ImageButton insBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        insBtn = (ImageButton) findViewById(R.id.insBtn);

        loginClient = LoginClient.getInstance();
        loginService = LoginClient.getLoginService();

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);

        insBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InsertActivity.class);
                startActivity(intent);
            }
        });
    }
}