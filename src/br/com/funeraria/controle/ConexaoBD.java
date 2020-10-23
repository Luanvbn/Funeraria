
package br.com.funeraria.controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.driver";
    private String caminho = "jdbc:mysql://localhost:3306/funeraria";
    private String usuario = "root";
    private String senha = "7768";
    public Connection con;
    
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho , usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de Dados:\n" + ex.getMessage());
     
        }
    }
    public void desconecta(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com BD: \n" +  ex.getMessage());
        }
    }
        
    }
    
    
    
        
    

