package com.example.anagram_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_ANAGRAM = "anagram_text";
    private TextView mAnagramTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConvert = findViewById(R.id.btConvert);
        mAnagramTv = findViewById(R.id.tv_anagram);

        btConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final EditText etText = findViewById(R.id.et_text);
        final EditText etFilter = findViewById(R.id.et_filter);

        if (etText.getText().toString().isEmpty()) {
            mAnagramTv.setText(R.string.empty_text);
        } else {
            mAnagramTv.setText(StringUtils.getReverseString(
                    etText.getText().toString(),
                    etFilter.getText().toString()));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_ANAGRAM, mAnagramTv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAnagramTv.setText(savedInstanceState.getString(KEY_ANAGRAM));
    }
}