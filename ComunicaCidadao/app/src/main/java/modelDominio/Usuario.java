package modelDominio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 123L;

    private int idUsuario;
    private String nome;
    private int cpf;
    private int telefone;
    private int tipo;
    private String login;
    private String senha;

    public Usuario(int idUsuario, String nome, int cpf, int telefone, int tipo, String login, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, int cpf, int telefone, int tipo, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int tipo, String login, String senha) {
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", tipo=" + tipo +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
