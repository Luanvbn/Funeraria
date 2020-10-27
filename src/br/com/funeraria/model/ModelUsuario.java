/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.funeraria.model;

/**
 *
 * @author Luan
 */
public class ModelUsuario extends ModelPessoa {


    private int id_usuario;
    private ModelEndereco id_endereco_fk;
    private ModelNumero id_numero_fk;
    private String login;
    private String senha;

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_endereco_fk
     */
    public ModelEndereco getId_endereco_fk() {
        return id_endereco_fk;
    }

    /**
     * @param id_endereco_fk the id_endereco_fk to set
     */
    public void setId_endereco_fk(ModelEndereco id_endereco_fk) {
        this.id_endereco_fk = id_endereco_fk;
    }

    /**
     * @return the id_numero_fk
     */
    public ModelNumero getId_numero_fk() {
        return id_numero_fk;
    }

    /**
     * @param id_numero_fk the id_numero_fk to set
     */
    public void setId_numero_fk(ModelNumero id_numero_fk) {
        this.id_numero_fk = id_numero_fk;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
