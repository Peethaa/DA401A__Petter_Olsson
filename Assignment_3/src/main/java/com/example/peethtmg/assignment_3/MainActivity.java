package com.example.peethtmg.assignment_3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("<----onCreate---->", "MainActiviy");

        super.onCreate(savedInstanceState);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Log.i("Connected", "Connected");
        } else {
            Log.i("You sir:", "fucked up!");
        }

        setContentView(R.layout.activity_main);

        FragmentManager fM = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fT = fM.beginTransaction();

        fT.add(R.id.activityMain, new QuoteFragment());
        fT.commit();
    }
}