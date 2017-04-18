/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;

import br.edu.ifpe.model.psicologa.Prontuario;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import br.edu.ifpe.repositorio.psicologa.RepositorioProntuarioDB;

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
public class ControladorProntuario {

    private RepositorioGenerico<Prontuario, Integer> repositorioProntuarioDB = null;
    private Prontuario selectedProntuario;

    public ControladorProntuario() {
        this.repositorioProntuarioDB = new RepositorioProntuarioDB();
        this.selectedProntuario = new Prontuario();
    }

    public String inserir(Prontuario prontuario) {

        try {
            Long.parseLong(prontuario.getDescricao());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage("formulario:inDescricao", new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Atenção", "Digite apenas a descrição!"));
            return null;
        }

        this.repositorioProntuarioDB.inserir(prontuario);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, prontuario cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Prontuario prontuario) {
        try {
            this.repositorioProntuarioDB.alterar(prontuario);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O prontuario" + prontuario.getDescricao() + " foi "
                            + "alterado com sucesso! "));

            return "ApresentarProntuario.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Prontuario recuperarProntuario(int descricao) {
        return this.repositorioProntuarioDB.recuperar(descricao);
    }

    public void deletar(Prontuario prontuario) {
        this.repositorioProntuarioDB.deletar(prontuario);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "O prontruario " + prontuario.getDescricao() + "foi excluído com sucesso!!!"));

    }

    public List<Prontuario> recuperarTodosProntuario() {
        return this.repositorioProntuarioDB.recuperarTodos();
    }

    public Prontuario getSelectedProntuario() {
        return selectedProntuario;
    }

    public void setSelectedProntuario(Prontuario selectedProntuario) {
        this.selectedProntuario = selectedProntuario;
    }

}
