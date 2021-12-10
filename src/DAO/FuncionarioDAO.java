/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.Funcionario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class FuncionarioDAO extends Dao<Funcionario> {

    public Funcionario findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Funcionario retorno = (Funcionario) sessao.get(Funcionario.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public Funcionario findByEntityId(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario funcionario = null;
        try {
            org.hibernate.Query q = sessao.createQuery("FROM\n"
                    + "	funcionario a\n"
                    + "WHERE\n"
                    + "	a.id_entidade = "+id);
            funcionario = (Funcionario) q.uniqueResult();
            return funcionario;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Funcionario> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Funcionario> funcionario = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Funcionario p WHERE nome LIKE '%" + criteria + " %' ORDER BY id_funcionario");
            funcionario = q.list();
            return funcionario;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Funcionario> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Funcionario> funcionario = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Funcionario ORDER BY id_funcionario");
            funcionario = q.list();
            return funcionario;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
