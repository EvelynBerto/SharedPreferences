package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String ARQUIVO_PREFERENCE = "Arquivo de preferencia";
    //declarei o nome do arquivo a ser criado
    private EditText edit_nome;
    private TextView tv_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_nome = findViewById(R.id.edit_nome);
        tv_nome = findViewById(R.id.tv_nome);

        recuperaDados();
        //ele salva a última informação inserida
    }
    public void salvarDados(View view){
        /*método para salvarDados por meio de uma classe do java chamada SharedPreferences
        onde essa classe pode ser usada para salvar poucos dados
        parametro que tenho que passar por se tratar de um botão referenciado no onClick*/
        String nome = edit_nome.getText().toString();
        if (!nome.isEmpty()){
            Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
            //criei um toast para indicar se o dado está correto
            SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCE, 0);
            //mode:0 sig que apenas nosso app poderá gravar e ler esse arquivo
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("meu_nome", nome);
            editor.apply();
        }else
        edit_nome.setError("Informe seu nome");
    }

    private void recuperaDados(){
        /*como vou chamar esse método na main, pois nao tenho
        um evento de clique nele, nao vou passar parametros da view*/
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCE, 0);
        String nomeRecuperado = sharedPreferences.getString("meu_nome", "");
        tv_nome.setText(nomeRecuperado);

    }
}