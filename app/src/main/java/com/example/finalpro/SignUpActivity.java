package com.example.finalpro;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AutomaticZenRule;
import android.app.DownloadManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    //private static DownloadManager.Request builder;
    //AlertDialog.Builder builder = new AlertDialog.Builder(this);
    private EditText email;
    private EditText newPass;
    private EditText checkPass;
    private Button signUp;
    //@SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        email = findViewById(R.id.signupemail);
        newPass = findViewById(R.id.PasswordInp);
        checkPass = findViewById(R.id.PasswordRep);
        signUp = findViewById(R.id.signupbutton);
        signUp.setOnClickListener(new View.OnClickListener(){
            //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view){
                if(passCheck(String.valueOf(newPass.getText()),String.valueOf(checkPass.getText()),String.valueOf(email.getText()))){
                    Intent home = new Intent(SignUpActivity.this,HomeActivity.class);
                    finish();
                    startActivity(home);
                }

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean passCheck(String passNew, String passRep, String mail){
        if(passNew.isEmpty() == false && mail.isEmpty() == false && passNew.equals(passRep)){
            Toast.makeText(this, "Sign Up Berhasil!", Toast.LENGTH_SHORT).show();
            return true;
        }else if(passNew.isEmpty() || passRep.isEmpty() || mail.isEmpty()){
            Toast.makeText(this, "Field Harus terisi", Toast.LENGTH_SHORT).show();
           return false;
        }else if(passNew.equals(passRep) == false){
            Toast.makeText(this, "Password Tidak Sama", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return false;
        }

    }
}
