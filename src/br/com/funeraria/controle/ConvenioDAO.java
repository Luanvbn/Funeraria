/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Convenio;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class ConvenioDAO {
    ConexaoBD conex =  new ConexaoBD() ;
    Convenio conv = new Convenio();
    
    public void salvar(Convenio conv){
        conex.conexao();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conex.con.prepareStatement("INSERT INTO convenio(nome, CRM, especialidade, idPlano) VALUES (?,?,?,?)");
            pst.setString(1, conv.getNome());
            pst.setInt(2, conv.getCRM());
            pst.setString(3, conv.getEspecialidade());
            pst.setInt(4, conv.getIdPlano());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Doutor Cadastrado com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Doutor não foi cadastrado :(" + ex);
        }
        
       
        
        conex.desconecta();
    }
     public void excluir(Convenio conv){
        conex.conexao();
        try {
            PreparedStatement pst = (PreparedStatement) conex.con.prepareStatement("DELETE from convenio where idmedico = ?");
            pst.setInt(1, conv.getIdmedico());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Medico Excluido com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não foi excluido :(\n" + ex);
        }
        conex.desconecta();
    }
    
    public void editar(Convenio conv){
        conex.conexao();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conex.con.prepareStatement("UPDATE convenio set nome=?, CRM=?, especialidade=?, idPlano=? where idmedico=?");
            pst.setString(1, conv.getNome());
            pst.setInt(2, conv.getCRM());
            pst.setString(3, conv.getEspecialidade());
            pst.setInt(4, conv.getIdPlano());
            pst.setInt(5, conv.getIdmedico());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Doutor Alterado com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Doutor não foi Alterado :(" + ex);
        }
        
        conex.desconecta();
    }
    public Convenio buscaConvenio(Convenio conv){
        conex.conexao();
        conex.executaSQL("select * from convenio where nome like '%" + conv.getPesquisar() + "%'");
        try {
            conex.rs.first();
            conv.setIdmedico(conex.rs.getInt("idmedico"));
            conv.setNome(conex.rs.getString("nome"));
            conv.setCRM(conex.rs.getInt("CRM"));
            conv.setEspecialidade(conex.rs.getString("Especialidade"));
            conv.setIdPlano(conex.rs.getInt("idPlano"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados" + ex);
        }
        conex.desconecta();
        return null;
    }
    
}
