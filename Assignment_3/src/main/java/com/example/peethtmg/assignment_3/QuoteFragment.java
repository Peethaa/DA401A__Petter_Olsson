package com.example.peethtmg.assignment_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteFragment extends android.support.v4.app.Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("<----onCreate---->", "QuoteFragment");
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("<----onCreateView---->", "QuoteFragment");
        return super.onCreateView(inflater, container, savedInstanceState);


    }


}
