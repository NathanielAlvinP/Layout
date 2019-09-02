package com.example.finalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText username = findViewById(R.id.username);
    EditText password =  findViewById(R.id.password);

    String pass = password.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

    }

    public void checkInput(){
//        if(this.user == "admin"){
//            if(this.pass =="12345") {
//                setContentView(R.layout.activity_main);
//            }
//        }else{
//            setContentView(R.layout.login_activity);
//        }
    }
}
