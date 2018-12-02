package com.libandexample.tutorials.codinginflow.intentservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.libandexample.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class IntentServiceMainActivity extends AppCompatActivity {
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startService(View v) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this, ExampleIntentService.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);
    }
}
