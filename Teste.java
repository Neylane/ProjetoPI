/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.teste;

import br.edu.ifpe.psicologa.model.Psicologa;
import br.edu.ifpe.psicologa.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Naty
 */
public class Teste {
    public static void main(String[]args){
        Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction t = session.beginTransaction();
       Psicologa psicologa = new Psicologa();
       psicologa.setCodLicenca(Integer.parseInt(JOptionPane.showInputDialog("digite o código de licença")));
       psicologa.setNome(JOptionPane.showInputDialog("digite o seu nome:"));
       psicologa.setEmail(JOptionPane.showInputDialog("digite o seu email:"));
       psicologa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("digite o seu telefone:")));
       
               session.save(psicologa);
               t.commit();
       
    }
}
