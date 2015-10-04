package com.example.petter.assignment_4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Petter on 04-10-2015.
 */
public class MarkerClickDialog extends DialogFragment implements Dialog.OnClickListener{

    public MarkerClickDialog() {

    }
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
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                break;
        }
    }


}
