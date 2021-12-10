package DAO;

import Entidade.Funcionario;
import Entidade.Venda;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Gui
 */
public class VendaDAO extends Dao<Venda> {

    public Venda findById(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transacao = sessao.beginTransaction();
            Venda retorno = (Venda) sessao.get(Venda.class, id);
            return retorno;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Venda> findAllByDescription(String criteria) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Venda> vendas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Venda q WHERE id_cliente LIKE '%" + criteria + "%' ORDER BY id_venda");
            vendas = q.list();
            return vendas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Venda> findAll() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Venda> vendas = null;
        try {
            org.hibernate.Query q = sessao.createQuery("from Venda q ORDER BY id");
            vendas = q.list();
            return vendas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<Venda> findAll(Funcionario p) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List<Venda> vendas = null;
        try {
            org.hibernate.Query q = sessao.createQuery(""
                    + "FROM\n"
                    + "	funcionario a,\n"
                    + "	venda b, \n"
                    + "	venda_produto c,\n"
                    + "	produto d,\n"
                    + "	tipo_produto e,\n"
                    + "	entidade f\n"
                    + "WHERE\n"
                    + "	a.id_entidade = b.id_entidade\n"
                    + "	AND a.id_entidade = f.id_entidade\n"
                    + "	AND b.id_venda = c.id_venda\n"
                    + "	AND c.id_produto = d.id_produto\n"
                    + "	AND d.id_tipo_produto = e.id_tipo_produto\n"
                    + "ORDER BY\n"
                    + "	1");
            vendas = q.list();
            return vendas;
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }
        return null;
    }
}
