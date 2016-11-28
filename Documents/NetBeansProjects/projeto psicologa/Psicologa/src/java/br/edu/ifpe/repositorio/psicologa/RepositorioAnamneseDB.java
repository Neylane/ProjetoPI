/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.model.psicologa.Anamnese;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioAnamneseDB implements RepositorioGenerico<Anamnese, Integer> {

    @Override
    public void inserir(Anamnese t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Anamnese t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Anamnese recuperar(Integer chave) {
        try {
            return (Anamnese) DaoManagerHiber.getInstance().recover("from Anamnese where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(Anamnese t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Anamnese> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from Anamnese");
    }

}
