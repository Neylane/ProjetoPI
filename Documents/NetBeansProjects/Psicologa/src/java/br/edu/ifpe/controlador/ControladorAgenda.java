package br.edu.ifpe.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.psicologa.Agenda;

/**
 *
 * @author kelly silva
 */
@ManagedBean(name = "ControladorAgenda")
@RequestScoped
public class ControladorAgenda {

    private RepositorioGenerico<Agenda, Integer> repositorioAgenda = null;
    private Agenda selectedAgenda;

    public ControladorAgenda() {
        this.selectedAgenda = new Agenda();
    }

    public String inserir(Agenda agenda) {

        this.repositorioAgenda.inserir(agenda);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns,Agenda do Paciente Cadastrada com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Agenda agenda) {
        try {
            this.repositorioAgenda.alterar(agenda);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("A agenda do Paciente" + agenda.getDataConsulta()+ " foi "
                            + "Alterado com sucesso!"));

            return "ApresentarAgenda.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Agenda recuperarAgenda(int codigo) {
        return this.repositorioAgenda.recuperar(codigo);
    }

    public void deletar(Agenda agenda) {
        this.repositorioAgenda.deletar(agenda);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A agenda do  Paciente " + agenda.getDataConsulta()+ " foi excluída com sucesso!!!"));

    }

    public List<Agenda> recuperarTodosAgenda() {
        return this.repositorioAgenda.recuperarTodos();
    }

    public Agenda getSelectedAgenda() {
        return selectedAgenda;
    }

    public void setSelectedAgenda(Agenda selectedAgenda) {
        this.selectedAgenda = selectedAgenda;
    }

}
