package com.example.sleepy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });
    }

    public void openActivity4() {

        ArrayList<Integer> array = new ArrayList<>();
        EditText monday = findViewById(R.id.monday_hours);
        EditText tuesday = findViewById(R.id.tuesday_hours);
        EditText wednesday = findViewById(R.id.wednesday_hours);
        EditText thursday = findViewById(R.id.thursday_hours);
        EditText friday = findViewById(R.id.friday_hours);
        EditText saturday = findViewById(R.id.saturday_hours);
        EditText sunday = findViewById(R.id.sunday_hours);

        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("monday", monday.getText());
        intent.putExtra("tuesday", tuesday.getText());
        intent.putExtra("wednesday", wednesday.getText());
        intent.putExtra("thursday", thursday.getText());
        intent.putExtra("friday", friday.getText());
        intent.putExtra("saturday", saturday.getText());
        intent.putExtra("sunday", sunday.getText());
        startActivity(intent);
    }
}