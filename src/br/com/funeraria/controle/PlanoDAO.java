/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Plano;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            pst = conex.con.prepareStatement("INSERT INTO plano(idPlano, Tipo_Plano, Descricao_Plano) VALUES (?,?,?)");
            pst.setInt(1, plan.getIdPlano());
            pst.setString(2, plan.getTipo_plano());
            pst.setString(3, plan.getDescricao());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Plano Cadastrado com Sucesso!!!");
        } catch (SQLException ex){
             JOptionPane.showMessageDialog(null, "Plano não foi cadastrado :(" + ex);
        }
        
        conex.desconecta();
        
    }
    public void excluir(Plano plan){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("DELETE from plano where idPlano = ?");
            pst.setInt(1, plan.getIdPlano());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Dados Apagados com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!!!\n" + ex);
            
        }
       
        conex.desconecta();
        
    }
    public void editar(Plano plan){
        conex.conexao();
        PreparedStatement pst;
        try {
            pst = conex.con.prepareStatement("UPDATE plano set Tipo_plano = ?, Descricao_plano = ? where idPlano=?");
            pst.setString(1, plan.getTipo_plano());
            pst.setString(2, plan.getDescricao());
            pst.setInt(3, plan.getIdPlano());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!!!");
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!!!\n" + ex);
        }
        
        conex.desconecta();
    }
    public Plano buscarPlano(Plano pla){
        conex.conexao();
        conex.executaSQL("select * from plano where Tipo_Plano like '%" + pla.getPesquisar() + "%'");
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
