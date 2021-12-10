/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class ClienteDAO extends Dao<Cliente> {

    public Cliente findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Cliente retorno = (Cliente) sessao.get(Cliente.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public Cliente findByEntityId(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = null;
        try {
            org.hibernate.Query q = sessao.createQuery("FROM\n"
                    + "	cliente a\n"
                    + "WHERE\n"
                    + "	a.id_entidade = "+id);
            cliente = (Cliente) q.uniqueResult();
            return cliente;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Cliente> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> cliente = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Cliente p WHERE nome LIKE '%" + criteria + " %' ORDER BY id_cliente");
            cliente = q.list();
            return cliente;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Cliente> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Cliente> cliente = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Cliente ORDER BY id_cliente");
            cliente = q.list();
            return cliente;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
