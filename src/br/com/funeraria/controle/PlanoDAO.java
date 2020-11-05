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
            pst = conex.con.prepareStatement("INSERT INTO plano(Tipo_Plano, Descricao_Plano) VALUES (?,?)");
            pst.setString(1, plan.getTipo_plano());
            pst.setString(2, plan.getDescricao());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Plano Cadastrado com Sucesso!!!");
        } catch (SQLException ex){
             JOptionPane.showMessageDialog(null, "Plano não foi cadastrado :(" + ex);
        }
        
        conex.desconecta();
        
    }
    public Plano buscarPlano(Plano pla){
        conex.conexao();
        conex.executaSQL("select * from plano where Tipo_Plano like '%" + plan.getPesquisar() + "%'");
        try {
            conex.rs.first();
            pla.setIdPlano(conex.rs.getInt("idPlano"));
            pla.setTipo_plano(conex.rs.getString("Tipo_Plano"));
            pla.setDescricao(conex.rs.getString("Descricao_Plano"));
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir dados\n" +ex);
        }
        
        conex.desconecta();
        return null;
      
    }
    
}
