package com.example.chwt.displaydemographics;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    final String KEY = "06c538f6bef96e00f3e39ea1da23b9e810978b77";
    final String args = "&get=P0010001,NAME&for=state:*";
    final String basePath = "http://api.census.gov/data/2010/sf1?key=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Find button */
    public void findDemographics(View view) {
        Intent intent = new Intent(this, DisplayDemographicsActivity.class);
        EditText zip_code_input = (EditText) findViewById(R.id.zip_code);
        String zip_code = zip_code_input.getText().toString();
        JSONArray requestResponse = getData();
        //TODO: change putExtra key
        String ip = requestResponse.toString();
//        try {
//            ip = requestResponse.getString("origin");
//        }catch (JSONException e){
//            System.out.println("***********didn't find key origin");
//        }
        intent.putExtra("zip_code", ip);
        startActivity(intent);
    }

    private JSONArray getData() {
        JSONArray result = null;
        System.out.println("*******get data");
        try {
            String path = basePath + KEY + args;
            System.out.println("**********path: " + path);
            URL url = new URL(path);
            try {
                URLConnection urlConnection = url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String resultString = readStream(in);
                System.out.println("****************resultString: " + resultString);
                result = new JSONArray(resultString);
                System.out.println("**********reading stream");
                in.close();
            } catch (IOException|JSONException e) {
                System.out.println("**********IO Exception");
                System.out.println(e.getMessage());
            }

        }catch (MalformedURLException e){
            System.out.println("*****************malformed url");
        }
        return result;
    }

    private String readStream(InputStream input){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(input));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}
