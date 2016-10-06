/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.psicologa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kelly silva
 */

@Table(name = "PsicologaModel")
@Entity
public class PsicologaModel {
    @Id
    private int CodLicenca;
    private String nome;
    private int  telefone;
    private String cpf;
    private String email;
    private String anaminese;
    private String login;
    private String senha;
   
    public PsicologaModel
        (int CodLicenca , String nome , int telefone ,String cpf , String email ,String anaminese,
               String login , String senha){
        this.CodLicenca = CodLicenca;
        this.nome =nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.anaminese = anaminese;
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
    
    public PsicologaModel (){
        
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

    public String getAnaminese() {
        return anaminese;
    }

    public void setAnaminese(String anaminese) {
        this.anaminese = anaminese;
    }
            
            
    public PsicologaModel bPsicologaModel(){
        return new PsicologaModel(this.CodLicenca,this. nome,this. telefone,this. cpf,this.email , this.anaminese,this. login, this.senha);
    }
    
}
