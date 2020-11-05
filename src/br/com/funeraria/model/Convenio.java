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
public class Convenio {

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
     * @return the idmedico
     */
    public int getIdmedico() {
        return idmedico;
    }

    /**
     * @param idmedico the idmedico to set
     */
    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the CRM
     */
    public int getCRM() {
        return CRM;
    }

    /**
     * @param CRM the CRM to set
     */
    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

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
    
    private int idmedico;
    private String nome;
    private int CRM;
    private String especialidade;
    private int idPlano;
    private String pesquisar;
}
