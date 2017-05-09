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
@Table(name = "Psicologa")
public class Psicologa {

    @Id
    private String cpf;
    private String nome;
    private int telefone;
    private int CodLicenca;
    private String email;
    private String login;
    private String senha;

    public Psicologa(int CodLicenca, String nome,
            int telefone, String cpf, String email, String login, String senha) {
        this.CodLicenca = CodLicenca;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Psicologa() {

    }

    public int getCodLicenca() {
        return CodLicenca;
    }

    public void setCodLicenca(int CodLicenca) {
        this.CodLicenca = CodLicenca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
