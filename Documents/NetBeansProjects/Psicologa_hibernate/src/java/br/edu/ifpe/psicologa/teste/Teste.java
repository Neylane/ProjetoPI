/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.psicologa.teste;


import br.edu.ifpe.psicologa.model.Psicologa;
import br.edu.psicologa.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kelly silva
 */
public class Teste {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Psicologa psicologa = new Psicologa();

        psicologa.setCodLicenca(Integer.parseInt(JOptionPane.showInputDialog("digite o código de licença")));
        psicologa.setNome(JOptionPane.showInputDialog("digite seu nome:"));
        psicologa.setEmail(JOptionPane.showInputDialog("digite seu email:"));
        psicologa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("digite seu telefone")));

        session.save(psicologa);
        t.commit();
    }

}
