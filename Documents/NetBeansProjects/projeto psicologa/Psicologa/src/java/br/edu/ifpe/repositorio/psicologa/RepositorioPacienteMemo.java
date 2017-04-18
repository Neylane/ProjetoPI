/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.model.psicologa.Paciente;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPacienteMemo implements RepositorioGenerico<Paciente, Integer> {

    private List<Paciente> ControladorPaciente = new ArrayList<>();

    @Override
    public void inserir(Paciente t) {
        this.ControladorPaciente.add(t);
    }

    @Override
    public void alterar(Paciente t) throws Exception {
        Paciente p = null;
        for (int i = 0; i < this.ControladorPaciente.size(); i++) {
            p = this.ControladorPaciente.get(i);
            if (p.getNome().equals(t.getNome())) {
                p.setMatricula(t.getMatricula());
                p.setEndereco(t.getEndereco());
                p.setIdade(t.getIdade());
                p.setGenero(t.getGenero());
                p.setEstCivil(t.getEstCivil());
                p.setProfissao(t.getProfissao());
                p.setTelefone(t.getTelefone());
                p.setReligiao(t.getReligiao());

                return;

            }
        }
    }

    @Override
    public Paciente recuperar(Integer chave) {
        Paciente p = null;
        for (int i = 0; i < this.ControladorPaciente.size(); i++) {
            p = this.ControladorPaciente.get(i);
            if (p.getMatricula() == chave) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deletar(Paciente t) {
        this.ControladorPaciente.remove(t);
    }

    @Override
    public List<Paciente> recuperarTodos() {
        return this.ControladorPaciente;
    }

    /**
     *
     * @param paciente
     */
}
