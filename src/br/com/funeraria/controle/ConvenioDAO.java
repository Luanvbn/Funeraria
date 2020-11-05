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
