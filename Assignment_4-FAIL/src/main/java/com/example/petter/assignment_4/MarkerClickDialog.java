package com.example.petter.assignment_4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by PeethTMG on 22-09-2015.
 */
public class MarkerClickDialog extends DialogFragment implements Dialog.OnClickListener {


    public MarkerClickDialog() {

    }
    //Dialog från klick på kartan.
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Cafe")
                .setMessage("This Cafe is the best Cafe!")
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel", this);

        return dialog.create();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
    }
}
