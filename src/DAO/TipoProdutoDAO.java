/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Utils.HibernateUtil;
import Entidade.TipoProduto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class TipoProdutoDAO extends Dao<TipoProduto> {

    public TipoProduto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            TipoProduto retorno = (TipoProduto) sessao.get(TipoProduto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<TipoProduto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<TipoProduto> tipoquartos = null;
        try {
            org.hibernate.Query q = sessao.createQuery
        ("from tipo_produto t WHERE marca LIKE '%" + criteria + "%' AND situacao = 'A'");
            tipoquartos = q.list();
            return tipoquartos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<TipoProduto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<TipoProduto> tipoquartos = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from tipo_produto t WHERE situacao = 'A'");
            tipoquartos = q.list();
            return tipoquartos;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
