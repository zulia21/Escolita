package com.example.escoladb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btnExibirConteudo;
    EditText edtcodTurma;
    RadioButton rdbprimeiro, rdbsegundo, rdbterceiro;


    public final static String EXTRA_MESSAGE_COD ="com.example.escoladb.COD";
    public final static String EXTRA_MESSAGE_TURNO ="com.example.escoladb.TURNO";
    public final static String EXTRA_MESSAGE_SERIE = "com.example.escoladb.SERIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinnerTurno);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinturno, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btnExibirConteudo = (Button) findViewById(R.id.btnexibirConteudo);
        edtcodTurma = (EditText) findViewById(R.id.edtcodTurma);
        rdbprimeiro = (RadioButton) findViewById(R.id.rdbprimeiro);
        rdbsegundo = (RadioButton) findViewById(R.id.rdbsegundo);
        rdbterceiro = (RadioButton) findViewById(R.id.rdbterceiro);

    }
    String opcaoSpinner;



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0)
        {

            btnExibirConteudo.setEnabled(false);
        }
        else {

            btnExibirConteudo.setEnabled(true);
        }
        opcaoSpinner = parent.getItemAtPosition(position).toString();



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void Exibir(View view)
    {
        Intent intent = new Intent(this, Exibicao.class);
        intent.putExtra(EXTRA_MESSAGE_TURNO, opcaoSpinner);





        String CodTurma = edtcodTurma.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_COD, CodTurma);
        if (TextUtils.isEmpty(CodTurma))
        {
            edtcodTurma.setError("O campo deve ser preenchido");
            return;
        }

        if (rdbprimeiro.isChecked())
        {

            intent.putExtra(EXTRA_MESSAGE_SERIE, rdbprimeiro.getHint().toString());
        }
        if (rdbsegundo.isChecked())
        {

            intent.putExtra(EXTRA_MESSAGE_SERIE, rdbsegundo.getHint().toString());
        }
        if (rdbterceiro.isChecked()) {

            intent.putExtra(EXTRA_MESSAGE_SERIE, rdbterceiro.getHint().toString());
        }
        while (!rdbterceiro.isChecked() && !rdbsegundo.isChecked() && !rdbprimeiro.isChecked())
        {
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, "Alguma das opções deve ser preenchida", duration);
            toast.show();
            return;
        }
        startActivity(intent);

    }
}

