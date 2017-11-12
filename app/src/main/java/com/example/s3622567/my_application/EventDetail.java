package com.example.s3622567.my_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class EventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        Bundle bundle = getIntent().getExtras();
        String detail = bundle.getString("eventDetail");
        TextView eventName = (TextView) findViewById(R.id.eventName);
        eventName.setText(detail);


//        int dateStart = 0;
//        if (detail != null) {
//            dateStart = detail.indexOf(":");
//        }
//        ArrayList<String> eventNameOnly = null;
//        for (int i = 0; i < dateStart-11; i++) {
//            if (detail != null) {
//                eventNameOnly.add(Character.toString(detail.charAt(i)));
//            }
//        }
//        TextView eventName = (TextView) findViewById(R.id.eventName);
//        if (eventNameOnly != null) {
//            eventName.setText(eventNameOnly.toString());
//        }
//
//        ArrayList<String> eventDayOnly = null;
//        if (detail != null) {
//            for (int i = dateStart+1; i < detail.length()-1; i++) {
//                eventDayOnly.add(Character.toString(detail.charAt(i)));
//            }
//        }
//        TextView eventDay = (TextView) findViewById(R.id.eventDay);
//        eventDay.setText(eventDayOnly.toString());
    }

    public void onClickButtonSaveMemo(View view) {
        Intent intent = new Intent(this, EventList.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("event detail tag", "now running onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("event detail tag", "now running onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("event detail tag", "now running onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("event detail tag", "now running onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("event detail tag", "now running onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("event detail tag", "now running onDestroy");
    }
}
