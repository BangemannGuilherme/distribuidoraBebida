/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.TipoProdutoDAO;
import Entidade.TipoProduto;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TipoProdutoTableModel extends AbstractTableModel {

    private List<TipoProduto> dados = new ArrayList();
    private String[] colunas = {"ID", "Marca", "Recipiente", "Volume"};

    public TipoProdutoTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            //this.dados = new TipoProdutoDAO().findAll();
            this.dados = new TipoProdutoDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new TipoProdutoDAO().findAllByDescription(busca);
            this.fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {//retorna o nome da Coluna, o java usa para noemar as colunas também!
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getId_tipo_produto();
            case 1:
                return dados.get(linha).getMarca();
            case 2:
                return dados.get(linha).getRecipiente();
            case 3:
                return dados.get(linha).getVolume();
        }

        return null;
    }

}
