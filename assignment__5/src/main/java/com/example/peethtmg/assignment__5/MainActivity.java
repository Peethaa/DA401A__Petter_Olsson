package com.example.peethtmg.assignment__5;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
