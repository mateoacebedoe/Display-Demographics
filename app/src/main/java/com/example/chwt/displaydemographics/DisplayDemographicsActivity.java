package com.example.chwt.displaydemographics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDemographicsActivity extends AppCompatActivity {
    final String key = "06c538f6bef96e00f3e39ea1da23b9e810978b77";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String zip_code = intent.getStringExtra("zip_code");
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(zip_code);
        setContentView(textView);

    }
}
