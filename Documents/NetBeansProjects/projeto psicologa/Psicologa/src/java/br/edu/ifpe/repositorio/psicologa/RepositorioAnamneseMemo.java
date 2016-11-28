/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.repositorio.psicologa;
import br.edu.ifpe.model.psicologa.Anamnese;
import br.edu.ifpe.repositorio.interfaces.psicologa.RepositorioGenerico;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kelly silva
 */
public class RepositorioAnamneseMemo implements RepositorioGenerico<Anamnese, Integer> {

    private List<Anamnese> ControladorAnamnese = new ArrayList<>();

    @Override
    public void inserir(Anamnese t) {
        this.ControladorAnamnese.add(t);
    }

    @Override
    public void alterar(Anamnese t) throws Exception {
        Anamnese a = null;
        for (int i = 0; i < this.ControladorAnamnese.size(); i++) {
            a = this.ControladorAnamnese.get(i);
            if (a.getContatos().equals(t.getContatos())) {
                a.setEndereco(t.getEndereco());
                a.setGenero(t.getGenero());
                a.setIdade(t.getIdade());
                 a.setMatri(t.getMatri());
                  a.setNome(t.getNome());
                   a.setProfissao(t.getProfissao());
                return;

            }
        }
    }

    @Override
    public Anamnese recuperar(Integer chave) {
        Anamnese a = null;
        for (int i = 0; i < this.ControladorAnamnese.size(); i++) {
            a = this.ControladorAnamnese.get(i);
            if (a.getMatri()== chave) {
                return a;
            }
        }
        return null;
    }

    @Override
    public void deletar(Anamnese t) {
        this.ControladorAnamnese.remove(t);
    }

    @Override
    public List<Anamnese> recuperarTodos() {
        return this.ControladorAnamnese;
    }

    /**
     *
     * @param anamnese
     */
}
