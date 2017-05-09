/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.hibernate.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.ifpe.model.PsicologaCrud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author kelly silva
 */
public class JDBCPsicologa {

    private static SessionFactory sessionF = null;
    private static Session session;
    private static JDBCPsicologa instance;

    private JDBCPsicologa () {

    }

    public static JDBCPsicologa  getInstance() {
        if (instance == null) {
            instance = new JDBCPsicologa ();
        }
        return instance;
    }

    public static SessionFactory getFactoryConfig() {
        if (sessionF == null) {
            sessionF = new Configuration().configure().buildSessionFactory();
        }
        return sessionF;
    }

    public static Session Opened() {
        if (session != null && !session.isOpen()) {
            session = null;
        }

        session = getFactoryConfig().openSession();

        return session;
    }

    public void insertOrUpdate(PsicologaCrud psi) {
        session = Opened();
        session.getTransaction().begin();
        session.saveOrUpdate(psi);
        session.getTransaction().commit();
    }

    public void read(int id) {//ler
        session = Opened();
        session.getTransaction().begin();
        try {// faz uma exceção caso o código de Licença seja inexixtente.
            PsicologaCrud psi = (PsicologaCrud) session.get(PsicologaCrud.class, id);
            System.out.println(psi.getNome() + " " + psi.getCodLicenca());
            // mostra o nome e o código de licença do psicologo(a)
        } catch (NullPointerException ex) {//trata a exceção
            System.err.println("Erro: Tentou buscar um codigo inexistente.");
            //mostra a mensagem.
        }

    }

    public void delete(int id) {//excluir
        session = Opened();
        session.getTransaction().begin();
         PsicologaCrud psi  = ( PsicologaCrud) session.get( PsicologaCrud.class, id);
        try {//trata uma exceção caso exclua algo que não exista. 
            session.delete(psi);
        } catch (IllegalArgumentException ex) {
            System.err.println("Erro: Tentou deletar algo que não existe.");
            //mostra a mensagem
        }
        session.getTransaction().commit();// faz o commit.
    }

    public void listQuery() {
        session = Opened();
        @SuppressWarnings("UnusedAssignment")
        List< PsicologaCrud> psis = new ArrayList<>();// chama a classe psicologaCrud
        psis = session.createQuery("from  PsicologaCrud").list();//chama a tabela da classe psicologaCrud.

        for ( PsicologaCrud g : psis) {// dados da tabela psicologaCrud
            System.out.println("Codigo de Licença: " + g.getCodLicenca());
            System.out.println("Nome : " + g.getNome());
            System.out.println("CPF : " + g.getCpf());
            System.out.println("Email : " + g.getEmail());
            System.out.println("Telefone: " + g.getTelefone());

        }
    }

}
