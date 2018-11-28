package com.daza.edner.nyecompanyusers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.daza.edner.nyecompanyusers.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonUser;
    private Button buttonRegister;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        buttonRegister = findViewById(R.id.ButtonRegister);
        buttonUser = findViewById(R.id.ButtonUsers);
        buttonRegister.setOnClickListener(this);
        buttonUser.setOnClickListener(this);
        intent = new Intent(SplashActivity.this, MainActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonRegister:

                break;
            case R.id.ButtonUsers:
                startActivity(intent);
                finish();
                break;
            default:

                break;
        }
    }
}
