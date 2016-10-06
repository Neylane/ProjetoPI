package br.edu.ifpe.fachada;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import model.psicologa.Agenda;
import model.psicologa.PsicologaModel;

/**
 *
 * @author 1860915
 */
public class Fachada {
    private static Fachada myself = null;
    
    private RepositorioGenerico<Agenda,Integer> repositorioAgenda= null;
    private RepositorioGenerico<PsicologaModel, Integer> repositorioPsicologa = null;
    
    //private Fachada(){
        //this.repositorioAgenda =SecretariaModel.criarRepositorio(SecretariaModel.AGENDA,
              //  repositorioSecretaria.DB);
       
   // }
    
    public static Fachada getInstance(){
        if(myself==null)
            myself = new Fachada();
        
        return myself;
    }
    
    
    public void inserir(Agenda agenda){
        this.repositorioAgenda.inserir(agenda);
    }
    
    public void alterar(Agenda agenda)throws Exception{
        this.repositorioAgenda.alterar(agenda);
    }
    
    public Agenda recuperarAgenda(int codigo){
        return this.repositorioAgenda.recuperar(codigo);
    }
    
    public void deletar(Agenda agenda){
        this.repositorioAgenda.deletar(agenda);
    }
    
    public List<Agenda> recuperarTodosAgenda(){
        return this.repositorioAgenda.recuperarTodos();
    }
    
    /**
     *
     * @param agenda
     */
   /**public void inserir(Agenda agenda){
       this.repositorioAgenda.inserir(agenda);
    }*/
    
    public List<PsicologaModel> recuperarTodosPsicologaModel(){
        return this.repositorioPsicologa.recuperarTodos();
    }
    
    public PsicologaModel recuperarPsicologaModel(int codigoLincenca){
        return this.repositorioPsicologa.recuperar(codigoLincenca);
    }
    
    public void alterar(PsicologaModel psicologaModel) throws Exception{
        this.repositorioPsicologa.alterar(psicologaModel);
    }
    
    public void excluir( PsicologaModel psicologaModel){
        this.repositorioPsicologa.deletar(psicologaModel);
    }
}
