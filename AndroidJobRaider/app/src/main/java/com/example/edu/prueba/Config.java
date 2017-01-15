package com.example.edu.prueba;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

/**
 * Created by edu on 15/01/2017.
 */

public class Config  extends Activity {
    EditText Ip, passwprd, apellido, dni;
    Button ok;
    ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        Ip = (EditText) findViewById(R.id.editText5);
        ok = (Button) findViewById(R.id.ok);


        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.GONE);

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);



            }
        });


    }
}