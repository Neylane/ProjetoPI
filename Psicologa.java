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

@Table(name="Psicologa")
@Entity
public class Psicologa {
    @Id
    private int CodLicenca;
    private String nome;
    private String anaminese;
    private int  telefone;
    private String cpf;
    private String email;
    private String login;
    private String senha;
   
    public Psicologa(int codigo, int CodLicenca ,String anaminese, String nome ,
            int telefone ,String cpf , String email ,String login , String senha){
        this.CodLicenca = CodLicenca;
        this.nome =nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.anaminese = anaminese;
                
     
    }
    @Deprecated
    public Psicologa() {
       
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

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getAnaminese() {
        return anaminese;
    }

    public void setAnaminese(String anaminese) {
        this.anaminese = anaminese;
    }
            
            
    
    
}
