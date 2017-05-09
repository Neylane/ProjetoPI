/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.dao;

import br.edu.ifpe.hibernate.util.HibernateUtil;
import br.edu.ifpe.ifpe.model.PsicologaCrud;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.hibernate.Session;


/**
 *
 * @author kelly silva
 */
public class PsicologaDao implements InterfacePsicologa{

    @Override
    public PsicologaCrud getPsicologaCrud(Long id) { //id chama qualquer metodo da classe PsicologaCrud
    Session ss = HibernateUtil.getSessionFactory().getCurrentSession(); 
// chama a classe HibernateUtil utilixando o session
    return (PsicologaCrud)ss.load(PsicologaCrud.class, id);
    //retorna chamando a classe PsicologaCrud.
    }

    @Override
    public void salvar(PsicologaCrud psicologaCrud) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        //Utilizando o session ele chama a classe HibernateUtil.
        ss.getTransaction().begin();
        ss.save(psicologaCrud);// salva os dados da psicologaCrud.
        ss.beginTransaction().commit();// faz o commit.
    }

    @Override
    public void remover(PsicologaCrud psicologaCrud) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
         //Utilizando o session ele chama a classe HibernateUtil.
        ss.beginTransaction();
        ss.delete(psicologaCrud);// remove ou deleta os dados da psicologaCrud.
        ss.beginTransaction().commit();// faz o commit.
    }

    @Override
    public void atualizar(PsicologaCrud psicologaCrud) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        //Utilizando o session ele chama a classe HibernateUtil.
        ss.beginTransaction();
        ss.update(psicologaCrud);// atualiza os dados da psicologaCrud.
        ss.beginTransaction().commit();// faz o commit. Commit:ele grava as alterações que vc fez no banco
    }

    @Override
    public List<PsicologaCrud> list() {
       Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
       //Chama o a classe HibernateUtil
        ss.beginTransaction();
        List lista = ss.createQuery("From psicologacrud").list();
        //Lista os dados da tabela psicologaCrud
        ss.beginTransaction().commit();
        return lista;
        
    }

    public static  class list implements List<PsicologaCrud> {

        public list() {
        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean contains(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Iterator<PsicologaCrud> iterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T> T[] toArray(T[] a) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean add(PsicologaCrud e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(Collection<? extends PsicologaCrud> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean addAll(int index, Collection<? extends PsicologaCrud> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public PsicologaCrud get(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public PsicologaCrud set(int index, PsicologaCrud element) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(int index, PsicologaCrud element) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public PsicologaCrud remove(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int indexOf(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int lastIndexOf(Object o) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ListIterator<PsicologaCrud> listIterator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ListIterator<PsicologaCrud> listIterator(int index) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<PsicologaCrud> subList(int fromIndex, int toIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }


       
    }
    

