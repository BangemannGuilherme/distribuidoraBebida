package dao;

import apoio.ConexaoBD;
import entidade.Login;
import java.util.ArrayList;
import apoio.IDAOT;
import apoio.ConvertPasswordToMD5;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class LoginDAO implements IDAOT <Login> {
     ConvertPasswordToMD5 md5 = new ConvertPasswordToMD5();
    private ResultSet resultadoQ = null;
    @Override
    public boolean salvar(Login o) {
         try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String senhaMd5 = md5.getMd5(o.getSenha());
         
            String sql = "";
            if (o.getId() == 0) {
                sql = "INSERT INTO login VALUES ( "
                        + "default, " 
                        + "'" + o.getUsuario() + "', "
                        + "'" + senhaMd5 + "', "
                        + ")";
            } else {
                sql = "UPDATE login "
                        + "SET usuario = '" + o.getUsuario() + "' "
                        + ",senha = '" + senhaMd5+ "' "
                        + "WHERE id = " + o.getId();
            }/*
                sql = "INSERT INTO login  (id, usuario, email, usuario, senha, cpf) VALUES ('"
                         + "default, " + "','" + o.getUsuario() + "','" + o.getEmail()+"','" + o.getUsuario()+"','" + senhaMd5+"','" + o.getCpf()+"')";
            }*/

            System.out.println("SQL: " + sql);

            int resultadoQ = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro salvar inserção = " + e);
            return false;
        }
    }
    
    public boolean logar(Login o){
          try {
            
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
           
            String senhaMd5 = md5.getMd5(o.getSenha());
              System.out.println(senhaMd5);
            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE usuario = '" + o.getUsuario() + "'AND senha = '" + senhaMd5 + "'";

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                 return true;
            }else{
                 return false;
            }
           
        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
            return false;
        }
    }

    @Override
    public boolean atualizar(Login o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String senhaMd5 = md5.getMd5(o.getSenha());
         
            String sql = "";
            if (o.getId() == 0) {
                sql = "UPDATE login "
                        + "SET usuario = '" + o.getUsuario() + "' "
                        + ",senha = '" + senhaMd5+ "' "
                        + "WHERE id = " + o.getId();
            } else {
                sql = "INSERT INTO login VALUES ( "
                        + "default, " 
                        + "'" + o.getUsuario() + "', "
                        + "'" + senhaMd5 + "', "
                        + ")";
            }
                        System.out.println("SQL: " + sql);

            int resultadoQ = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro atualizar inserção = " + e);
            return false;
        }
    }

    @Override
    public boolean excluir(int id) {
       try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE "
                    + "FROM login "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta - exclusao
            int resultadoQ = st.executeUpdate(sql);

            return true;

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Login> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Login> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login consultarId(int id) {
       Login login = null; //= new Apresentacao();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM login "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            // executa consulta
            resultadoQ = st.executeQuery(sql);

            // avanca ResultSet
            if (resultadoQ.next()) {
                login = new Login();

                // obtem dados do RS
                login.setId(resultadoQ.getInt("id"));
                login.setUsuario(resultadoQ.getString("usuario"));
                login.setSenha(resultadoQ.getString("senha"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return login;
    }
     public void popularTabela(JTable tabela, String criterio) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "id";
        cabecalho[1] = "usuario";
        cabecalho[2] = "senha";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM login "
                    + "WHERE "
                    + "usuario ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM login "
                    + "WHERE "
                    + "usuario ILIKE '%" + criterio + "%'");

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("usuario");
                dadosTabela[lin][2] = resultadoQ.getString("senha");

                      

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
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
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
                    setBackground(Color.GREEN);
                } else {
                    setBackground(Color.LIGHT_GRAY);
                }
                return this;
            }
        });*/
    }
    
    
    
}
