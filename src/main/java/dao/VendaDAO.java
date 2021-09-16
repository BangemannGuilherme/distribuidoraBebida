/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOS;
import entidade.Venda;
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
public class VendaDAO implements IDAOS<Venda> {
    
    ResultSet resultadoQ = null;
    
    Formatacao fmt = new Formatacao();
    
    
    public boolean salvarInicial(Venda venda) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into venda values "
                    + "(default,"
                    + " '" + venda.getData_venda() + "',"
                    + " '" + venda.getStatus()   + "',"
                    + " '" + venda.getCliente_cod()  + "',"
                    + " '" + venda.getPessoa_cod() + "')";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return false;
        }
    }

    @Override
    public String salvar(Venda o) {
       try {
//          Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            System.out.println("Este é o ID vindo " +o.getCod());
            if (o.getCod() == 0) {

                sql = "Insert into venda values "
                    + "(default,"
                    + " '" + o.getData_venda() + "',"
                    + " '" + o.getStatus()   + "',"
                    + " '" + o.getCliente_cod()  + "',"
                    + " '" + o.getPessoa_cod() + "')";

            } else {
                sql = "update venda "
                        + "set data_venda = '"   + o.getData_venda()      + "', "
                        + "status = '"         + o.getStatus()        + "', "
                        + "cliente_cod = '"        + o.getCliente_cod()       + "', "
                        + "pessoa_cod = '"       + o.getPessoa_cod()       + "' "
                        + "where cod = "          + o.getCod();
            }
            
            sql += " RETURNING cod";
            
            System.out.println("SQL: " + sql);
            
            ResultSet result = stm.executeQuery(sql);
            result.next();
            System.out.println(result.getString("cod"));
            int resultado = Integer.parseInt(result.getString("cod"));
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

    @Override
    public String atualizar(Venda o) {
                try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update venda "
                        + "set data_venda = '"   + o.getData_venda()      + "', "
                      //  + "valor = '"            + o.getValor()           + "', "
                        + "status = '"         + o.getStatus()        + "', "
                        + "cliente_cod = '"        + o.getCliente_cod()       + "', "
                        + "pessoa_cod = '"       + o.getPessoa_cod()       + "' "
                        + "where cod = "          + o.getCod();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria: " + e);
            return e.toString();
        }
    }
    
    /*@Override
    public boolean atualizar(Venda o) {
                try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update venda "
                        + "set data_venda = '"   + o.getData_venda()      + "', "
                      //  + "valor = '"            + o.getValor()           + "', "
                        + "status = '"         + o.getStatus()        + "', "
                        + "pessoa_cod = '"        + o.getPessoa_cod()       + "', "
                        + "cliente_cod = '"       + o.getCliente_cod()       + "' "
                        + "where cod = "          + o.getCod();

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar categoria: " + e);
            return false;
        }
    }*/

    @Override
    public String excluir(int cod) {
                try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

//            String sql = "delete from categoria "
//                    + "where cod = " + cod;
            String sql = "update venda "
                    + "set status = 'i' "
                    + "where cod = " + cod;

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir/inativar: " + e);
            return e.toString();
        }
    }
    
        /*@Override
    public boolean excluir(int cod) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update venda "
                    + "set status = 'i' "
                    + "where cod = " + cod;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir/inativar: " + e);
            return false;
        }
    }*/

    @Override
    public ArrayList<Venda> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda consultarId(int cod) {
        Venda venda = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * "
                    + "from venda "
                    + "where "
                    + "cod = " + cod;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) {
                venda = new Venda();

                venda.setCod(retorno.getInt("cod"));
                venda.setData_venda(retorno.getString("data_venda"));
               // venda.setValor(retorno.getFloat("valor"));
                venda.setStatus(retorno.getString("status").charAt(0));
                venda.setCliente_cod(retorno.getString("cliente_cod"));
                venda.setPessoa_cod(retorno.getString("pessoa_cod"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultr categoria: " + e);
        }

        return venda;
    }
    public void popularTabela(JTable tabela, String nome, String datainicio, String datafim) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[7];
        cabecalho[0] = "Cod";
        cabecalho[1] = "Cliente";
        cabecalho[2] = "Cod Cliente";
        cabecalho[3] = "Data Venda";
        cabecalho[4] = "Pessoa";
        cabecalho[5] = "Cod Pessoa";
        cabecalho[6] = "Status Venda";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            String sql = ""
                    + "SELECT count(*) "
                    + "FROM venda v "
                    + "INNER JOIN pessoa p "
                    + "ON p.cod = v.pessoa_cod "
                    + "INNER JOIN cliente c "
                    + "ON c.cod = v.cliente_cod";
            
            if (nome != "") {
                sql += " WHERE c.razaosocial ILIKE '%" + nome + "%'";  
            }
            System.out.println("dataini = "+datainicio+ " datafim = "+datafim);
            System.out.println(sql);
            
            if (!datainicio.isEmpty() && !datafim.isEmpty() && datainicio.matches(".*\\d.*") && datafim.matches(".*\\d.*")) {
                sql += " AND v.data_venda BETWEEN '" + datainicio + "' AND '" + datafim + "'";
            } else {
                if (!datainicio.isEmpty()&& datainicio.matches(".*\\d.*")) {
                    sql += " AND v.data_venda >= '" + datainicio + "'";
                }
                
                if (!datafim.isEmpty() && datafim.matches(".*\\d.*")) {
                    sql += " AND v.data_venda <= '" + datafim + "'";
                }
            }
            
            
            
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();

            // instancia da matriz de acordo com o nº de linhas do ResultSet
            dadosTabela = new Object[resultadoQ.getInt(1)][7];

        } catch (Exception e) {
            System.out.println("Erro ao consultar categoria: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela

        try {
            String sql = ""
                    + "SELECT v.cod            AS cod "
                    + "     , c.razaosocial  AS cliente "
                    + "     , c.cod            AS clientecod "
                    + "     , v.data_venda    AS dataVenda "
                    + "     , p.nome          AS funcionario "
                    + "     , p.cod            AS funcionarioID "
                    + "     , v.status      AS status "
                    + "FROM venda v "
                    + "INNER JOIN pessoa p "
                    + "ON p.cod = v.pessoa_cod "
                    + "INNER JOIN cliente c "
                    + "ON c.cod = v.cliente_cod ";
            
            if (nome != "") {
                sql += " WHERE c.razaosocial ILIKE '%" + nome + "%'";  
            }
            System.out.println("dataini = "+datainicio+ " datafim = "+datafim);
            System.out.println(sql);
            
            if (!datainicio.isEmpty() && !datafim.isEmpty() && datainicio.matches(".*\\d.*") && datafim.matches(".*\\d.*")) {
                sql += " AND v.data_venda BETWEEN '" + datainicio + "' AND '" + datafim + "'";
            } else {
                if (!datainicio.isEmpty()&& datainicio.matches(".*\\d.*")) {
                    sql += " AND v.data_venda >= '" + datainicio + "'";
                }
                
                if (!datafim.isEmpty()&& datafim.matches(".*\\d.*")) {
                    sql += " AND v.data_venda <= '" + datafim + "'";
                }
            }
            System.out.println(sql);
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);   
            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("cod");
                dadosTabela[lin][1] = resultadoQ.getString("cliente");
                dadosTabela[lin][2] = resultadoQ.getInt("clientecod");
                dadosTabela[lin][3] = fmt.ajustaDataDMA(resultadoQ.getString("dataVenda"));
                dadosTabela[lin][4] = resultadoQ.getString("funcionario");
                dadosTabela[lin][5] = resultadoQ.getString("funcionarioID");
                dadosTabela[lin][6] = resultadoQ.getString("status");
                
                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Status")) {
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
                    + " FROM venda";

            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            resultadoQ.next();

            return resultadoQ.getInt(1);
        } catch (Exception e) {
        }
        return 0;

    }
    
    
}
