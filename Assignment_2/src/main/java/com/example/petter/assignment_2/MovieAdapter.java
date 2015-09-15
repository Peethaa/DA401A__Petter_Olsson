package com.example.petter.assignment_2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Petter on 11-09-2015.
 */

public class MovieAdapter extends BaseAdapter {

    ArrayList mMovieList;
    LayoutInflater mLayoutInflater;

    public MovieAdapter(ArrayList cMovieList, LayoutInflater cLayoutInflater){

        this.mLayoutInflater = cLayoutInflater;
        this.mMovieList = cMovieList;

    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.i("<----getView---->", "MovieAdapter");

        convertView = mLayoutInflater.inflate(R.layout.movie_item, parent, false);

        Movie movie = (Movie) getItem(position);

        ImageView fanArt = (ImageView) convertView.findViewById(R.id.fanart);
        fanArt.setImageResource(movie.fanart);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(movie.title);

        TextView year = (TextView) convertView.findViewById(R.id.year);
        year.setText(movie.year);

        return convertView;
    }
}