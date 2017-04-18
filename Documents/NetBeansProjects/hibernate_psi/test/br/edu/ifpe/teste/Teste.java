/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.teste;

import br.edu.ifpe.psicologa.model.Psicologa;
import br.edu.ifpe.psicologa.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author kelly silva
 */
public class Teste {
   public static void main(String[]args){
     Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction t = session.beginTransaction();
       Psicologa p = new Psicologa();
       
       p.setCodLicenca(Integer.parseInt(JOptionPane.showInputDialog("digite o código de liçença: ")));
       p.setNome(JOptionPane.showInputDialog("digite o seu Nome: "));
       p.setEmail(JOptionPane.showInputDialog("digite o seu Email: "));
       p.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("digite seu telefone: ")));
       
       session.save(p);
       t.commit();
   }
}


