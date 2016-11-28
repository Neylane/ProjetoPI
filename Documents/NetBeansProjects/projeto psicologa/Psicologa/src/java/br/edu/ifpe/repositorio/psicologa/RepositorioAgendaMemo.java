/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.model.psicologa.Agenda;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioAgendaMemo implements RepositorioGenerico<Agenda, Integer> {

    private List<Agenda> ControladorAgenda = new ArrayList<>();

    @Override
    public void inserir(Agenda t) {
        this.ControladorAgenda.add(t);
    }

    @Override
    public void alterar(Agenda t) throws Exception {
        Agenda a = null;
        for (int i = 0; i < this.ControladorAgenda.size(); i++) {
            a = this.ControladorAgenda.get(i);
            if (a.getDataConsulta().equals(t.getDataConsulta())) {
                a.setHorario(t.getHorario());
                a.setDescricao(t.getDescricao());
                a.setCodigo(t.getCodigo());
                return;

            }
        }
    }

    @Override
    public Agenda recuperar(Integer chave) {
        Agenda a = null;
        for (int i = 0; i < this.ControladorAgenda.size(); i++) {
            a = this.ControladorAgenda.get(i);
            if (a.getCodigo() == chave) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void deletar(Agenda t) {
        this.ControladorAgenda.remove(t);
    }

    @Override
    public List<Agenda> recuperarTodos() {
        return this.ControladorAgenda;
    }

    /**
     *
     * @param agenda
     */
}
