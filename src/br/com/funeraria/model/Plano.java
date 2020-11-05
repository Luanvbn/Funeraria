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
public class Plano {

    /**
     * @return the idPlano
     */
    public int getIdPlano() {
        return idPlano;
    }

    /**
     * @param idPlano the idPlano to set
     */
    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    /**
     * @return the pesquisar
     */
    public String getPesquisar() {
        return pesquisar;
    }

    /**
     * @param pesquisar the pesquisar to set
     */
    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

    /**
     * @return the tipo_plano
     */
    public String getTipo_plano() {
        return tipo_plano;
    }

    /**
     * @param tipo_plano the tipo_plano to set
     */
    public void setTipo_plano(String tipo_plano) {
        this.tipo_plano = tipo_plano;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    /**
     * @return the preco
     */
    private int idPlano;
    private String tipo_plano;
    private String Descricao;
    private String pesquisar;
    
}
