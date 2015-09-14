package com.example.petter.assignment_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Petter on 13-09-2015.
 */

public class MovieDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("<----onCreateView---->", "MovieDetailsFragment");

        View v = inflater.inflate(R.layout.movie_details_fragment,container,false);
        Bundle details = getArguments();

        ImageView iV = (ImageView) v.findViewById(R.id.poster);
        iV.setImageResource(details.getInt("Poster"));

        TextView tV1 = (TextView) v.findViewById(R.id.title);
        tV1.setText(details.getString("Title"));

        TextView tV2 = (TextView) v.findViewById(R.id.year);
        tV2.setText(details.getString("Year"));

        TextView tV3 = (TextView) v.findViewById(R.id.overview);
        tV3.setText(details.getString("Resume"));

        return v;
    }
}
