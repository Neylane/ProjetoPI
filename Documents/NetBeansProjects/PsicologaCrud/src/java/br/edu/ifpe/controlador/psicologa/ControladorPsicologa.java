/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;

import br.edu.ifpe.ifpe.model.PsicologaCrud;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import br.edu.ifpe.respositorio.psicologa.RepositorioPsicologaDB;
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

    private RepositorioGenerico<PsicologaCrud, Integer> repositorioPsicologaDB = null;
    private PsicologaCrud selectedPsi;

    public ControladorPsicologa() {
        this.repositorioPsicologaDB = new RepositorioPsicologaDB();
        this.selectedPsi = new PsicologaCrud();
    }

    public String inserir(PsicologaCrud psicologa) {

        try {
            Long.parseLong(psicologa.getCpf());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage
        ("formulario:inCpf", new FacesMessage(FacesMessage.SEVERITY_WARN, 
                "Atenção", "Digite apenas números no CPF!"));
            return null;
        }

        this.repositorioPsicologaDB.inserir(psicologa);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
        ("Parabéns, psicologa(o) cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(PsicologaCrud psicologa) {
        try {
            this.repositorioPsicologaDB.alterar(psicologa);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("A psicologa(o)" + psicologa.getNome() + " foi "
                            + "alterado com sucesso!"));

            return "ApresentarPsicologa.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorPsicologa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PsicologaCrud recuperarPsicologa(int cpf) {
        return this.repositorioPsicologaDB.recuperar(cpf);
    }

    public void deletar(PsicologaCrud psicologa) {
        this.repositorioPsicologaDB.deletar(psicologa);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A psicologa(o) " + psicologa.getNome() + " foi excluído com sucesso!!!"));

    }

    public List<PsicologaCrud> recuperarTodosPsicologa() {
        return this.repositorioPsicologaDB.recuperarTodos();
    }

    public PsicologaCrud getSelectedPsi() {
        return selectedPsi;
    }

    public void setSelectedPsi(PsicologaCrud selectedPsi) {
        this.selectedPsi = selectedPsi;
    }
}
