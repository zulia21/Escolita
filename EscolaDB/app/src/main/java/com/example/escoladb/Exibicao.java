package com.example.escoladb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;


public class Exibicao extends AppCompatActivity {
    EditText respostaCod, respostaSerie, respostaTurno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibicao);

        respostaCod = (EditText) findViewById(R.id.respostaCod);
        respostaSerie = (EditText) findViewById(R.id.respostaSerie);
        respostaTurno = (EditText) findViewById(R.id.respostaTurno);

        Intent intent = getIntent();

        String Codigo =  intent.getStringExtra(MainActivity.EXTRA_MESSAGE_COD);
        respostaCod.setText(Codigo);

        String Serie = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_SERIE);
        respostaSerie.setText(Serie);

        String Turno = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_TURNO);
        respostaTurno.setText(Turno);




    }
}
