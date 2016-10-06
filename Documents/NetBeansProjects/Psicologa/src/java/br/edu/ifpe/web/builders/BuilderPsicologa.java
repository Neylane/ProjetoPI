/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.web.builders;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.psicologa.PsicologaModel;


/**
 *
 * @author 1860915
 */

@ManagedBean(name = "bPsicologa")
@RequestScoped
public class BuilderPsicologa {
    
     private int CodLicenca;
    private String nome;
    private int  telefone;
    private String cpf;
    private String email;
    private String anaminese;
    private String login;
    private String senha;
   
    
    @Deprecated
    public BuilderPsicologa(){}

    public BuilderPsicologa(int CodLicenca, String nome){
        this.CodLicenca = CodLicenca;
        this.nome = nome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnaminese() {
        return anaminese;
    }

    public void setAnaminese(String anaminese) {
        this.anaminese = anaminese;
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
    
            
    public PsicologaModel bPsicologaModel(){
        return new PsicologaModel(this.CodLicenca,this. nome,this. telefone,this. cpf,this.email , this.anaminese,this. login, this.senha);
    }
    
}
    

