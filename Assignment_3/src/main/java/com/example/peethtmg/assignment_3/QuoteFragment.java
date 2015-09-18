package com.example.peethtmg.assignment_3;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteFragment extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("<----onCreate---->", "QuoteFragment");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("<----onCreateView---->", "QuoteFragment");
        View v = inflater.inflate(R.layout.quote_view, container, false);

        Context context =


        ContextCompat.getDrawable(container, R.drawable.ic_add_circle_black_36dp);

        //Button button = (Button) v.findViewById(R.id.qButton);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
