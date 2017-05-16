package br.edu.ifpe.respositorio.psicologa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.edu.ifpe.ifpe.model.PsicologaCrud;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioPsicologaMemo implements RepositorioGenerico<PsicologaCrud, Integer> {

    private List<PsicologaCrud> ListaControladorPsicologa = new ArrayList<>();

    @Override
    public void inserir(PsicologaCrud t) {
        this.ListaControladorPsicologa.add(t);
    }

    @Override
    public void alterar(PsicologaCrud t) throws Exception {
        PsicologaCrud p = null;
        for (int i = 0; i < this.ListaControladorPsicologa.size(); i++) {
            p = this.ListaControladorPsicologa.get(i);
            if (p.getClass().equals(t.getCodLicenca())) {
                p.setNome(t.getNome());
                p.setEmail(t.getEmail());
                p.setCpf(t.getCpf());
                p.setTelefone(t.getTelefone());
                p.setCodLicenca(t.getCodLicenca());

                return;
            }
        }
    }


    @Override
    public PsicologaCrud recuperar(Integer chave) {
        PsicologaCrud p = null;
        for (int i = 0; i < this.ListaControladorPsicologa.size(); i++) {
            p = this.ListaControladorPsicologa.get(i);
            if (p.getCodLicenca() == chave) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void deletar(PsicologaCrud psicologa) {
        this.ListaControladorPsicologa.remove(psicologa);
    }

    @Override
    public List<PsicologaCrud> recuperarTodos() {
        return this.ListaControladorPsicologa;
    }



    /**
     *
     * @param PsicologaCrud
     */
}
