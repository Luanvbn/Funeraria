/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class UsuarioDAO {
    ConexaoBD conex =  new ConexaoBD() ;
    Usuario user = new Usuario();
    
    public void salvar(Usuario user){
        conex.conexao();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conex.con.prepareStatement("INSERT INTO usuario(senha, usuario) VALUES (?,?)");
            pst.setString(1, user.getSenha());
            pst.setString(2, user.getUsuario());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario não foi cadastrado :(" + ex);
        }
        
       
        
        conex.desconecta();
    }
    
}
