package com.example.finalpro;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    private Button about;
    private Button exit;
    private boolean isReceiverRegistered = false;
    private WifiManager wifiManager;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ViewPager viewpager = findViewById(R.id.view_pager);
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(), 2));

//        Bundle bundle = getIntent().getExtras();
//        String s = bundle.getString("username");
//        Toast.makeText(this, "Welcome, " + s, Toast.LENGTH_SHORT).show();

        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("username");
        Toast.makeText(this, "Welcome, " + s, Toast.LENGTH_SHORT).show();

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
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }

    //    private void prepare(){
//        this.getSupportFragmentManager().beginTransaction().add(R.id.frameexample, new HomeActivityFragment()).commit();
//    }
    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiReceiver, intentFilter);
    }
    protected void onStop(){
        super.onStop();
        unregisterReceiver(wifiReceiver);
    }
    private BroadcastReceiver wifiReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            //        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            //        if (networkInfo != null) {
            //            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            //                Toast.makeText(context, "Wifi On", Toast.LENGTH_SHORT).show();
            //                if (wifiConnected == true) {
            //                }
            //            }
            //        } else {
            //            Toast.makeText(context, "Wifi Off", Toast.LENGTH_SHORT).show();
            //        }
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            switch(wifiStateExtra){
                case WifiManager.WIFI_STATE_ENABLED:
                    Toast.makeText(context, "Wifi On", Toast.LENGTH_SHORT).show();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    Toast.makeText(context, "Wifi Off", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

//    protected void onResume(){
//        super.onResume();
//        if(!isReceiverRegistered){
//            wifiConnected = true;
//            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
//        }
//    }
//    protected void onPause(){
//        super.onPause();
//        if(isReceiverRegistered){
//            wifiConnected = false;
//            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
//        }
//    }
}
