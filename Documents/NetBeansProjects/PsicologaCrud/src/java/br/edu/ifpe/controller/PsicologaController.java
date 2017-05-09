/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.dao.InterfacePsicologa;
import br.edu.ifpe.dao.PsicologaDao;
import br.edu.ifpe.ifpe.model.PsicologaCrud;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


/**
 *
 * @author kelly silva
 */
@ManagedBean
@SessionScoped
public class PsicologaController {
     private PsicologaCrud psicologaCrud;
     private PsicologaCrud  listaPsicologa;

    public PsicologaCrud getPsicologaCrud() {
        return psicologaCrud;
    }

    public void setPsicologaCrud(PsicologaCrud psicologaCrud) {
        this.psicologaCrud = psicologaCrud;
    }

    public PsicologaCrud getListaPsicologa() {
            List<PsicologaCrud> lista = new PsicologaDao.list() {};
            listaPsicologa  = new PsicologaCrud(lista);
            // lista a psicologa e chama a classe PsicologaDao e classe PsicologaCrud.
       return listaPsicologa;
       
       
    }
 
     public  void  prepararAdicionarPsicologa(ActionEvent actionEvent ){
         psicologaCrud = new PsicologaCrud();
     }
     
     
     //public  void  prepararAterarPsicologa(ActionEvent actionEvent ){
       // psicologaCrud = (PsicologaCrud)(listaPsicologa.getRowData());
     //}
     public void adicionar(ActionEvent actionEvent) {
//O ActionEvent é o parametro que é recebido no metodo actionPerformed. 
//Ele carrega a informação do evento que ocorreu 
//Ele espera algum actionPerformed para executar
         InterfacePsicologa dao = new PsicologaDao();
         dao.salvar(psicologaCrud);
         // adicionar e chama a interfacePsicologa e a classe PsicologaDao.
     }
      public void alterar(ActionEvent actionEvent) {
         InterfacePsicologa dao = new PsicologaDao();
         dao.atualizar(psicologaCrud);
         // alterar e chama a interfacePsicologa e a classe PsicologaDao.
     }
      public String excluir(ActionEvent actionEvent){
          //PsicologaCrud psicologaCrud = (PsicologaCrud)(listaPsicologa.getRowData());
       InterfacePsicologa dao = new PsicologaDao();
         dao.remover(psicologaCrud);
         // exclui e chama a interfacePsicologa e a classe PsicologaDao.
          return "index" ;      
      }
     
}
