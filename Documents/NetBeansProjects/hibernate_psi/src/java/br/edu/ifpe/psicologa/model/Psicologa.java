/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.psicologa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */
@Entity
@Table(name = "hibernate_psi")
public class Psicologa {

    @Id
    private int CodLicenca;
    private String nome;
    private int telefone;
    private String email;
   

    public Psicologa(int CodLicenca, String nome,
            int telefone, String email) {
        this.CodLicenca = CodLicenca;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
      

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
