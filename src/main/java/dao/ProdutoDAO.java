package dao;

import apoio.ConexaoBD;
import entidade.Produto;
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
public class ProdutoDAO implements IDAOT <Produto>{

    private ResultSet resultadoQ = null;

    @Override
    public boolean salvar(Produto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";
            if (o.getCod() == 0) {
                sql = "INSERT INTO produto VALUES ( "
                        + "default, " 
                        + "'" + o.getNome() + "', " 
                        + "'" + o.getMarca()+"', " 
                        + "'" + o.getRecipiente() + "', "
                        + "'" + o.getVolume() + "', "
                        + "'" + o.getValor() + "'"
                        + ")";
            } else {
                sql = "UPDATE produto "
                        + "SET nome = '" + o.getNome() + "' "
                        + ",marca = '" + o.getMarca() + "' "
                        + ",recipiente = '" + o.getRecipiente() + "' "
                        + ",volume = '" + o.getVolume() + "' "
                        + ",valor = '" + o.getValor() + "' "
                        + "WHERE cod = " + o.getCod();
            }

            System.out.println("SQL: " + sql);

            int resultado = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro salvar apresentação = " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(int cod) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM produto "
                    + "WHERE cod = " + cod;

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
    public ArrayList<Produto> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto consultarId(int cod) {
        Produto energy = null; //= new Apresentacao();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM produto "
                    + "WHERE cod = " + cod;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                energy = new Produto();

                // obtem dados do RS
                energy.setCod(resultadoQ.getInt("cod"));
                energy.setNome(resultadoQ.getString("nome"));
                energy.setMarca(resultadoQ.getString("marca"));
                energy.setRecipiente(resultadoQ.getString("recipiente"));
                energy.setVolume(resultadoQ.getString("volume"));
                energy.setValor(resultadoQ.getString("valor"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return energy;
    }

    public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Marca";
        cabecalho[3] = "Recipiente";
        cabecalho[4] = "Volume";
        cabecalho[5] = "Valor";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM produto "
                    + "WHERE "
                    + "marca ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM produto "
                    + "WHERE "
                    + "marca ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {
                System.out.println(resultadoQ.getString("marca"));
                dadosTabela[lin][0] = resultadoQ.getString("cod");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("marca");
                dadosTabela[lin][3] = resultadoQ.getString("recipiente");
                dadosTabela[lin][4] = resultadoQ.getString("volume");
                dadosTabela[lin][5] = resultadoQ.getString("valor");
               

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
