package DAO;

import Entidade.VendaProduto;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class VendaProdutoDAO extends Dao<VendaProduto> {

    public VendaProduto findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            VendaProduto retorno = (VendaProduto) sessao.get(VendaProduto.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
    
    public boolean saveD(VendaProduto object) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Integer cod = null;
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(object);
            transacao.commit();
            return true;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
            transacao.rollback();
            Dao.logger.error("Erro no registro: " + hibEx.toString());
            //Dao.logger.warn("Erro no registro: " + hibEx.toString());
        } finally {
            sessao.close();
        }
        return false;
    }


    public List<VendaProduto> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<VendaProduto> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from venda_produto q WHERE id_venda_produto LIKE '%" + criteria + "%' ORDER BY id_venda_produto");
            reservas = q.list();
            return reservas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<VendaProduto> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<VendaProduto> reservas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from venda_produto q ORDER BY id_venda_produto");
            reservas = q.list();
            return reservas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
