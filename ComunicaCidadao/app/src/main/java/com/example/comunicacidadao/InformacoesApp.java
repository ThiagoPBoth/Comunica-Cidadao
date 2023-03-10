package com.example.comunicacidadao;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import modelDominio.Usuario;

public class InformacoesApp extends Application {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    private Usuario usuarioLogado;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

}


