/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.model.psicologa.Agenda;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioAgendaDB implements RepositorioGenerico<Agenda, Integer> {

    @Override
    public void inserir(Agenda t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Agenda t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Agenda recuperar(Integer chave) {
        try {
            return (Agenda) DaoManagerHiber.getInstance().recover("from Agenda where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(Agenda t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Agenda> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from Agenda");
    }

}
