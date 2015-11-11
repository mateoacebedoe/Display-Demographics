package com.example.chwt.displaydemographics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Find button */
    public void findDemographics(View view) {
        Intent intent = new Intent(this, DisplayDemographicsActivity.class);
        EditText zip_code_input = (EditText) findViewById(R.id.zip_code);
        String zip_code = zip_code_input.getText().toString();
        intent.putExtra("zip_code", zip_code);
        startActivity(intent);
    }
}
