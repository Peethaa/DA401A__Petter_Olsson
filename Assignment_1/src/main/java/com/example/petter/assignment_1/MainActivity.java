package com.example.petter.assignment_1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by Petter on 10-09-2015.
 */

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("<----onCreate---->", "MainActiviy");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();

        fT.add(R.id.activityMain, new GetQuoteFragment());
        fT.commit();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.i("<----Start---->", "Aktivitet startad");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i("<----Avsluta---->", "Aktivitet avslutad");

        // Stop method tracing that the activity started during onCreate()
        android.os.Debug.stopMethodTracing();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.i("<----Återuppta---->", "Aktivitet återupptagen.");

    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.i("<----Paus---->", "Aktivitet minimerad/pausad");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.i("<----Stop---->", "Aktivitet Minimerats/Stoppats");
    }
}