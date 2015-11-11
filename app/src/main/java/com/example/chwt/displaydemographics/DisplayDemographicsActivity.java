package com.example.chwt.displaydemographics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DisplayDemographicsActivity extends AppCompatActivity {

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

/*    private void getData() throws IOException{
        URL url = new URL("http://catalog.data.gov/api/3");
        URLConnection urlConnection = url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        try {
            //readStream(in);
            System.out.println("reading stream");
        } finally {
            in.close();
        }
    }*/
}
