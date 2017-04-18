/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.psicologa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "Prontuario")
public class Prontuario {

    @Id
    @Column(length = 8)
    private int numProntuario;
    private String dataConsulta;
    private String horario;
    private String descricao;

    public Prontuario(int numProntuario, String dataConsulta, String horario, String descricao) {
        this.numProntuario = numProntuario;
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.descricao = descricao;

    }

    @Deprecated
    public Prontuario() {
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(int numProntuario) {
        this.numProntuario = numProntuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
