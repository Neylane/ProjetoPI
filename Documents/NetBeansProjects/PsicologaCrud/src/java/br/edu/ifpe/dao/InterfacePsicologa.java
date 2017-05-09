/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.ifpe.model.PsicologaCrud;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public interface InterfacePsicologa {
    
    public PsicologaCrud getPsicologaCrud(Long in);
    public void  salvar  (PsicologaCrud psicologaCrud);
    public void  remover  (PsicologaCrud psicologaCrud);
    public void  atualizar  (PsicologaCrud psicologaCrud);
    
    public List<PsicologaCrud>list();
}
