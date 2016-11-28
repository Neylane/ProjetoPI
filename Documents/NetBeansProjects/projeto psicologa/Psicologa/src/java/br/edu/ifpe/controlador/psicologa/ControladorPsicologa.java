/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;

import br.edu.ifpe.model.psicologa.Psicologa;
import br.edu.ifpe.repositorio.psicologa.RepositorioPsicologaDB;
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
public class ControladorPsicologa {

    private RepositorioGenerico<Psicologa, Integer> repositorioPsicologaDB = null;
    private Psicologa selectedPsicologa;

    public ControladorPsicologa() {
        this.repositorioPsicologaDB = new RepositorioPsicologaDB();
        this.selectedPsicologa = new Psicologa();
    }

    public String inserir(Psicologa psicologa) {

        try {
            Long.parseLong(psicologa.getCpf());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage("formulario:inCPF", new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Digite apenas números no CPF!"));
            return null;
        }

        this.repositorioPsicologaDB.inserir(psicologa);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, Psicologa(o) Cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Psicologa psicologa) {
        try {
            this.repositorioPsicologaDB.alterar(psicologa);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("A Psicologa(o)" + psicologa.getNome() + " foi "
                            + "Alterado com sucesso!"));

            return "ApresentarPsicologa.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorPsicologa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Psicologa recuperarPsicologa(int cpf) {
        return this.repositorioPsicologaDB.recuperar(cpf);
    }

    public void deletar(Psicologa psicologa) {
        this.repositorioPsicologaDB.deletar(psicologa);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A psicologa(o) " + psicologa.getNome() + " foi excluído com sucesso!!!"));

    }

    public List<Psicologa> recuperarTodosPsicologa() {
        return this.repositorioPsicologaDB.recuperarTodos();
    }

    public Psicologa getSelectedPsicologa() {
        return selectedPsicologa;
    }

    public void setSelectedPsicologa(Psicologa selectedPsicologa) {
        this.selectedPsicologa = selectedPsicologa;
    }

}
