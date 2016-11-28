/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;


import br.edu.ifpe.model.psicologa.Paciente;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import br.edu.ifpe.repositorio.psicologa.RepositorioPacienteDB;



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
public class ControladorPaciente {

    private RepositorioGenerico<Paciente, Integer> repositorioPacienteDB = null;
    private Paciente selectedPaciente;

     public ControladorPaciente() {
        this.repositorioPacienteDB = new RepositorioPacienteDB();
        this.selectedPaciente = new Paciente();
    }

    public String inserir(Paciente paciente) {

        try {
            Long.parseLong(paciente.getCpf());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage("formulario:inCPF", new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Atenção", "Digite apenas números no CPF!"));
            return null;
        }

        this.repositorioPacienteDB.inserir(paciente);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, Paciente Cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Paciente paciente) {
        try {
            this.repositorioPacienteDB.alterar(paciente);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("O Paciente" +  paciente.getNome() + " foi "
                            + "Alterado com sucesso!"));

            return "ApresentarPaciente.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Paciente recuperarPaciente(int cpf) {
        return this.repositorioPacienteDB.recuperar(cpf);
    }

    public void deletar(Paciente paciente) {
        this.repositorioPacienteDB.deletar(paciente);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "O paciente " + paciente.getNome() + " foi excluído com sucesso!!!"));

    }

    public List<Paciente> recuperarTodosPaciente() {
        return this.repositorioPacienteDB.recuperarTodos();
    }

    public Paciente getSelectedPaciente() {
        return selectedPaciente;
    }

    public void setSelectedPaciente(Paciente selectedPaciente) {
        this.selectedPaciente = selectedPaciente;
    }

}
