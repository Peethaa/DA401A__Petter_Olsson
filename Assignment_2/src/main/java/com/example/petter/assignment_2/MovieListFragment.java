package com.example.petter.assignment_2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Petter on 11-09-2015.
 */

public class MovieListFragment extends Fragment {

    ArrayList<Movie> mMovieList = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i("<----onCreate---->", "MovieListFragment");

        super.onCreate(savedInstanceState);

        TypedArray movies = getResources().obtainTypedArray(R.array.movies);

        for (int i = 0; i < movies.length(); i++) {
            TypedArray movieDetails = getResources().obtainTypedArray(movies.getResourceId(i, 0));
            Movie movie = new Movie(
                      movieDetails.getString(0)
                    , movieDetails.getString(1)
                    , movieDetails.getString(2)
                    , movieDetails.getResourceId(3, 0)
                    , movieDetails.getResourceId(4, 0));
            mMovieList.add(movie);
            movieDetails.recycle();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i("<----onCreateView---->", "MovieListFragment");
        View v = inflater.inflate(R.layout.movie_menu_fragment, container, false);

        GridView gridview = (GridView) v.findViewById(R.id.movie_view);

        MovieAdapter adapter = new MovieAdapter(mMovieList, getActivity().getLayoutInflater());
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.i("<----onItemClick---->", "MovieListFragment");

                FragmentManager fm = getActivity().getSupportFragmentManager();
                MovieDetailsFragment movieDetails = new MovieDetailsFragment();
                Movie movieInfo = mMovieList.get(position);

                Bundle details = new Bundle();

                details.putInt("Poster", movieInfo.poster);
                details.putString("Title", movieInfo.title);
                details.putString("Year", movieInfo.year);
                details.putString("Resume", movieInfo.plot);
                movieDetails.setArguments(details);

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.activityMain, movieDetails);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }
}