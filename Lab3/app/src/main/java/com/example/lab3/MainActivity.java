package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultEditText = findViewById(R.id.results);
        resultEditText.setShowSoftInputOnFocus(false);
    }

    public void addText(String str) {
        String currentText = resultEditText.getText().toString();
        resultEditText.setText(String.format("%s%s", currentText, str));
    }

    public void onBtnOneClick(View view) {
        addText("1");
    }

    public void onBtnTwoClick(View view) {
        addText("2");
    }

    public void onBtnThreeClick(View view) {
        addText("3");
    }

    public void onBtnFourClick(View view) {
        addText("4");
    }

    public void onBtnFiveClick(View view) {
        addText("5");
    }

    public void onBtnSixClick(View view) {
        addText("6");
    }

    public void onBtnSevenClick(View view) {
        addText("7");
    }

    public void onBtnEightClick(View view) {
        addText("8");
    }

    public void onBtnNineClick(View view) {
        addText("9");
    }

    public void onBtnZeroClick(View view) {
        addText("0");
    }

    public void onBtnPlusClick(View view) {
        if (!resultEditText.getText().toString().endsWith("+")) {
            addText("+");
        }
    }

    public void onBtnMinusClick(View view) {
        if (!resultEditText.getText().toString().endsWith("-")) {
            addText("-");
        }
    }

    public void onBtnMultiplicationClick(View view) {
        if (!resultEditText.getText().toString().endsWith("*")) {
            addText("*");
        }
    }

    public void onBtnDivisionClick(View view) {
        if (!resultEditText.getText().toString().endsWith("/")) {
            addText("/");
        }
    }

    public void onBtnClearClick(View view) {
        resultEditText.setText("");
    }

    public void onBtnBackClick(View view) {
        String text = resultEditText.getText().toString();
        resultEditText.setText(text.substring(0, text.length() - 1));
    }

    public void onBtnSignChangeClick(View view) {
        if (resultEditText.getText().toString().startsWith("-")) {
            String text = resultEditText.getText().toString();
            resultEditText.setText(text.substring(1, text.length()));
        } else {
            String text = resultEditText.getText().toString();
            resultEditText.setText("");
            addText("-");
            addText(text);
        }
    }

    public void onBtnEqualClick(View view) {
        String userExp = resultEditText.getText().toString();
        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());
        resultEditText.setText(result);
        resultEditText.setSelection(result.length());
    }

    public void onBtnDotClick(View view) {
        if (!resultEditText.getText().toString().endsWith(".")) {
            addText(".");
        }
    }

    public void onBtnSquareRootClick(View view) {
        if (!resultEditText.getText().toString().endsWith("√")) {
            addText("√");
        }
    }
}