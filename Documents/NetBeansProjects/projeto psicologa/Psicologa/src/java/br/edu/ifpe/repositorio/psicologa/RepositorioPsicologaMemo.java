/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;

import br.edu.ifpe.model.psicologa.Psicologa;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologaMemo implements RepositorioGenerico<Psicologa, Integer> {

    private List<Psicologa> ListaControladorPsicologa = new ArrayList<>();

    @Override
    public void inserir(Psicologa t) {
        this.ListaControladorPsicologa.add(t);
    }

    @Override
    public void alterar(Psicologa t) throws Exception {
        Psicologa p = null;
        for (int i = 0; i < this.ListaControladorPsicologa.size(); i++) {
            p = this.ListaControladorPsicologa.get(i);
            if (p.getCpf().equals(t.getCpf())) {
                p.setNome(t.getNome());
                p.setEmail(t.getEmail());
                p.setTelefone(t.getTelefone());
                p.setCodLicenca(t.getCodLicenca());

                return;
            }
        }
    }

    @Override
    public Psicologa recuperar(Integer chave) {
        Psicologa p = null;
        for (int i = 0; i < this.ListaControladorPsicologa.size(); i++) {
            p = this.ListaControladorPsicologa.get(i);
            if (p.getCodLicenca() == chave) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deletar(Psicologa psicologa) {
        this.ListaControladorPsicologa.remove(psicologa);
    }

    @Override
    public List<Psicologa> recuperarTodos() {
        return this.ListaControladorPsicologa;
    }

    public Psicologa recuperar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(Psicologa psicologa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param psicologa
     */
}
