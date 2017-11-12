package com.example.s3622567.my_application;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class EventList extends AppCompatActivity {

    ArrayList<String> eventArrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        final ListView eventListView = (ListView) findViewById(R.id.eventList);
        eventArrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(EventList.this, R.layout.list_item_event, R.id.txtTitle, eventArrayList);
        eventListView.setAdapter(adapter);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputBox();
            }
        });
        registerForContextMenu(eventListView);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EventList.this, EventDetail.class);
                String eventDetail = eventArrayList.get(position);
                intent.putExtra("eventDetail", eventDetail);
                startActivity(intent);
            }
        });
    }

    public void showInputBox(){
        final Dialog dialog = new Dialog(EventList.this);
        dialog.setTitle("Add new event");
        dialog.setContentView(R.layout.input_box);

        final EditText titleInput = (EditText) dialog.findViewById(R.id.titleInput);

        final Button eventAdd = (Button) dialog.findViewById(R.id.eventAdd);
        eventAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.datePicker2);
                String year = String.valueOf(datePicker.getYear());
                String month = String.valueOf(datePicker.getMonth()+1);
                String day = String.valueOf(datePicker.getDayOfMonth());

                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String currentDate = df.format(c.getTime());
                String eventDate = day+"/"+month+"/"+year;

                String newEvent = null;
                try {
                    newEvent = titleInput.getText().toString() + "\n"
                            + "Event date: " + eventDate + " ( " + difference(currentDate, eventDate) + " days left )";
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (!titleInput.getText().toString().equals("")) {
                    eventArrayList.add(newEvent);
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter something!", Toast.LENGTH_LONG).show();
                }
            }
        });
        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String difference(String currentDate, String eventDate) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = df.parse(currentDate);
        Date date2 = df.parse(eventDate);
        long difference = date2.getTime() - date1.getTime();
        long dayDifference = difference/(1000*60*60*24);
        return String.valueOf(dayDifference);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu_file, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo obj = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete :
                eventArrayList.remove(obj.position);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("event list tag", "now running onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("event list tag", "now running onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("event list tag", "now running onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("event list tag", "now running onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("event list tag", "now running onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("event list tag", "now running onDestroy");
    }
}