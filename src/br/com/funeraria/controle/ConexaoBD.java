
package br.com.funeraria.controle;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.driver";  // driver da bd
    private String caminho = "jdbc:mysql://localhost:3306/funeraria"; // Host da BD
    private String usuario = "root"; // usuario bd
    private String senha = "7768"; // senha bd
    public Connection con;
    
    public void conexao(){ // metodo que conecta o sistema ao banco de dados!!!!
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho , usuario, senha);
            JOptionPane.showMessageDialog(null, "Bem-Vindo ao Sistema da Funeraria");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de Dados:\n" + ex.getMessage());
     
        }
    }
    public void desconecta(){ // metodo responsavel por desconectar o Banco de dados ao fechar o app!!
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "BD Desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao com BD: \n" +  ex.getMessage());
        }
    }
        
    }
    
    
    
        
    

