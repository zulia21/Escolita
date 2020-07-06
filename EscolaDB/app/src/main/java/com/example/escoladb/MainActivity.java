package com.example.escoladb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnExibirConteudo;
    EditText codAval, dataProva, mencaoA;
    public final static String EXTRA_MESSAGE_COD ="com.example.escoladb.MESSAGE";
    public final static String EXTRA_MESSAGE_VALOR ="com.example.escoladb.VALUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnExibirConteudo = (Button) findViewById(R.id.btnexibirConteudo);
        codAval = (EditText) findViewById(R.id.codAval);
        dataProva = (EditText) findViewById(R.id.dataProva);
        mencaoA = (EditText) findViewById(R.id.mencaoA);
    }


}

