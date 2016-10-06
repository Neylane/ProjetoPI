/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.List;
import model.psicologa.PsicologaModel;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologaImplDB implements RepositorioGenerico<PsicologaModel, Integer>{
      @Override
    public void inserir(PsicologaModel t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(PsicologaModel t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public PsicologaModel recuperar(Integer chave) {
        try {
            return (PsicologaModel) DaoManagerHiber.getInstance().recover("from PsicologaModel where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(PsicologaModel t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<PsicologaModel> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from PsicologaModel");
    }

  
}


