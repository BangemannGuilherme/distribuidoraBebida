/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essentialdrinks;

/**
 *
 * @author Gui
 */
import apoio.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;
import tela.FrmJanelaPrincipal;
import tela.IfrLogin;
import tela.Login;
/*import br.univates.system32.app.FatalSystemException;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;*/


public class EssentialDrinks {
    
    /*public void defineFirstExecutionProcesses()
    {
        this.addFirstExecutionProcess(new ApplicationProcess("Criando o esquema do banco de dados...")
        {
            @Override
            public void run() throws FatalSystemException
            {
                createDataBaseSchemaGenerationProcess("/resources/energyware_postgres.sql");
            }
        });
    }*/
    
    /*public static void main(String[] args) {
        if (abrirConexao()) {
            
            new Login().setVisible(true);
             } else {
                JOptionPane.showMessageDialog(null, "Errrroouuuu");            
            }
        // TODO code application logic here
    }
    private static boolean abrirConexao () {
       try {
           String dbdriver = "org.postgresql.Driver";
           String dburl = "jdbc:postgresql://localhost:5432/energyware";
           String dbuser = "postgres";
           String dbsenha = "postgres";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
               Connection conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
               Connection conexao = DriverManager.getConnection(dburl);
            }

            return true;

       } catch (Exception e) {
           System.err.println("Erro ao tentar conectar: " + e);
           return false;
        }
    }*/

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        if (ConexaoBD.getInstance() != null) {
            
            Login login = new Login();
            login.setVisible(true);          
            
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco!");
        }
    }

}