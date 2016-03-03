package com.example.sheldonsnyder.notification;

import android.support.v7.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);

        // after clicking a notification, removes the notification form the status bars
        notification.setAutoCancel(true);
    }





    public void onClickNotification(View view){
        // BUILDS THE NOTIFICATION...customizing to liking
        //notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setSmallIcon(R.drawable.ic_stat_slsrecycle);
        notification.setTicker("this is the ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the title!!");
        notification.setContentText("I am the body of the notification!!!");


        // WHEN EVER THE NOTIFICATION IS CLICKED
        // when user click this, what to do (this for context, and name of class to be sent to
        Intent intent = new Intent(this, MainActivity.class);

        // give the device assess to the intent...user likely wont be in the current app when
        // a notification comes in so a normal intent.startActivity() wont work
        // gives the phone the ability to go to this intent from any other location within the phone.
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // sets the intent
        notification.setContentIntent(pendingIntent);


        // ISSUES THE NOTIFICATION TO THE PHONE for display
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());
    }
}