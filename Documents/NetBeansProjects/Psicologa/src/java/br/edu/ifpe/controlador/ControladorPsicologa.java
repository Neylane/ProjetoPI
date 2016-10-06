/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.psicologa.PsicologaModel;

/**
 *
 * @author kelly silva
 */
@ManagedBean(name = "ControladorPsicologa")
@RequestScoped
public class ControladorPsicologa {

    private RepositorioGenerico<PsicologaModel, Integer> repositorioPsicologa = null;
    private PsicologaModel selectedPsicologaModel;

    public ControladorPsicologa() {
         // this.repositorioPsicologa = new RepositorioControladorPsicologaImplDB();
        this.selectedPsicologaModel = new PsicologaModel();
    }

    public String inserir(PsicologaModel psicologaModel) {

        this.repositorioPsicologa.inserir(psicologaModel);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns,Psicologa Cadastrada com sucesso"));

        return "index.xhtml";
    }

    public String alterar(PsicologaModel psicologaModel) {
        try {
            this.repositorioPsicologa.alterar(psicologaModel);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O Psicologa" + psicologaModel.getNome() + " foi "
                            + "Alterado com sucesso!"));

            return "ApresentarPsicologa.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorPsicologa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PsicologaModel recuperarPsicologaModel(int cpf) {
        return this.repositorioPsicologa.recuperar(cpf);
    }

    public void deletar(PsicologaModel psicologaModel) {
        this.repositorioPsicologa.deletar(psicologaModel);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A Psicologa " + psicologaModel.getNome() + " foi excluído com sucesso!!!"));

    }

    public List<PsicologaModel> recuperarTodosPsicologaModel() {
        return this.repositorioPsicologa.recuperarTodos();
    }

    public PsicologaModel getSelectedPsicologaModel() {
        return selectedPsicologaModel;
    }

    public void setSelectedPsicologaModel(PsicologaModel selectedPsicologaModel) {
        this.selectedPsicologaModel = selectedPsicologaModel;
    }

}
