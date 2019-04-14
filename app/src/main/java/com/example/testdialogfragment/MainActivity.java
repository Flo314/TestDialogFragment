package com.example.testdialogfragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button dialogSimple;

    private Button dialogPositive, dialogNegative, btnAccept, btnRetry;
    private Dialog epicDialog;
    private TextView title, message;
    private ImageView closePopupPositiveImg,closePopupNegativeImg;

    private Button diag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogSimple = (Button) findViewById(R.id.diag1);
        dialogPositive = (Button) findViewById(R.id.diag2);
        dialogNegative = (Button) findViewById(R.id.diag3);
        diag4 = (Button) findViewById(R.id.diag4);

        epicDialog = new Dialog(this);

        // dialog positive
        dialogPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPositivePopup();
            }
        });

        // dialog negative
        dialogNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNegativePopup();
            }
        });

        //setting click event listener to Dialog 4
        diag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog_layout, null);

                TextView title = (TextView) view.findViewById(R.id.title);
                ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

                title.setText("Hello There!");

                imageButton.setImageResource(R.drawable.smile);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Never Mind!", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setView(view);
                builder.show();

            }
        });
    }

    // dialog Simple
    public void openDialog1(View view){
        SimpleDialog simpleDialog = new SimpleDialog();
        simpleDialog.show(getSupportFragmentManager(),"example simple dialog" );
    }

    // dialog positive
    private void showPositivePopup() {
        epicDialog.setContentView(R.layout.popup_positive);
        closePopupPositiveImg = (ImageView) epicDialog.findViewById(R.id.closePopupPositiveImg);
        btnAccept = (Button) epicDialog.findViewById(R.id.btnAccept);
        title = (TextView) findViewById(R.id.title);
        message = (TextView) findViewById(R.id.message);

        closePopupPositiveImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    // dialog negative
    private void showNegativePopup() {

        epicDialog.setContentView(R.layout.popup_negative);
        closePopupNegativeImg = (ImageView) epicDialog.findViewById(R.id.closePopupNegativeImg);
        btnRetry = (Button) epicDialog.findViewById(R.id.btnRetry);
        title = (TextView) findViewById(R.id.title);
        message = (TextView) findViewById(R.id.message);

        closePopupNegativeImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

}
