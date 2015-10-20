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
public class Qfour extends DialogFragment implements Dialog.OnClickListener {

    public Qfour() {

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder qFour = new AlertDialog.Builder(getActivity())
                .setTitle("Computerterm: what does ROM stand for?")
                .setItems(new CharSequence[]{"A) Read Only Memory", "B) Read Once Memory", "D) Read Once Module"}, this);
        return qFour.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Toast toast;
        switch (which) {
            case 0:
                toast = Toast.makeText(getContext(), "Correct, head to the next mark!", Toast.LENGTH_LONG);
                toast.show();
                break;
            case 1:
                toast = Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case 2:
                toast = Toast.makeText(getContext(), "Wrong", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}
