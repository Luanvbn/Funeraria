/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Cliente;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class ClienteDAO {
    
    ConexaoBD conex =  new ConexaoBD() ;
    Cliente cliente = new Cliente();
    
    public void salvar(Cliente cliente){
        conex.conexao();
        PreparedStatement pst;
        try {
            pst = (PreparedStatement) conex.con.prepareStatement("INSERT INTO cliente(Nome, nascimento, cpf, sexo, telefone, rua, bairro, numero, cidade, cep, idPlano) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getNascimento());
            pst.setString(3, cliente.getCpf());
            pst.setString(4, cliente.getSexo());
            pst.setInt(5, cliente.getTelefone());
            pst.setString(6, cliente.getRua());
            pst.setString(7, cliente.getBairro());
            pst.setInt(8, cliente.getNumero());
            pst.setString(9, cliente.getCidade());
            pst.setInt(10, cliente.getCep());
            pst.setInt(11, cliente.getIdPlano());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cliente não foi cadastrado :(\n" + ex);
        }
        
       
        
        conex.desconecta();
    }
    public Cliente buscaCliente(Cliente cli){
        conex.conexao();
        conex.executaSQL("select * from cliente where Nome like '%" + cli.getPesquisa() + "%'");
        try {
            conex.rs.first();
            cli.setId(conex.rs.getInt("idCliente"));
            cli.setNome(conex.rs.getString("Nome"));
            cli.setNascimento(conex.rs.getString("nascimento"));
            cli.setCpf(conex.rs.getString("cpf"));
            cli.setSexo(conex.rs.getString("sexo"));
            cli.setTelefone(conex.rs.getInt("Telefone"));
            cli.setRua(conex.rs.getString("Rua"));
            cli.setBairro(conex.rs.getString("Bairro"));
            cli.setNumero(conex.rs.getInt("numero"));
            cli.setCidade(conex.rs.getString("cidade"));
            cli.setCep(conex.rs.getInt("cep"));
            cli.setIdPlano(conex.rs.getInt("idPlano"));
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao enserir dados\n" +ex);
        }
        
        conex.desconecta();
        return null;
      
    }
        
}
    
