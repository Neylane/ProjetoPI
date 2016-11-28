package br.edu.ifpe.repositorio.psicologa;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kelly silva
 */
public class Repositorio {
    
    public static final int MEMO = 1;
    public static final int DB = 2;
    public static final int AGENDA = 1;
    public static final int PSICOLOGA = 2;
    public static final int PACIENTE= 3;
    
    public static RepositorioAgendaDB criarRepositorio(int tipoNegocio,int tipoPersistencia){
        
        if(tipoPersistencia==MEMO){
            if(tipoNegocio==AGENDA){
            }else if(tipoNegocio==PSICOLOGA){
          
            }
        }else if(tipoPersistencia==DB){
            if(tipoNegocio==PSICOLOGA){
               
            }else if(tipoNegocio==AGENDA){
                return new RepositorioAgendaDB();
            }
        }
        return null;
    }
    
}
