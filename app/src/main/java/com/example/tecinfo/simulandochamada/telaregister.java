package com.example.tecinfo.simulandochamada;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class telaregister extends AppCompatActivity {

    SharedPreferences meusDados;
    public static final String mypreference = "call";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telaregister);

        final EditText email1 = findViewById(R.id.email1);
        final EditText senha1 = findViewById(R.id.senha1);
        final EditText senha2 = findViewById(R.id.senha2);
        Button cadastrar = findViewById(R.id.btncadastrar1);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(senha1.getText().toString().equals(senha2.getText().toString())){
                    SharedPreferences.Editor editor = meusDados.edit();
                    editor.putString("email",email1.getText().toString());
                    editor.putString("senha",senha1.getText().toString());

                    editor.commit();

                    Toast.makeText(getApplicationContext(),
                        "Dados salvos cin sucesso !", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(telaregister.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "As senhas não conferem", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
