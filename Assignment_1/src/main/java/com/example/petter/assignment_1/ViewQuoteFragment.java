package com.example.petter.assignment_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Petter on 11-09-2015.
 */

public class ViewQuoteFragment extends Fragment {

    public static String getQuote(String[] arrayQuotes){
        Random r = new Random();
        return arrayQuotes[r.nextInt(9)];
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("<----onCreateView---->", "ViewQuoteFragment");

        View v = inflater.inflate(R.layout.view_quote, container, false);

        String[] arrayQuotes = getResources().getStringArray(R.array.arrayQuotes);
        String quotes = getQuote(arrayQuotes);

        TextView qView = (TextView) v.findViewById(R.id.qView);
        qView.setText(quotes);

        return v;
    }
}