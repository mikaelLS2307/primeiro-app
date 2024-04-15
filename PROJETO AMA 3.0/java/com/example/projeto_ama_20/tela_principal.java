package com.example.projeto_ama_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;


public class tela_principal extends AppCompatActivity implements View.OnClickListener {

    private SQLiteDatabase db;
    private CriaBanco banco;
    View bordas;
    Button btalongamento, btdicasali, btIMC, btiniciar;
    DatePicker data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        btalongamento = (Button) findViewById(R.id.btalongamento);
        btiniciar = (Button) findViewById(R.id.btiniciar);
        btdicasali = (Button) findViewById(R.id.btdicasali);
        data = (DatePicker) findViewById(R.id.data);
        btIMC = (Button) findViewById(R.id.btIMC);

        btIMC.setOnClickListener(this);
        btdicasali.setOnClickListener(this);
        btalongamento.setOnClickListener(this);
        btiniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btdicasali) {
            Intent intencao = new Intent(this, tela_dicas_ali.class);
            startActivity(intencao);
        } else if (view.getId() == R.id.btalongamento) {
            Intent intencao3 = new Intent(this, tela_alongamento.class);
            startActivity(intencao3);
        } else if (view.getId() == R.id.btiniciar) {
            Intent intencao2 = new Intent(this, tela_treino.class);
            startActivity(intencao2);
        } else if (view.getId() == R.id.btIMC) {
            Intent intencao3 = new Intent(this, calculadora_IMC.class);
            startActivity(intencao3);
        }
    }



    }


