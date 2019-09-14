package com.example.finalpro;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    private Button about;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ViewPager viewpager = findViewById(R.id.view_pager);
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(),2));

        TabLayout tableLayout = findViewById(R.id.tab_layout);
        tableLayout.setupWithViewPager(viewpager);
        //about = findViewById(R.id.about);
        exit = findViewById(R.id.exit);
       // prepare();
//        about.setOnClickListener(new View.OnClickListener(){
//           @Override
//            public void onClick(View view){
//               Intent about = new Intent(HomeActivity.this,AboutActivity.class);
//              // finish();
//               //setContentView(R.layout.about_activity);
//               startActivity(about);
//           }
//        });
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }

//    private void prepare(){
//        this.getSupportFragmentManager().beginTransaction().add(R.id.frameexample, new HomeActivityFragment()).commit();
//    }
}
