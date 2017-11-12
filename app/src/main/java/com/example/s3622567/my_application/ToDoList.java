package com.example.s3622567.my_application;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        final ListView listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(ToDoList.this, R.layout.list_item_todo, R.id.txtItem, arrayList);
        listView.setAdapter(adapter);

        txtInput = (EditText) findViewById(R.id.txtInput);
        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtInput.getText().toString();
                if (!txtInput.getText().toString().equals("")) {
                    arrayList.add(newItem);
                    adapter.notifyDataSetChanged();
                    txtInput.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter something!", Toast.LENGTH_LONG).show();
                }

            }

        });
        registerForContextMenu(listView);
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
                arrayList.remove(obj.position);
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("todo list tag", "now running onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("todo list tag", "now running onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("todo list tag", "now running onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("todo list tag", "now running onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("todo list tag", "now running onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("todo list tag", "now running onDestroy");
    }
}
