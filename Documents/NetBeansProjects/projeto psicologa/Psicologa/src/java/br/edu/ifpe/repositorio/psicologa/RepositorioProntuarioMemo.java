/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.model.psicologa.Prontuario;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioProntuarioMemo implements RepositorioGenerico<Prontuario, Integer> {

    private List<Prontuario> ControladorProntuario = new ArrayList<>();

    @Override
    public void inserir(Prontuario t) {
        this.ControladorProntuario.add(t);
    }

    @Override
    public void alterar(Prontuario t) throws Exception {
        Prontuario pt = null;
        for (int i = 0; i < this.ControladorProntuario.size(); i++) {
            pt = this.ControladorProntuario.get(i);
            if (pt.getDataConsulta().equals(t.getDataConsulta())) {
                pt.setHorario(t.getHorario());
                pt.setDescricao(t.getDescricao());
                pt.setNumProntuario(t.getNumProntuario());
                return;

            }
        }
    }

    @Override
    public Prontuario recuperar(Integer chave) {
        Prontuario pt = null;
        for (int i = 0; i < this.ControladorProntuario.size(); i++) {
            pt = this.ControladorProntuario.get(i);
            if (pt.getNumProntuario() == chave) {
                return pt;
            }
        }
        return null;
    }

    @Override
    public void deletar(Prontuario t) {
        this.ControladorProntuario.remove(t);
    }

    @Override
    public List<Prontuario> recuperarTodos() {
        return this.ControladorProntuario;
    }

    /**
     *
     * @param prontuario
     */
}
