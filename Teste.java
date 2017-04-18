/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.psicologa;


import br.edu.ifpe.Hibernate.util.psicologa.HibernateUtil;
import br.edu.ifpe.model.psicologa.Psicologa;
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
            psicologa.setAnaminese(JOptionPane.showInputDialog("digite a anaminese:"));
            psicologa.setEmail(JOptionPane.showInputDialog("digite seu email:"));
            psicologa.setCpf(JOptionPane.showInputDialog("digite a cpf:"));
            psicologa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("digite seu telefone")));
            psicologa.setLogin(JOptionPane.showInputDialog("digite seu login:"));
            psicologa.setSenha(JOptionPane.showInputDialog("digite sua senha:"));
            
            session.save(psicologa);
             t.commit();
        }

    }

 
    


