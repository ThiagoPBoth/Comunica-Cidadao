/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.protocol.Resultset;
import modelDominio.Usuario;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Thiago Both
 */
public class UsuarioDao {

    private Connection con;

    public UsuarioDao() {
        con = Conector.getConnection();
    }

    public int inserir(Usuario usuario) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);

                String sql = "insert into usuario (cpf, nome, telefone, tipo, login, senha) value (?,?,?,?,?,?)";
                stmt = con.prepareStatement(sql);
                //tROCAR O SPARAMETROS
                stmt.setInt(1, usuario.getCpf());
                stmt.setString(2, usuario.getNome());
                stmt.setInt(3, usuario.getTelefone());
                stmt.setInt(4, usuario.getTipo());
                stmt.setString(5, usuario.getLogin());
                stmt.setString(6, usuario.getSenha());

                //EXECUTAR O SCRIPT
                stmt.execute();
                //EFETIVAR A TRANSAÇÃO BEM IMPORTANTE
                con.commit();
                return -1; //DEU TDO CERTO
            } catch (SQLException e) {
                try {
                    e.printStackTrace();
                    //cancela se deu erro
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }

        } finally {

            //ENTRA AQUI INDEPENDENTE DE SEU ERRO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
    }

    //===================================
    //public Usuario consultar(Usuario usuario) {
    public Usuario consultar(Usuario usuario) {
        PreparedStatement stmt = null;
        Usuario usuarioSelecionado = null;
        try {
            try {

                String sql = "select * from usuario where login = ? and senha = ? and tipo = ?";
                stmt = con.prepareStatement(sql);
                //tROCAR O SPARAMETROS
                stmt.setString(1, usuario.getLogin());
                //transformar em hash
                stmt.setString(2, usuario.getSenha());
                stmt.setInt(3, usuario.getTipo());

                System.out.println(stmt);
                System.out.println("After : " + stmt.toString());
                //EXECUTAR O SCRIPT
                //stmt.execute();
                ResultSet res = stmt.executeQuery();
                while (res.next()) {

                    usuarioSelecionado = new Usuario(res.getInt("idUsuario"), res.getInt("cpf"), res.getString("nome"), res.getInt("telefone"), res.getInt("tipo"), res.getString("login"), res.getString("senha"));

                }

                System.out.println(usuarioSelecionado);

                return usuarioSelecionado; //DEU TDO CERTO

                //RETORNAR O USUARIO SELECIONADO
                //TROCAR A EXCEPTION DEPOIS
            } catch (SQLException e) {

                try {
                    e.printStackTrace();
                    //cancela se deu erro
                    con.rollback();
                    return null;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return null;
                }
            }

        } finally {

            //ENTRA AQUI INDEPENDENTE DE SEU ERRO
            //ENTRA AQUI INDEPENDENTE DE SEU ERRO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
//            try {
//                stmt.close();
//                con.setAutoCommit(true);
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println(e.getErrorCode()+"-" + e.getMessage());
//                return null;
//            }
        }
    }

}
