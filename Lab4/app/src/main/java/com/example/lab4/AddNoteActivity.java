package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

public class AddNoteActivity extends AppCompatActivity {

    EditText noteTitle;
    EditText noteContent;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitle = findViewById(R.id.note_title_editText);
        noteContent = findViewById(R.id.note_context_editText);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            noteTitle.setText(MainActivity.notesTitles.get(noteId));
            noteContent.setText(MainActivity.notesContents.get(noteId));
        }
    }

    public void onSaveAndCloseClick(View view) {
        if (!noteTitle.getText().toString().equals("")) {
            if (noteId != -1) {
                MainActivity.notesList.remove(MainActivity.notesTitles.get(noteId));
            }
            MainActivity.notesList.put(noteTitle.getText().toString(), noteContent.getText().toString());

            JSONObject jsonObject = new JSONObject(MainActivity.notesList);
            String jsonString = jsonObject.toString();

            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.lab4", MODE_PRIVATE);
            sharedPreferences.edit().putString("Notes", jsonString).apply();

            finish();
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The Title field cannot be empty!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}