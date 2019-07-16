package com.example.simpleloginsignupappliction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mSignuphere;
    EditText ed1, ed2;
    Button mLogin;
    SharedPreferences mSharedPreferences;
    String enteredEmail, enteredPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

    }

    private void initializeViews() {

        mSignuphere = findViewById(R.id.signuphere);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        mLogin = findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enteredEmail = ed1.getText().toString();
                enteredPassWord = ed2.getText().toString();
                if (enteredEmail != null && enteredPassWord != null) {
                    //authenticate user
                    checkEmailAndPassword();
                } else {
                    Toast.makeText(getApplicationContext(), "enter parameters/signup first", Toast.LENGTH_LONG).show();
                }


            }
        });

        mSignuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void checkEmailAndPassword() {
        mSharedPreferences = getSharedPreferences("SavingData", 0);
        String email = mSharedPreferences.getString("USEREMAIL", "user");
        String password = mSharedPreferences.getString("USERPASSWORD", "user");

        if (enteredEmail.equals(email) && enteredPassWord.equals(password)) {
            Intent intent = new Intent(MainActivity.this, LogOutActivity.class);
            startActivity(intent);
            finish();
        } else {
            if (!enteredEmail.equals(email)) {
                ed1.setError("wrong email entered");
            } else if (!enteredPassWord.equals(password)) {
                ed2.setError("wrong password entered");
            } else if (!enteredEmail.equals(email) && !enteredPassWord.equals(password)) {

                Toast.makeText(getApplicationContext(), "Empty fields", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "something wrong", Toast.LENGTH_LONG).show();
            }
        }


    }
}