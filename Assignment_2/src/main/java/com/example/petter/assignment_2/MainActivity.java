package com.example.petter.assignment_2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Petter on 11-09-2015.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i("<----onCreate---->", "MainActiviy");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction fT = fM.beginTransaction();

        fT.add(R.id.activityMain, new MovieListFragment());
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