package com.example.simpleloginsignupappliction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText mName,mEmail,mPassowrd,mConPassowrd;
    Button mSignUp;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mEditor;
    String mUserName,mUserEmail,pass1,pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();

        //initialize views by ids
    }

    private void initViews() {
        mName=findViewById(R.id.editText3);
        mEmail=findViewById(R.id.editText4);
        mPassowrd=findViewById(R.id.editText5);
        mConPassowrd=findViewById(R.id.editText6);
        mSignUp=findViewById(R.id.button2);

      mSignUp.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              checkEmptiness();
          }
      });
        //check if there is any field stay empty
    }

    private void checkEmptiness() {


        if(mName.getText().toString() != null && mPassowrd.getText().toString() != null && mEmail.getText().toString() != null && mConPassowrd.getText().toString() != null)
        {
            checkIfPasswordMatces();
        }else
        {
            Toast.makeText(this,"all fileds are required",Toast.LENGTH_LONG).show();
        }


    }

    private void checkIfPasswordMatces() {

        //get all values into strings

         mUserName=mName.getText().toString();
         mUserEmail=mEmail.getText().toString();
         pass1=mPassowrd.getText().toString();
        pass2=mConPassowrd.getText().toString();
        if(pass1.equals(pass2))
        {

            // save those values
            savingIntoShaaredP();



        }
        else
        {
            Log.v("null","null");
        }
    }

    private void savingIntoShaaredP() {

        mSharedPreferences=getSharedPreferences("SavingData",0);
        mEditor=mSharedPreferences.edit();
        mEditor.putString("USERNAME",mUserName);
        mEditor.putString("USEREMAIL",mUserEmail);
        mEditor.putString("USERPASSWORD",pass1);
        mEditor.apply();

        Toast.makeText(this,"Same",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);



    }
}
