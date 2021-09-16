/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOS;
import entidade.VendaItens;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Gui
 */
public class VendaItensDAO implements IDAOS<VendaItens>{
    ResultSet resultadoQ;
    
    public boolean salvarInicial(VendaItens o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into venda_itens values "
                    + "(default,"
                    + " '" + o.getProduto_cod()+  "',"
                    + " '" + o.getVenda_cod()+ "',"
                    + " '" + o.getQuantidade() + "',"
                    + " '" + o.getValor_venda()+ "')";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return false;
        }
    }

    @Override
    public String salvar(VendaItens o) {
         try {
//          Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getCod() == 0) {

                sql = "Insert into venda_itens values "
                    + "(default,"
                    + " '" + o.getProduto_cod()+  "',"
                    + " '" + o.getVenda_cod()+ "',"
                    + " '" + o.getQuantidade() + "',"
                    + " '" + o.getValor_venda()+ "')";
            } else {
                sql = "update venda_itens "
                        + "set produto_cod = '" + o.getProduto_cod()+ "', "
                        + "venda_cod = '" + o.getVenda_cod() + "', "
                        + "quantidade = '" + o.getQuantidade() + "', "
                        + "valor_venda = '" + o.getValor_venda()+ "' "
                        + "where cod = " + o.getCod();
            }

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);
            
            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return "Itens cadastrados!";
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar venda: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(VendaItens o) {
        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update pessoa "
                        + "set produto_cod = '" + o.getProduto_cod()+ "', "
                        + "venda_cod = '" + o.getVenda_cod() + "', "
                        + "quantidade = '" + o.getQuantidade() + "', "
                        + "valor_venda = '" + o.getValor_venda()+ "' "
                        + "where cod = " + o.getCod();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);
            
            if (resultado == 0) {
                return "Erro ao inserir";
            } else {
                return "Venda atualizada!";
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int cod) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM venda_itens "
                    + "WHERE cod = " + cod;

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao excluir!";
            } else {
                return "Item excluido!";
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir equipamento: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<VendaItens> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<VendaItens> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendaItens consultarId(int cod) {
        VendaItens vi = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select cod "
                    + "from venda_itens "
                    + "where cod = " + cod;

            System.out.println("SQL: " + sql);
            
            resultadoQ = st.executeQuery(sql);

            //ResultSet retorno = st.executeQuery(sql);

            /*if (retorno.next()) {
                vi = new VendaItens();

                vi.setId(retorno.getInt("cod"));
                vi.setProduto_cod(retorno.getInt("produto_cod"));
                vi.setVenda_cod(retorno.getInt("venda_cod"));
                vi.setQuantidade(retorno.getInt("quantidade"));
                vi.setValor_venda(retorno.getFloat("valor_venda"));
            }*/

        } catch (Exception e) {
            System.out.println("Erro ao consultr categoria: " + e);
        }

        return vi;
    }
    public String excluirItem(VendaItens o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM venda_itens "
                    + "WHERE cod = " + o.getCod();

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);
            if (resultado == 0) {
                return "Erro ao excluir!";
            } else {
                return "Item excluido!";
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir equipamento: " + e);
            return e.toString();
        }
    }
    
    public void popularTabela(JTable tabela, String cod) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Cod";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Quantidade";
        cabecalho[3] = "Valor Item";
        cabecalho[4] = "Valor Total";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = ""
                    + "SELECT count(*) "
                    + "FROM venda_itens vi "
                    + "INNER JOIN produto i "
                    + "ON vi.produto_cod = i.cod "
                    + "WHERE vi.venda_cod = " + cod + "";

            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            String sql = ""
                    + "SELECT vi.cod                    AS codvendaitens "
                    + "     , i.nome                    AS descricao "
                    + "     , vi.quantidade             AS quantidade "
                    + "     , i.valor                   AS valoritem"
                    + "     , (i.valor * vi.quantidade) AS valor "
                    + "FROM venda_itens vi "
                    + "INNER JOIN produto i "
                    + "ON vi.produto_cod = i.cod "
                    + "WHERE vi.venda_cod = " + cod + "";
            
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("codvendaitens");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = resultadoQ.getString("quantidade");
                dadosTabela[lin][3] = resultadoQ.getString("valoritem");
                dadosTabela[lin][4] = resultadoQ.getString("valor");
                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //return ImageIcon.class;
                    //return Boolean.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
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
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
//        renderizacao das linhas da tabela = mudar a cor
//        tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.CYAN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
    public int ultimoIDInserido() {
        try {
            String sql = ""
                    + " SELECT max(cod)"
                    + " FROM venda_itens";

            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();

            return resultadoQ.getInt(1);
        } catch (Exception e) {
        }
        return 0;

    }
    
}
