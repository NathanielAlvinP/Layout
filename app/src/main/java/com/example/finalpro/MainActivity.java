package com.example.finalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText user; //= findViewById(R.id.username);
    private EditText password; //=  findViewById(R.id.password) ;
    private Button loginButton; //= findViewById(R.id.login);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        user = findViewById(R.id.username);
        password =  findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        TextView signup = (TextView)findViewById(R.id.SignUp);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(CheckLogin(String.valueOf(user.getText()),String.valueOf(password.getText()))){
                    Intent home = new Intent(MainActivity.this,HomeActivity.class);
                    finish();
                    startActivity(home);
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent daftar = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(daftar);
            }
        });
    }
    public static boolean CheckLogin(String user, String pass){
        return user.equals("nathaniel.alvin@ti.ukdw.ac.id") && pass.equals("123456");
    }
}
