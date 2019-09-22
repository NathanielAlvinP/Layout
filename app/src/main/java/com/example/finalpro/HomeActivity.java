package com.example.finalpro;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    private Button about;
    private Button exit;

    public static final String  Wifi_Manager_ID = "wifiManager";
    private NotificationManagerCompat notificationManagerCompat;
    private boolean wifiConnected;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        //ViewPager untuk slide
        ViewPager viewpager = findViewById(R.id.view_pager);
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(), 2));


        //Bundle Retrieve
        Bundle bundle = getIntent().getExtras();
        String s = bundle.getString("username");
        Toast.makeText(this, "Welcome, " + s, Toast.LENGTH_SHORT).show();

        //Tab Layout untuk berpindah fragment
        TabLayout tableLayout = findViewById(R.id.tab_layout);
        tableLayout.setupWithViewPager(viewpager);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });


        createNotificationChannels();
        notificationManagerCompat = NotificationManagerCompat.from(this);
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
                    wifiConnected = true;
                    //Toast.makeText(context, "Wifi On", Toast.LENGTH_SHORT).show();
                    sendOnNotification();
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiConnected = false;
                    //Toast.makeText(context, "Wifi Off", Toast.LENGTH_SHORT).show();
                    sendOnNotification();
                    break;
            }
        }
    };
    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel wifi_manager = new NotificationChannel(Wifi_Manager_ID, "Wifi Manager", NotificationManager.IMPORTANCE_HIGH);
            wifi_manager.setDescription("This is Wifi Manager");
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(wifi_manager);
        }
    }
    public void sendOnNotification(){
        String content;

//        Intent activityIntent = new Intent(this, HomeActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this,0,activityIntent, 0);
        if(wifiConnected){
            content = "Wifi is On";
        }else{
            content = "Wifi is Off";
        }
        Notification notification = new NotificationCompat.Builder(this, Wifi_Manager_ID)
                .setSmallIcon(R.drawable.ic_wifi)
                .setContentTitle("Wifi Manager")
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setContentIntent(contentIntent)
                .build();
        notificationManagerCompat.notify(1, notification);
    }
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
