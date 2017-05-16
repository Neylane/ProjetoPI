package br.edu.ifpe.respositorio.psicologa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.ifpe.model.PsicologaCrud;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologaDB implements RepositorioGenerico<PsicologaCrud, Integer> {

    public RepositorioPsicologaDB() {
    }

    @Override
    public void inserir(PsicologaCrud t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(PsicologaCrud t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public PsicologaCrud recuperar(Integer chave) {
        try {
            return (PsicologaCrud) DaoManagerHiber.getInstance().recover
        ("from PsicologaCrud where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(PsicologaCrud t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<PsicologaCrud> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from PsicologaCrud");
    }

}
