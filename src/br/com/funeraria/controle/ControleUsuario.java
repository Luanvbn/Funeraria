/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.controle;

import br.com.funeraria.model.ModelUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.Enum;

/**
 *
 * @author Luan
 */
public class ControleUsuario {
    
    ConexaoBD conex = new ConexaoBD();
    ModelUsuario mod =  new ModelUsuario();
    
    public void salvar(ModelUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO cadusuario(nome, login, senha, cpf, endereco_fk, Numero_fk, sexo, idade) VALUES (?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getLogin());
            pst.setString(3, mod.getSenha());
            pst.setInt(4, mod.getCpf());
            pst.setInt(5, mod.getId_endereco_fk().getId_endereco());
            pst.setInt(6, mod.getId_numero_fk().getId_numero());
            pst.setString(7, mod.getSexo());
            pst.setString(8, mod.getNascimento());
            PreparedStatement ptt  = conex.con.prepareStatement("INSERT INTO endereco(Bairro, CEP, cidade, complemento, numero, Rua) VALUES (?,?,?,?,?,?)");
            ptt.setString(1, mod.getBairro());
            ptt.setInt(2, mod.getCEP());
            ptt.setString(3, mod.getCidade());
            ptt.setString(4, mod.getComplemento());
            ptt.setInt(5, mod.getNumero());
            ptt.setString(6, mod.getRua());
            PreparedStatement pto  = conex.con.prepareStatement("INSERT INTO numero(NumeroUM) VALUES (?)");
            pto.setInt(1, mod.getTelefone());
            pst.execute();
            ptt.execute();
            pto.execute();
            pst.close();
            ptt.close();
            ptt.close();
            JOptionPane.showMessageDialog(null,"Usuario Cadastrado com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuario não cadastrado!!! ERRO: \n" +  ex);
        }
        conex.desconecta();
    }
    
}
