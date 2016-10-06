package br.edu.ifpe.repositorio;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifpe.repositorio.interfaces.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;
import model.psicologa.PsicologaModel;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologa implements RepositorioGenerico<PsicologaModel, Integer> {

    private List<PsicologaModel> listaControladorPsicologa = new ArrayList<>();

    @Override
    public void inserir(PsicologaModel t) {
        this.listaControladorPsicologa.add(t);
    }

    @Override
    public void alterar(PsicologaModel t) throws Exception {
        PsicologaModel p = null;
        for (int i = 0; i < this.listaControladorPsicologa.size(); i++) {
            p = this.listaControladorPsicologa.get(i);
            if (p.getNome().equals(t.getNome())) {
                p.setCodLicenca(t.getCodLicenca());
                p.setAnaminese(t.getAnaminese());
                p.setCpf(t.getCpf());
                p.setEmail(t.getEmail());
                p.setLogin(t.getLogin());
                p.setSenha(t.getSenha());
               
                return;
            }
        }
    }

    @Override
    public PsicologaModel recuperar(Integer chave) {
        PsicologaModel p = null;
        for (int i = 0; i < this.listaControladorPsicologa.size(); i++) {
            p = this.listaControladorPsicologa.get(i);
            if (p.getCodLicenca()== chave) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deletar(PsicologaModel t) {
        this.listaControladorPsicologa.remove(t);
    }

    @Override
    public List<PsicologaModel> recuperarTodos() {
        return this.listaControladorPsicologa;
    }

    /**
     *
     * @param psicologaModel
     */
}


