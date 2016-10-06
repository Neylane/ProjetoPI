/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador;

import br.edu.ifpe.repositorio.RepositorioPacienteImplDB;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.psicologa.PacienteModel;

/**
 *
 * @author kelly silva
 */
@ManagedBean(name = "ControladorPaciente")
@RequestScoped
public class ControladorPaciente {

    private RepositorioGenerico<PacienteModel, Integer> repositorioPaciente = null;
    private PacienteModel selectedPacienteModel;

    public ControladorPaciente() {
        this.repositorioPaciente = new RepositorioPacienteImplDB();
        this.selectedPacienteModel = new PacienteModel();
    }

    public String inserir(PacienteModel pacienteModel) {

        this.repositorioPaciente.inserir(pacienteModel);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns,Paciente Cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(PacienteModel pacienteModel) {
        try {
            this.repositorioPaciente.alterar(pacienteModel);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O Paciente" + pacienteModel.getNome()+ " foi "
                            + "Alterado com sucesso!"));

            return "ApresentarPaciente.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public PacienteModel recuperarPacienteModel(int cpf) {
        return this.repositorioPaciente.recuperar(cpf);
    }

    public void deletar(PacienteModel pacienteModel) {
        this.repositorioPaciente.deletar(pacienteModel);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "O Paciente " + pacienteModel.getNome() + " foi excluído com sucesso!!!"));

    }

    public List<PacienteModel> recuperarTodosPacienteModel() {
        return this.repositorioPaciente.recuperarTodos();
    }

    public PacienteModel getSelectedPacienteModel() {
        return selectedPacienteModel;
    }

    public void setSelectedPacienteModel(PacienteModel selectedPacienteModel) {
        this.selectedPacienteModel = selectedPacienteModel;
    }

}
