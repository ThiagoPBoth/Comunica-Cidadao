package com.example.comunicacidadao;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import modelDominio.Usuario;


public class LoginActivity extends AppCompatActivity {
    EditText etLoginLogin, etLoginSenha;
    Button bLoginEntrar, bLoginCancelar;
    InformacoesApp informacoesApp;
    Usuario usuario;
    String mensagemRecebida;
    Usuario usuarioRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLoginLogin = findViewById(R.id.etLoginLogin);
        bLoginEntrar = findViewById(R.id.bLoginEntrar);
        bLoginCancelar = findViewById(R.id.bLoginCancelar);

        etLoginSenha = findViewById(R.id.etLoginSenha);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        bLoginEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etLoginLogin.getText().toString().equals("")) {

                    if (!etLoginSenha.getText().toString().equals("")) {

                        //coletando os dados
                        String login = etLoginLogin.getText().toString();
                        String senha = etLoginSenha.getText().toString();

                        usuario = new Usuario(1, login, senha);

                        //criando uma nova thread para se comunicar com o servidor
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {


                                //iniciando o protocolo para consultar no banco se existe o usuario
                                try {

                                    informacoesApp.out.writeObject("consultarUsuario");
                                    mensagemRecebida = (String) informacoesApp.in.readObject();




                                    informacoesApp.out.writeObject(usuario);
                                    //usuario = (Usuario) informacoesApp.in.readObject();
                                    usuarioRecebido = (Usuario) informacoesApp.in.readObject();
                                    //TESTAR SE O USUÁRIO nao eh nulo

                                    if (usuarioRecebido != null) {


                                        //informacoesApp.setUsuarioLogado(usuario);

                                        //codigo para esta tread agir sobre a tela
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "usuario correto:" + usuarioRecebido, Toast.LENGTH_SHORT).show();
                                                //Toast.makeText(informacoesApp, "usuario no infoapp" + informacoesApp.getUsuarioLogado(),  Toast.LENGTH_SHORT).show();
                                                Intent it = new Intent(LoginActivity.this,MenuActivity.class);
                                                startActivity(it);
                                            }
                                        });




                                    } else {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "Usuario Inválido!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }








                                } catch (IOException ioe) {

                                } catch (ClassNotFoundException classe) {

                                }
                            }
                        });
                        thread.start();





                    } else {
                        etLoginSenha.setError("Infome a senha!");
                        etLoginSenha.requestFocus();
                    }

                } else {
                    etLoginLogin.setError("Informe o Login!");
                    etLoginLogin.requestFocus();
                }

            }
        });




    }

    public void limparCampos() {
        etLoginLogin.setText("");
        etLoginSenha.setText("");
    }

}
