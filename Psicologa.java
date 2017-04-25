package br.edu.ifpe.psicologa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Naty
 */
@Entity(name = "psicologa")
public class Psicologa {

    @Id
    @GeneratedValue
    public int CodLicenca;
    public String nome;
    public int telefone;
    public String email;

    public Psicologa(int Codlicença, String nome, int telefone, String email) {
        this.CodLicenca = Codlicença;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Deprecated
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
