package DAO;

import Entidade.Funcionario;
import Utils.HibernateUtil;
import apoio.ConexaoBD;
import java.util.List;
import Entidade.Venda;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    
    public String salvar(Venda o) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            System.out.println("Este é o ID vindo " +o.getId_venda());
            if (o.getId_venda() == 0) {

                sql = "Insert into venda values "
                    + "(default,"
                    + " '" + o.getDt_venda() + "',"
                    + " '1',"
                    + " '" + o.getId_cliente()  + "',"
                    + " '" + o.getId_funcionario() + "')";

            } else {
                sql = "update venda "
                        + "set dt_venda = '"   + o.getDt_venda()      + "', "
                        + "id_cliente = '"        + o.getId_cliente()       + "', "
                        + "id_pessoa = '"       + o.getId_funcionario()       + "' "
                        + "where id_venda = "          + o.getId_venda();
            }

            sql += " RETURNING id_venda";

            System.out.println("SQL: " + sql);

            ResultSet result = stm.executeQuery(sql);
            result.next();
            System.out.println(result.getString("id_venda"));
            int resultado = Integer.parseInt(result.getString("id_venda"));
            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                System.out.println(resultado);
                return resultado + "";
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
    }
    
    public void popularTabela(JTable tabela, String nome, String datainicio, String datafim) {
        ResultSet resultadoQ = null;
        
        //dados da tabela
        Object[][] dadosTabela = null;

        //cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "ID";
        cabecalho[1] = "Cliente";
        cabecalho[2] = "ID Cliente";
        cabecalho[3] = "Data Venda";
        cabecalho[4] = "Funcionario";
        cabecalho[5] = "ID Funcionario";


        //cria matriz de acordo com nº de registros da tabela
        try {
            String sql = ""
                    + "SELECT count(*) "
                    + "FROM venda v "
                    + "INNER JOIN funcionario p "
                    + "ON p.id_funcionario = v.id_funcionario "
                    + "INNER JOIN cliente c "
                    + "ON c.id_cliente = v.id_cliente";

            if (nome != "") {
                sql += " WHERE c.razaosocial ILIKE '%" + nome + "%'";  
            }
            System.out.println("dataini = "+datainicio+ " datafim = "+datafim);
            System.out.println(sql);

            if (!datainicio.isEmpty() && !datafim.isEmpty() && datainicio.matches(".*\\d.*") && datafim.matches(".*\\d.*")) {
                sql += " AND v.dt_venda BETWEEN '" + datainicio + "' AND '" + datafim + "'";
            } else {
                if (!datainicio.isEmpty()&& datainicio.matches(".*\\d.*")) {
                    sql += " AND v.dt_venda >= '" + datainicio + "'";
                }

                if (!datafim.isEmpty() && datafim.matches(".*\\d.*")) {
                    sql += " AND v.dt_venda <= '" + datafim + "'";
                }
            }

            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();

            //instancia da matriz de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        int lin = 0;

        //efetua consulta na tabela

        try {
            String sql = ""
                    + "SELECT v.id_venda            AS cod "
                    + "     , c.razaosocial  AS cliente "
                    + "     , c.id_cliente            AS clientecod "
                    + "     , v.dt_venda    AS dataVenda "
                    + "     , p.nome          AS funcionario "
                    + "     , p.id_funcionario            AS funcionarioID "
                    + "FROM venda v "
                    + "INNER JOIN funcionario p "
                    + "ON p.id_funcionario = v.id_funcionario "
                    + "INNER JOIN cliente c "
                    + "ON c.id_cliente = v.id_cliente ";

            if (nome != "") {
                sql += " WHERE c.razaosocial ILIKE '%" + nome + "%'";  
            }
            System.out.println("dataini = "+datainicio+ " datafim = "+datafim);
            System.out.println(sql);

            if (!datainicio.isEmpty() && !datafim.isEmpty() && datainicio.matches(".*\\d.*") && datafim.matches(".*\\d.*")) {
                sql += " AND v.dt_venda BETWEEN '" + datainicio + "' AND '" + datafim + "'";
            } else {
                if (!datainicio.isEmpty()&& datainicio.matches(".*\\d.*")) {
                    sql += " AND v.dt_venda >= '" + datainicio + "'";
                }

                if (!datafim.isEmpty()&& datafim.matches(".*\\d.*")) {
                    sql += " AND v.dt_venda <= '" + datafim + "'";
                }
            }
            System.out.println(sql);
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);   
            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("cod");
                dadosTabela[lin][1] = resultadoQ.getString("cliente");
                dadosTabela[lin][2] = resultadoQ.getInt("clientecod");
                dadosTabela[lin][3] = resultadoQ.getString("dataVenda");
                dadosTabela[lin][4] = resultadoQ.getString("funcionario");
                dadosTabela[lin][5] = resultadoQ.getString("funcionarioID");

                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        //configuracoes adicionais no componente tabela
        /*tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {

            //permite seleção de apenas uma linha da tabela
            tabela.setSelectionMode(0);

            //redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < tabela.getColumnCount(); i++) {
                column = tabela.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(80);
                        column.setMaxWidth(80);
                        column.setMinWidth(25);
                        break;
                    case 1:
                        column.setPreferredWidth(140);
                        break;
                    case 2:
                        column.setPreferredWidth(14);
                        break;
                }
            }
            //renderizacao das linhas da tabela = mudar a cor
            tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected,
                            hasFocus, row, column);
                    if (row % 2 == 0) {
                        setBackground(Color.CYAN);
                    } else {
                        setBackground(Color.LIGHT_GRAY);
                    }
                    return this;
                }
            });
        }*/
    }

}
