package br.edu.ifpe.controlador.psicologa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ifpe.model.psicologa.Psicologa;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kelly silva
 */
@ManagedBean(name = "controleLogin")
@RequestScoped
public class ControladorLogin {

    private Psicologa psicologaLogado = null;
    private ControladorPsicologa controleLogin = null;

    public ControladorLogin() {

        HttpSession session = ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
                .getSession(true));

        controleLogin = (ControladorPsicologa) session.getAttribute("controleLogin");

        if (controleLogin == null) {
            controleLogin = new ControladorPsicologa();
            session.setAttribute("controleLogin", controleLogin);
        }
    }

    public String realizarLogin(String login, String senha) {
        logarPsicologa(login, senha);

        if (psicologaLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atenção!", "Psicologa Não Cadastrado!"));
            return "index.xhtml";
        } else if (psicologaLogado != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bem Vindo! " + psicologaLogado.getNome()));
            return "ApresentarPsicologa.xhtml";
        }

        return null;
    }

    public void logarPsicologa(String login, String senha) {
        Psicologa p = controleLogin.recuperar(login, senha);
        if (p != null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.setAttribute("Psicologa", p);
            psicologaLogado = p;
        } else {
            psicologaLogado = null;
        }
    }

    public Psicologa getPsicologaLogado() {
        return psicologaLogado;
    }

    public void setPsicologaLogado(Psicologa psicologaLogado) {
        this.psicologaLogado = psicologaLogado;
    }

    public void sair() {

        this.psicologaLogado = null;
        ((HttpSession) (FacesContext.getCurrentInstance().getExternalContext().getSession(true))).removeAttribute("Psicologa");

    }

}
