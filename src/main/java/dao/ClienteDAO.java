package dao;

import apoio.ConexaoBD;
import entidade.Cliente;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import apoio.IDAOT;

/**
 *
 *
 */
public class ClienteDAO implements IDAOT <Cliente>{

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getId() == 0) {
                sql = "INSERT INTO cliente VALUES ( "
                        + "default, " 
                        + "'" + o.getRazaoSocial() + "', " 
                        + "'" + o.getCnpj()+ "', "
                        + "'" + o.getTelefone()+ "', "
                        + "'" + o.getEmail()+ "'"
                        + ")";
            } else {
                sql = "UPDATE cliente "
                        + "SET razaosocial = '" + o.getRazaoSocial() + "' "
                        + ",cnpj = '" + o.getCnpj() + "' "
                        + ",telefone = '" + o.getTelefone() + "' "
                        + ",email = '" + o.getEmail() + "' "
                        + "WHERE id = " + o.getId();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar apresentação = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM cliente "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultarId(int id) {
        Cliente cliente = null; //= new Apresentacao();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                cliente = new Cliente();

                // obtem dados do RS
                cliente.setId(resultadoQ.getInt("id"));
                cliente.setRazaoSocial(resultadoQ.getString("razaosocial"));
                cliente.setCnpj(resultadoQ.getString("cnpj"));
                cliente.setTelefone(resultadoQ.getString("telefone"));
                cliente.setEmail(resultadoQ.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return cliente;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "ID";
        cabecalho[1] = "RazaoSocial";
        cabecalho[2] = "Cnpj";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "Email";


        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM cliente "
                    + "WHERE "
                    + "razaosocial ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM cliente "
                    + "WHERE "
                    + "razaosocial ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {
                System.out.println(resultadoQ.getString("razaosocial"));
                dadosTabela[lin][0] = resultadoQ.getString("id");
                dadosTabela[lin][1] = resultadoQ.getString("razaosocial");
                dadosTabela[lin][2] = resultadoQ.getString("cnpj");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("email");

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
//                    return ImageIcon.class;
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
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(100);
                    break;
                case 2:
                    column.setPreferredWidth(54);
                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
        /*tabela.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.RED);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });*/
    }
}
