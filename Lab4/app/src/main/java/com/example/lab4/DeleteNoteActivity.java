package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONObject;

public class DeleteNoteActivity extends AppCompatActivity {

    ListView notesListView;
    TextView emptyTextView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        emptyTextView = findViewById(R.id.empty_textView);
        notesListView = findViewById(R.id.notes_listView);
    }

    @Override
    protected void onStart() {

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.notesTitles);
        notesListView.setAdapter(adapter);

        if (!MainActivity.notesList.isEmpty()) {
            emptyTextView.setVisibility(View.GONE);
        } else {
            emptyTextView.setVisibility(View.VISIBLE);
        }

        notesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int itemToDelete = i;

                new AlertDialog.Builder(DeleteNoteActivity.this)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this note?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.notesList.remove(MainActivity.notesTitles.get(itemToDelete));
//                                MainActivity.notesTitles = new ArrayList<>(MainActivity.notesList.keySet());
//                                adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, MainActivity.notesTitles);
//                                notesListView.setAdapter(adapter);
                                MainActivity.notesTitles.remove(itemToDelete);
                                adapter.notifyDataSetChanged();

                                JSONObject jsonObject = new JSONObject(MainActivity.notesList);
                                String jsonString = jsonObject.toString();

                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.lab4", MODE_PRIVATE);
                                sharedPreferences.edit().putString("Notes", jsonString).apply();

                                if (!MainActivity.notesList.isEmpty()) {
                                    emptyTextView.setVisibility(View.GONE);
                                } else {
                                    emptyTextView.setVisibility(View.VISIBLE);
                                }
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        super.onStart();
    }
}