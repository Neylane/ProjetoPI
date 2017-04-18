package br.edu.ifpe.model.psicologa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    private int matricula;
    private String nome;
    private int idade;
    private String genero;
    private String endereco;
    private int telefone;
    private String religiao;
    private String EstCivil;
    private String profissao;

    public Paciente(int matricula, String nome, int idade, String genero, String endereco, int telefone, String religiao, String EstCivil, String profissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.endereco = endereco;
        this.telefone = telefone;
        this.religiao = religiao;
        this.EstCivil = EstCivil;
        this.profissao = profissao;
    }

    @Deprecated
    public Paciente() {

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public String getEstCivil() {
        return EstCivil;
    }

    public void setEstCivil(String EstCivil) {
        this.EstCivil = EstCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
