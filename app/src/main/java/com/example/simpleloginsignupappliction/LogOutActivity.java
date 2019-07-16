package com.example.simpleloginsignupappliction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogOutActivity extends AppCompatActivity {

    Button mLogout;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

        initView();
    }

    private void initView() {

        mLogout=findViewById(R.id.buttonLogout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remove shared values and go to main screen

                mSharedPreferences=getSharedPreferences("SavingData",0);
                mEditor=mSharedPreferences.edit();
                mEditor.remove("USERNAME");
                mEditor.remove("USEREMAIL");
                mEditor.remove("USERPASSWORD");mEditor.apply();

                Intent intent=new Intent(LogOutActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
