/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class FornecedorDAO extends Dao<Fornecedor> {

    public Fornecedor findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Fornecedor retorno = (Fornecedor) sessao.get(Fornecedor.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public Fornecedor findByEntityId(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Fornecedor fornecedor = null;
        try {
            org.hibernate.Query q = sessao.createQuery("FROM\n"
                    + "	fornecedor a\n"
                    + "WHERE\n"
                    + "	a.id_entidade = "+id);
            fornecedor = (Fornecedor) q.uniqueResult();
            return fornecedor;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Fornecedor> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Fornecedor> fornecedor = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Fornecedor p WHERE nome LIKE '%" + criteria + " %' ORDER BY id_fornecedor");
            fornecedor = q.list();
            return fornecedor;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Fornecedor> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Fornecedor> fornecedor = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Fornecedor ORDER BY id_fornecedor");
            fornecedor = q.list();
            return fornecedor;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
