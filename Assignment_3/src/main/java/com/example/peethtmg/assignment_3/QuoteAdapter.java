package com.example.peethtmg.assignment_3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteAdapter extends BaseAdapter{

    List<String> mQuoteList;
    LayoutInflater mLayoutInflater;

    public QuoteAdapter(List<String> mQuoteList, LayoutInflater mLayoutInflater){

        this.mQuoteList = mQuoteList;
        this.mLayoutInflater = mLayoutInflater;
    }

    @Override
    public int getCount() {
        return mQuoteList.size();
    }

    @Override
    public Object getItem(int position) {
        return mQuoteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i("<----getView---->", "QuoteAdapter");
        convertView = mLayoutInflater.inflate(R.layout.quote, parent, false);

        String quote = mQuoteList.get(position);

        TextView quoteLine = (TextView) convertView.findViewById(R.id.quote_tv);
        quoteLine.setText(quote);

        return convertView;
    }
}
