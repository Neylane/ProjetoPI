/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio;


import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;
import model.psicologa.PacienteModel;

/**
 *
 * @author 1860915
 */
public class RepositorioPaciente implements RepositorioGenerico<PacienteModel, Integer> {

    private List<PacienteModel> listaControladorPacienteModel= new ArrayList<>();

    @Override
    public void inserir(PacienteModel t) {
        this.listaControladorPacienteModel.add(t);
    }

    @Override
    public void alterar(PacienteModel t) throws Exception {
        PacienteModel pc = null;
        for (int i = 0; i < this.listaControladorPacienteModel.size(); i++) {
            pc = this.listaControladorPacienteModel.get(i);
            if (pc.getCpf().equals(t.getCpf())) {
                pc.setNome(t.getNome());
                pc.setEndereco(t.getEndereco());
                pc.setTelefone(t.getTelefone());
                pc.setIdade(t.getIdade());
                pc.setRg(t.getRg());
                pc.setNumConsultas(t.getNumConsultas());
       
                return;
            }
        }
    }

    @Override
    public PacienteModel recuperar(Integer chave) {
        PacienteModel pc = null;
        for (int i = 0; i < this.listaControladorPacienteModel.size(); i++) {
            pc = this.listaControladorPacienteModel.get(i);
            if (pc.getRg()== chave) {
                return pc;
            }
        }
        return null;
    }

    @Override
    public void deletar(PacienteModel t) {
        this.listaControladorPacienteModel.remove(t);
    }

    @Override
    public List<PacienteModel> recuperarTodos() {
        return this.listaControladorPacienteModel;
    }

    /**
     *
     * @param pacienteModel
     */
 
}
