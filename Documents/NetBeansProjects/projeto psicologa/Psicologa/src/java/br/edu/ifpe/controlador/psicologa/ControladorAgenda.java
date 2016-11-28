/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;

import br.edu.ifpe.model.psicologa.Agenda;

import br.edu.ifpe.repositorio.psicologa.RepositorioAgendaDB;

import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author kelly silva
 */
@ManagedBean
@RequestScoped
public class ControladorAgenda {

    private RepositorioGenerico<Agenda, Integer> repositorioAgendaDB = null;
    private Agenda selectedAgenda;

    public ControladorAgenda() {
        this.repositorioAgendaDB = new RepositorioAgendaDB();
        this.selectedAgenda = new Agenda();
    }

    public String inserir(Agenda agenda) {

        try {
            Long.parseLong(agenda.getDataConsulta());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage("formulario:inDataConsulta",
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Digite apenas a data da consulta"));
            return null;
        }

        this.repositorioAgendaDB.inserir(agenda);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, Agenda da Psicologa(o) Cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Agenda agenda) {
        try {
            this.repositorioAgendaDB.alterar(agenda);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("A agenda da psicologa(o)" + agenda.getDataConsulta() + " foi "
                            + "Alterada(o) com sucesso!"));

            return "ApresentarAgenda.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Agenda recuperarAgenda(int dataConsulta) {
        return this.repositorioAgendaDB.recuperar(dataConsulta);
    }

    public void deletar(Agenda agenda) {
        this.repositorioAgendaDB.deletar(agenda);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A agenda da psicologa(o) " + agenda.getCodigo() + " foi excluída(o) com sucesso!!!"));

    }

    public List<Agenda> recuperarTodosAgenda() {
        return this.repositorioAgendaDB.recuperarTodos();
    }

    public Agenda getSelectedAgenda() {
        return selectedAgenda;
    }

    public void setSelectedAgenda(Agenda selectedAgenda) {
        this.selectedAgenda = selectedAgenda;
    }

}
