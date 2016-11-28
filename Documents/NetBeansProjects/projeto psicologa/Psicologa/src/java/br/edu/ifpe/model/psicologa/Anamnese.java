/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.model.psicologa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "Anamnese")
public class Anamnese {
    @Id
    private int matri;
    private String  nome;
    private String idade;
    private String genero;
    private String endereco;
    private String profissao;
    private String contatos;
    
    public Anamnese(int matri , String nome , String idade ,
            String genero, String endereco,String profissao , String contatos){
        
        this.nome = nome;
        this.matri = matri;
        this.contatos = contatos;
        this.genero = genero;
        this.endereco = endereco;
        this.profissao = profissao;
        this.idade = idade;
    }
@Deprecated
    public Anamnese() {
    }

    public int getMatri() {
        return matri;
    }

    public void setMatri(int matri) {
        this.matri = matri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getContatos() {
        return contatos;
    }

    public void setContatos(String contatos) {
        this.contatos = contatos;
    }
    
    
}
