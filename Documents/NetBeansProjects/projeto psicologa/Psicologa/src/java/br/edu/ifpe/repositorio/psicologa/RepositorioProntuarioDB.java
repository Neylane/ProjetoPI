/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.model.psicologa.Prontuario;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioProntuarioDB implements RepositorioGenerico<Prontuario, Integer> {

    @Override
    public void inserir(Prontuario t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Prontuario t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Prontuario recuperar(Integer chave) {
        try {
            return (Prontuario) DaoManagerHiber.getInstance().recover("from Prontuario where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(Prontuario t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Prontuario> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from Prontuario");
    }

}
