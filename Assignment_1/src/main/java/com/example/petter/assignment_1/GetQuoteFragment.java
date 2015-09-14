package com.example.petter.assignment_1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Petter on 11-09-2015.
 */

public class GetQuoteFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.i("<----onCreate---->", "GetQuoteFragment");

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i("<----onCreateView---->", "GetQuoteFragment");

        View v = inflater.inflate(R.layout.get_quote, container, false);

        Button qButton = (Button) v.findViewById(R.id.qButton);
        qButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentManager fM = getFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();

                fT.replace(R.id.activityMain, new ViewQuoteFragment());
                fT.addToBackStack(null);
                fT.commit();
            }
        });
        return v;
    }
}
