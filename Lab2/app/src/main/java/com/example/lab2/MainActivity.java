package com.example.lab2;

import static com.example.lab2.CountFunctions.countChars;
import static com.example.lab2.CountFunctions.countWords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.Spinner1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Count words");
        arrayList.add("Count characters");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Context context = getApplicationContext();
        CharSequence text = getString(R.string.toast_text);
        int duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);
    }

    public void onButton1Click(View view) {
        EditText editTextInput = findViewById(R.id.EditText1);
        TextView textViewResults = findViewById(R.id.TextView1);
        String textFromTextView = editTextInput.getText().toString();
        if (textFromTextView.equals("")) {
            toast.show();
        } else {
            if (spinner.getSelectedItem().toString().equals("Count words")) {
                textViewResults.setText(getString(R.string.result) + countWords(textFromTextView) + getString(R.string.words));
            } else {
                textViewResults.setText(getString(R.string.result) + countChars(textFromTextView) + getString(R.string.characters));
            }
        }
    }
}