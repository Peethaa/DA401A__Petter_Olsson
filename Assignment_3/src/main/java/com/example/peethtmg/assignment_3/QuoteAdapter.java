package com.example.peethtmg.assignment_3;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.zip.Inflater;

/**
 * Created by PeethTMG on 15-09-2015.
 */
public class QuoteAdapter extends BaseAdapter{


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

        //convertView =

        return convertView;
    }
}
