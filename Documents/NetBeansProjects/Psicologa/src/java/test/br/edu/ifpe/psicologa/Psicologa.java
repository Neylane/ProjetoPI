package test.br.edu.ifpe.psicologa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.util.psicologa.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import model.psicologa.PsicologaModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kelly silva
 */
public class Psicologa {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        PsicologaModel psicologa = new PsicologaModel();
        psicologa.setNome(JOptionPane.showInputDialog("digite seu nome: "));
        psicologa.setCodLicenca(Integer.parseInt(JOptionPane.showInputDialog("digite o código de licença")));
        psicologa.setCpf(JOptionPane.showInputDialog("digite seu cpf: "));
        psicologa.setEmail(JOptionPane.showInputDialog("digite seu email:"));
        psicologa.setEmail(JOptionPane.showInputDialog("digite a anaminese:"));
        psicologa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("digite seu telefone:")));
        psicologa.setLogin(JOptionPane.showInputDialog("digite seu login: "));
        psicologa.setSenha(JOptionPane.showInputDialog("digite seu senha:"));
        
        Serializable resultado =session.save(psicologa);
        List<PsicologaModel> lista =(List<PsicologaModel>)session.createQuery("From PsicologaModel").list();
        for(PsicologaModel psicologaModel : lista){
            JOptionPane.showMessageDialog(null,psicologa.getNome());
        }
        t.commit();

        
    }


}
