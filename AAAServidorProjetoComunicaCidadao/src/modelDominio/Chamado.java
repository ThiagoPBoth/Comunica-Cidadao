/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDominio;


import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.BitSet;

/**
 *
 * @author Colaborador
 */
public class Chamado implements Serializable{
   private static final long serialVersionUID = 123L;

    private String titulo;
    private String setor;
    private String descricao;
    private byte[] imagem;
    private int status;
    private String statusReal;

    public Chamado(String titulo, String setor, String descricao, byte[] imagem, int status) {
        this.titulo = titulo;
        this.setor = setor;
        this.descricao = descricao;
        this.imagem = imagem;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {

        if (status == 0) {
            statusReal = "Não solucionado";
        }

        return "Chamado{" +
                "titulo='" + titulo + '\'' +
                ", setor='" + setor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagem=" + imagem + '\'' +
                ", status=" + status +
                '}';
    }
}
