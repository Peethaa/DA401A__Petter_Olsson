package com.example.peethtmg.assignment_3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteAdapter extends BaseAdapter{

    LayoutInflater mLayoutInflater;

    public QuoteAdapter(LayoutInflater cLayoutInflater){

        this.mLayoutInflater = cLayoutInflater;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i("<----getView---->", "QuoteAdapter");

        convertView = mLayoutInflater.inflate(R.layout.quote, parent, false);

        Quote quote = (Quote) getItem(position);
/*
        ImageView fanArt = (ImageView) convertView.findViewById(R.id.);
        fanArt.setImageResource(movie.fanart);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(movie.title);

        TextView year = (TextView) convertView.findViewById(R.id.year);
        year.setText(movie.year);*/

        return convertView;

        //convertView =

       // return null;
    }
}
