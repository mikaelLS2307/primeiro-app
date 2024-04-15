package com.example.projeto_ama_20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
   private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDadosUsuario(String txtNome, String txtEmail, String txtSenha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("email", txtEmail);
        valores.put("senha", txtSenha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosPeloCodigo(int id) {
        Cursor cursor;
        String[] campos = { "codigo", "nome", "email" };
        String where = "codigo=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("contatos", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }


    public Cursor carregaDadosPeloLogin(String email, String senha) {
        Cursor cursor;
        String[] campos = { "codigo", "nome", "email","senha" };
        String filtro = "email= '" + email + "' and senha = '" + senha+ "'";

        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, filtro, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }
    public String alteraDados(int id, String nome, String email){

        String msg = "Dados alterados com sucesso!!!" ;

        db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues() ;
        valores.put("nome" , nome ) ;
        valores.put("email", email) ;

        String condicao = "codigo = " + id;

        int linha ;
        linha = db.update("contatos", valores, condicao, null) ;

        if (linha < 1){
            msg = "Erro ao alterar os dados" ;
        }

        db.close();
        return msg;
    }

    public String alteraSenha(int _id, String _nome, String _email, String _senha){

        String msg = "Senha alterada com sucesso!!!" ;

        db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues() ;
        valores.put("nome" , _nome ) ;
        valores.put("email", _email) ;
        valores.put("senha", _senha );

        String condicao = "codigo = " + _id;

        int linha ;
        linha = db.update("usuarios", valores, condicao, null) ;

        if (linha < 1){
            msg = "Erro ao alterar a senha" ;
        }
        db.close();
        return msg;
    }

    public String alterarSenha(int id, String nome, String email, String senha){
        String msg = "Senha alterada com sucesso!!!" ;

        db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues() ;
        valores.put("nome",nome);
        valores.put("email", email);
        valores.put("senha" , senha ) ;
        String condicao = "codigo = " + id;

        int linha ;
        linha = db.update("usuarios", valores, condicao, null) ;

        if (linha < 1){
            msg = "Erro ao alterar a senha" ;
        }
        db.close();
        return msg;
    }
    public String excluirDados(int id){
        String msg = "Registro Excluído" ;

        db = banco.getReadableDatabase();

        String condicao = "codigo = " + id ;

        int linhas ;
        linhas = db.delete("contatos", condicao, null) ;

        if ( linhas < 1) {
            msg = "Erro ao Excluir" ;
        }

        db.close();
        return msg;
    }

}

