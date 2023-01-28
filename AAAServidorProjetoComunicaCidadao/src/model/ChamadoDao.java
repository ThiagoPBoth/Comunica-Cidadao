/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Colaborador
 */

import com.mysql.cj.protocol.Resultset;
import modelDominio.Usuario;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelDominio.Chamado;

public class ChamadoDao {
    private Connection con;

    public ChamadoDao() {
        con = Conector.getConnection();
    }
    
    
    public int inserir(Chamado chamado) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);

                String sql = "INSERT INTO chamado(fk_idUsuario, titulo, descricao, setor, statos, imagem) values (?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                //tROCAR O SPARAMETROS
                stmt.setInt(1, 1);
                stmt.setString(2, chamado.getTitulo());
                stmt.setString(3, chamado.getDescricao());
                stmt.setString(4, chamado.getSetor());
                stmt.setInt(5, chamado.getStatus());
                stmt.setBytes(6, chamado.getImagem());
                

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
    
}
