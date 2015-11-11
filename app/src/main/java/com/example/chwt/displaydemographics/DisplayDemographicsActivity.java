package com.example.chwt.displaydemographics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.apache.http.client.HttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

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

    private void getData(){
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(new HttpGet(URL));
        StatusLine statusLine = response.getStatusLine();
        if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);
            String responseString = out.toString();
            out.close();
            //..more logic
        } else{
            //Closes the connection.
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        }
    }
}
