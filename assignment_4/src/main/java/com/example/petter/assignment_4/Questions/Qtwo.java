package com.example.petter.assignment_4.Questions;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Petter on 18-10-2015.
 */
public class Qtwo  extends DialogFragment implements Dialog.OnClickListener {

    public Qtwo() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder qTwo = new AlertDialog.Builder(getActivity())
                .setTitle("Where can you find Alcatraz?")
                .setItems(new CharSequence[]{"A) Los Angeles", "B) San Diego", "C) San Francisco"}, this);
        return qTwo.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast toast;
        switch (which) {
            case 0:
                toast = Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case 1:
                toast = Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case 2:
                toast = Toast.makeText(getContext(), "Correct, head to the next mark!", Toast.LENGTH_LONG);
                toast.show();
                break;
        }
    }
}
