package com.example.petter.assignment_4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Petter on 04-10-2015.
 */
public class MarkerClickDialog extends DialogFragment implements Dialog.OnClickListener{

    public MarkerClickDialog() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Treasure hunt!")
                .setMessage("Get to the markers, and answer the questions! \n\nAre you ready?")
                .setPositiveButton("Yes", this);
        return dialog.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                break;
        }
    }
}
