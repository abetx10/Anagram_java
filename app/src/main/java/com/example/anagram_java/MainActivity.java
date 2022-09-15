package com.example.anagram_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String anagramText;
    TextView tvAnagram;
    private static final String KEY_ANAGRAM = "anagram_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etText = findViewById(R.id.et_text);
        EditText etFilter = findViewById(R.id.et_filter);
        Button btConvert = findViewById(R.id.btConvert);
        tvAnagram = findViewById(R.id.tv_anagram);


        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etText.getText().toString();
                String filter = etFilter.getText().toString();
                anagramText = Reverse.getReverseString(text,filter);
                tvAnagram.setText(anagramText);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_ANAGRAM, anagramText);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        anagramText = savedInstanceState.getString(KEY_ANAGRAM);
        tvAnagram.setText(anagramText);

    }
}