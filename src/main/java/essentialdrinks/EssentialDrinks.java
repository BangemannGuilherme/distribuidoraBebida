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
import tela.FrmLogin;
/*import br.univates.system32.app.FatalSystemException;/*import br.univates.system32.app.FatalSystemException;
import br.univates.system32.db.DataBaseConnectionManager;
import br.univates.system32.db.DataBaseException;*/


public class EssentialDrinks {

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        if (ConexaoBD.getInstance() != null) {
            
            FrmLogin login = new FrmLogin();
            login.setVisible(true);          
            
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco!");
        }
    }

}