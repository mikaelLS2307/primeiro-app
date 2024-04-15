package com.example.projeto_ama_20;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Principal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imgAMA;
    TextView lblLogin, lblsenha;
    EditText txtEmail, txtSenha;
    Button btlogin,btcad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAMA = (ImageView)  findViewById(R.id.imgAMA);
        lblLogin =(TextView) findViewById(R.id.lblLogin);
        txtEmail =(EditText) findViewById(R.id.txtEmail);
        lblsenha =(TextView) findViewById(R.id.lblsenha);
        txtSenha =(EditText) findViewById(R.id.txtSenha);
        btlogin =(Button) findViewById(R.id.btlogin);
        btcad = (Button) findViewById(R.id.btcad);

        btlogin.setOnClickListener(this);
        btcad.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btlogin) {
            //Verificando se o usuario esta cadastro no banco de dado
            String email = txtEmail.getText().toString();
            String senha = txtSenha.getText().toString();

            BancoController bd = new BancoController(getBaseContext());

            Cursor dados = bd.carregaDadosPeloLogin(email, senha) ;
            //se encontrou o usuario / senha
            if(dados.moveToFirst()){
                // ir para a activity menu
                int codigo = dados.getInt(0);
                String nome = dados.getString(1);
                Intent intencao = new Intent(this, tela_principal.class);
                Bundle parametros = new Bundle();
                parametros.putString("nome", nome);
                parametros.putString("email",email);
                parametros.putString("senha",senha);
                parametros.putInt("codigo", codigo);
                String msg= "Login efetuado com sucesso! Bem-Vindo " + nome +"!!";
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
                intencao.putExtras(parametros);
                startActivity(intencao);
            }else{
                String msg= "Usuario ou senha digitado(a) inválido(a)";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        }if (view.getId()==R.id.btcad){
            Intent intencao2 = new Intent(this, TelaCadastro.class);
            startActivity(intencao2);
         }
        txtEmail.setText("");
        txtSenha.setText("");
    }
}

