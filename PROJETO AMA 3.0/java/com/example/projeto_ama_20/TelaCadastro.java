package com.example.projeto_ama_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity implements View.OnClickListener  {

    ImageView imgcadastro;
    TextView lblnome, lblemailcadastro, lblsenhacadastro;
    EditText txtnome, txtemailcadastro, txtsenhacadastro, txtconfsenha;
    Button btfinalizarcad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        imgcadastro = (ImageView) findViewById(R.id.imgcadastro);
        lblnome = (TextView) findViewById(R.id.lblnome);
        lblemailcadastro = (TextView) findViewById(R.id.lblemailcadastro);
        lblsenhacadastro = (TextView) findViewById(R.id.lblsenhacadastro);

        txtnome = (EditText) findViewById(R.id.txtnome);
        txtemailcadastro = (EditText) findViewById(R.id.txtemailcadastro);
        txtsenhacadastro = (EditText) findViewById(R.id.txtsenhacadastro);
        txtconfsenha = (EditText) findViewById(R.id.txtconfsenha);

        btfinalizarcad = (Button) findViewById(R.id.btfinalizarcad);

        btfinalizarcad.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String nome = txtnome.getText().toString();
        String email = txtemailcadastro.getText().toString();
        String senha = txtsenhacadastro.getText().toString();
        String confSenha = txtconfsenha.getText().toString();
        String msg;



        if (nome.length() == 0 || email.length() < 10) {
            msg = "Atenção - Os campos Nome e E-mail devem ser preenchidos!!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            if (!senha.equals(confSenha)) {
                msg = "Atenção - As senhas não estão iguais!!!";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            } else {
                // gravar os dados
                BancoController bd = new BancoController(getBaseContext());
                String resultado;

                resultado = bd.insereDadosUsuario(nome, email, senha);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                txtnome.setText("");
                txtemailcadastro.setText("");
                txtsenhacadastro.setText("");
                txtconfsenha.setText("");
            }
        }


    }

}