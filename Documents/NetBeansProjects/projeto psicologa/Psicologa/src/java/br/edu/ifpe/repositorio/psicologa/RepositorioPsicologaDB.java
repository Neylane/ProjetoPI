/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.model.psicologa.Psicologa;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;



import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologaDB implements RepositorioGenerico<Psicologa, Integer> {

    public RepositorioPsicologaDB() {
    }

    @Override
    public void inserir(Psicologa t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Psicologa t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Psicologa recuperar(Integer chave) {
        try {
            return (Psicologa) DaoManagerHiber.getInstance().recover("from Psicologa where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(Psicologa t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Psicologa> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from Psicologa");
    }

}
