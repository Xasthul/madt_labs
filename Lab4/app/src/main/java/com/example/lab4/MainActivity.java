package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ListView notesListView;
    TextView emptyTextView;
    static HashMap<String, String> notesList = new HashMap<>();
    static ArrayList<String> notesTitles;
    static ArrayList<String> notesContents;
    static ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesListView = findViewById(R.id.notes_listView);
        emptyTextView = findViewById(R.id.empty_textView);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.lab4", MODE_PRIVATE);
        String jsonString = sharedPreferences.getString("Notes", (new JSONObject()).toString());
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            Iterator<String> keysItr = jsonObject.keys();
            while (keysItr.hasNext()) {
                String key = keysItr.next();
                String value = jsonObject.getString(key);
                notesList.put(key, value);
            }
        } catch (JSONException e) {
        }

    }

    @Override
    protected void onStart() {

        notesTitles = new ArrayList<>(notesList.keySet());
        notesContents = new ArrayList<>(notesList.values());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesTitles);
        notesListView.setAdapter(adapter);

        if (!notesList.isEmpty()) {
            emptyTextView.setVisibility(View.GONE);
        } else {
            emptyTextView.setVisibility(View.VISIBLE);
        }

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), AddNoteActivity.class);
                intent.putExtra("noteId", i);
                startActivity(intent);
            }
        });

        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_note:
                Intent i = new Intent(this, AddNoteActivity.class);
                startActivity(i);
                return true;
            case R.id.remove_note:
                Intent r = new Intent(this, DeleteNoteActivity.class);
                startActivity(r);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}