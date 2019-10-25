package com.example.finalpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText user,password; //=  findViewById(R.id.password) ;
    private Button loginButton; //= findViewById(R.id.login);

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String EMAILKEY = "emailKey";
    public static final String PASSKEY = "passKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        user = findViewById(R.id.username);
        password =  findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        TextView signup = (TextView)findViewById(R.id.SignUp);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if(CheckLogin(sharedpreferences.getString(EMAILKEY,user.getText().toString()),sharedpreferences.getString(PASSKEY,password.getText().toString()))){
            Intent main = new Intent(MainActivity.this,HomeActivity.class);
            Bundle b = new Bundle();
            b.putString("username",sharedpreferences.getString(EMAILKEY,user.getText().toString()));
            main.putExtras(b);
            startActivity(main);
        }else{
            loginButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String emailtemp = user.getText().toString();
                    String passtemp = password.getText().toString();

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(EMAILKEY,emailtemp);
                    editor.putString(PASSKEY,passtemp);
                    editor.commit();

                    if(CheckLogin(emailtemp,passtemp)){
                        Intent home = new Intent(MainActivity.this,HomeActivity.class);
                        Bundle b = new Bundle();
                        b.putString("username",user.getText().toString());
                        home.putExtras(b);
                        //finish();
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
    }
    private boolean CheckLogin(String user, String pass){
        if(user.equals("nathaniel.alvin@ti.ukdw.ac.id") && pass.equals("123456"))
            return true;
        else{
            Toast.makeText(this, "Email dan Password tidak sesuai", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
