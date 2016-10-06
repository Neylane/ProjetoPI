package br.edu.ifpe.repositorio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import edu.cadastro.teste.PsicologaManagerHiber;
import java.util.List;
import model.psicologa.PacienteModel;

/**
 *
 * @author kelly silva
 */
public class RepositorioPacienteImplDB implements RepositorioGenerico<PacienteModel, Integer> {

    public RepositorioPacienteImplDB() {

    }

    @Override
    public void inserir(PacienteModel t) {
        PsicologaManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(PacienteModel t) throws Exception {
        PsicologaManagerHiber.getInstance().update(t);
    }

    @Override
    public PacienteModel recuperar(Integer chave) {
        try {
            return (PacienteModel) PsicologaManagerHiber.getInstance().recover("from PacienteModel where id = " + chave).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    public void deletar(PacienteModel t) {

        PsicologaManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<PacienteModel> recuperarTodos() {

        return PsicologaManagerHiber.getInstance().recover("from PacienteModel");
    }

}
