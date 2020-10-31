/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Plano;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class PlanoDAO {
    
    ConexaoBD conex = new ConexaoBD();
    Plano plan = new Plano();
    
    public void Salvar(Plano plan) throws SQLException{
        conex.conexao();
        PreparedStatement pst;
        try{
            pst = conex.con.prepareStatement("INSERT INTO plano(Tipo_Plano, Descricao_Plano, preco) VALUES (?,?,?)");
            pst.setString(1, plan.getTipo_plano());
            pst.setString(2, plan.getDescricao());
            pst.setDouble(3, plan.getPreco());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Plano Cadastrado com Sucesso!!!");
        } catch (SQLException ex){
             JOptionPane.showMessageDialog(null, "Plano não foi cadastrado :(" + ex);
        }
        
        conex.desconecta();
        
    }
    
}
