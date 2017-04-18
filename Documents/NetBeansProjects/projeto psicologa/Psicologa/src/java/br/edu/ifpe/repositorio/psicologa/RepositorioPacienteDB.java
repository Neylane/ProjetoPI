/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.edu.cadastro.dao.DaoManagerHiber;
import br.edu.ifpe.model.psicologa.Paciente;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPacienteDB implements RepositorioGenerico<Paciente, Integer> {

    @Override
    public void inserir(Paciente t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Paciente t) throws Exception {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Paciente recuperar(Integer chave) {
        try {
            return (Paciente) DaoManagerHiber.getInstance().recover("from Paciente where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(Paciente t) {

        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Paciente> recuperarTodos() {

        return DaoManagerHiber.getInstance().recover("from Paciente");
    }

}
