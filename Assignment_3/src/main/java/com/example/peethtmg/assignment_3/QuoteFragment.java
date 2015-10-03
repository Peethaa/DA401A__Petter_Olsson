package com.example.peethtmg.assignment_3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteFragment extends Fragment {

    List<String> mQuoteList = new ArrayList<>();
    QuoteAdapter mQuoteAdapter;
    ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("<----onCreate---->", "QuoteFragment");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("<----onCreateView---->", "QuoteFragment");
        View v = inflater.inflate(R.layout.quote_view, container, false);

        mProgress = (ProgressBar) v.findViewById(R.id.bar);
        mProgress.setVisibility(View.GONE);

        ListView listView = (ListView) v.findViewById(R.id.quote_Listview);

        mQuoteAdapter = new QuoteAdapter(mQuoteList, getActivity().getLayoutInflater());
        listView.setAdapter(mQuoteAdapter);

        FloatingActionButton fAButt = (FloatingActionButton) v.findViewById(R.id.qButton);

        fAButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("<----onItemClick---->", "QuoteFragment");
                mProgress.setVisibility(View.VISIBLE);
                try {
                    URL url = new URL("https://api.github.com/zen?access_token=0f892e365071c7e778a020e463d715b8ccb816f5");
                    new DowloadQuote().execute(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }

    private class DowloadQuote extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... params) {
            Log.i("<---doInBackground--->", "QuoteFragment");
            URL url = params[0];
            try {
                HttpURLConnection Conn = (HttpURLConnection) url.openConnection();
                try{
                    InputStream IS = new BufferedInputStream(Conn.getInputStream());
                    if (IS == null){
                        Log.i("Helvete","Något gick åt skogen!");
                    }else{
                        BufferedReader reader = new BufferedReader(new InputStreamReader(IS));
                        StringBuilder makt = new StringBuilder();
                        String quote;
                        while((quote = reader.readLine())!= null){
                            //Log.i("Test", quote);
                            return quote;
                        }
                    }
                }finally {
                    Conn.disconnect();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String quote) {
            Log.i("<----onPostExecute---->", "QuoteFragment");
            mProgress.setVisibility(View.GONE);
            mQuoteList.add(quote);
            Log.i(quote, "TEST");
            mQuoteAdapter.notifyDataSetChanged();
        }
    }
}
