package com.example.s3622567.my_application;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("main activity tag", "now running onCreate");
        super.onCreate(savedInstanceState);
        Log.i("main activity tag", "now running onCreate");
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd  hh:mm aa");
        String formattedDate = "Today is \n" + df.format(c.getTime());

        TextView today = (TextView) findViewById(R.id.today);
        today.setText(formattedDate);
    }

    public void onClickButtonToDo(View view) {
        Intent intent = new Intent(this, ToDoList.class);
        startActivity(intent);
    }

    public void onClickButtonEvent(View view) {
        Intent intent = new Intent(this, EventList.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("main activity tag", "now running onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("main activity tag", "now running onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("main activity tag", "now running onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("main activity tag", "now running onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("main activity tag", "now running onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("main activity tag", "now running onDestroy");
    }
}
