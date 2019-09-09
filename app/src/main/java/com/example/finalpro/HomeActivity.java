package com.example.finalpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button about;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        about = findViewById(R.id.about);
        exit = findViewById(R.id.exit);
        prepare();
        about.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               Intent about = new Intent(HomeActivity.this,AboutActivity.class);
              // finish();
               //setContentView(R.layout.about_activity);
               startActivity(about);
           }
        });
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }

    private void prepare(){
        this.getSupportFragmentManager().beginTransaction().add(R.id.frameexample, new HomeActivityFragment()).commit();
    }
}
