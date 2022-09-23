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

        Button mConvertBt = findViewById(R.id.bt_convert);
        mAnagramTv = findViewById(R.id.tv_anagram);

        mConvertBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final EditText mTextEt = findViewById(R.id.et_text);
        final EditText mFilterEt = findViewById(R.id.et_filter);

        if (mTextEt.getText().toString().isEmpty()) {
            mAnagramTv.setText(R.string.empty_text);
        } else {
            mAnagramTv.setText(StringUtils.getReverseString(
                    mTextEt.getText().toString(),
                    mFilterEt.getText().toString()));
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