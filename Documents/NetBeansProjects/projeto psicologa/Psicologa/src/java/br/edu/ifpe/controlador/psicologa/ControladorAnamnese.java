/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controlador.psicologa;


import br.edu.ifpe.model.psicologa.Anamnese;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import br.edu.ifpe.repositorio.psicologa.RepositorioAnamneseDB;
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
public class ControladorAnamnese{

    private RepositorioGenerico<Anamnese, Integer> repositorioAnamneseDB = null;
    private Anamnese selectedAnamnese;

    public ControladorAnamnese() {
        this.repositorioAnamneseDB = new RepositorioAnamneseDB();
        this.selectedAnamnese = new Anamnese();
    }

    public String inserir(Anamnese anamnese) {

        try {
            Long.parseLong(anamnese.getNome());
        } catch (NumberFormatException ne) {
            FacesContext.getCurrentInstance().addMessage("formulario:inNome",
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Digite apenas o nome"));
            return null;
        }

        this.repositorioAnamneseDB.inserir(anamnese);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Parabéns, Anamnese do paciente Cadastrado com sucesso"));

        return "index.xhtml";
    }

    public String alterar(Anamnese anamnese) {
        try {
            this.repositorioAnamneseDB.alterar(anamnese);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("A anamnese do paciente" + anamnese.getNome() + " foi "
                            + "Alterada(o) com sucesso!"));

            return "ApresentarAnamnese.xhtml";

        } catch (Exception ex) {
            Logger.getLogger(ControladorAnamnese.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Anamnese recuperarAnamnese(int nome) {
        return this.repositorioAnamneseDB.recuperar(nome);
    }

    public void deletar(Anamnese anamnese) {
        this.repositorioAnamneseDB.deletar(anamnese);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                "A anamnese do paciente " + anamnese.getNome() + " foi excluída(o) com sucesso!!!"));

    }

    public List<Anamnese> recuperarTodosAnamnese() {
        return this.repositorioAnamneseDB.recuperarTodos();
    }

    public Anamnese getSelectedAnamnese() {
        return selectedAnamnese;
    }

    public void setSelectedAnamnese(Anamnese selectedAnamnese) {
        this.selectedAnamnese= selectedAnamnese;
    }

}
