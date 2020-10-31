/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.Cliente;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
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
            pst = (PreparedStatement) conex.con.prepareStatement("INSERT INTO usuario(Nome, nascimento, cpf, sexo, telefone, rua, bairro, numero, cidade, cep, idPlano) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
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
    
}
    
