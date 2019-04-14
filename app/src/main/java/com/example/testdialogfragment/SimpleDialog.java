package com.example.testdialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;

public class SimpleDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // création d'une instance alerte dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // titre du dialog
        builder.setTitle("Information")
                // message du dialog
                .setMessage("This is a Simple Dialog")
                // bouton ok du dialog
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}
