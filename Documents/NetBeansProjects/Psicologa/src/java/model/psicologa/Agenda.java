/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.psicologa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "Agenda")
public class Agenda {

    @Id
    private String dataConsulta;
    private String horario;
    private int codigo;

    public Agenda(String dataConsulta, String horario, int codigo) {
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.codigo = codigo;
    }

    @Deprecated
    public Agenda() {
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
