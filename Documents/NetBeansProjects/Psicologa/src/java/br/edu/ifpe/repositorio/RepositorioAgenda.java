package br.edu.ifpe.repositorio;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;
import model.psicologa.Agenda;

/**
 *
 * @author kelly silva
 */
public class RepositorioAgenda implements RepositorioGenerico<Agenda, Integer> {

    private List<Agenda> listaControladorAgenda = new ArrayList<>();

    @Override
    public void inserir(Agenda t) {
        this.listaControladorAgenda.add(t);
    }

    @Override
    public void alterar(Agenda t) throws Exception {
        Agenda a = null;
        for (int i = 0; i < this.listaControladorAgenda.size(); i++) {
            a = this.listaControladorAgenda.get(i);
            if (a.getDataConsulta().equals(t.getDataConsulta())) {
                a.setHorario(t.getHorario());
                  a.setCodigo(t.getCodigo());
               
                return;
            }
        }
    }

    @Override
    public Agenda recuperar(Integer chave) {
        Agenda a = null;
        for (int i = 0; i < this.listaControladorAgenda.size(); i++) {
            a = this.listaControladorAgenda.get(i);
            if (a.getCodigo()== chave) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void deletar(Agenda t) {
        this.listaControladorAgenda.remove(t);
    }

    @Override
    public List<Agenda> recuperarTodos() {
        return this.listaControladorAgenda;
    }

    /**
     *
     * @param pacienteModel
     */
}


