/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import DAO.VendaDAO;
import Entidade.Venda;
import Utils.Formatacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gui
 */
public class VendaTableModel extends AbstractTableModel {

    private List<Venda> dados = new ArrayList<>();
    private String[] colunas = {"ID", "Cliente", "Funcionário", "Data"};

    public VendaTableModel() {
        updateData("");
    }

    public void updateData(String busca) {
        if (busca.equals("")) {
            this.dados = new VendaDAO().findAll();
            this.fireTableDataChanged();
        } else {
            this.dados = new VendaDAO().findAllByDescription(busca);
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
                return dados.get(linha).getId_venda();
            case 1:
                return dados.get(linha).getId_cliente();
            case 2:
                return dados.get(linha).getId_funcionario();
            case 3:
                return Formatacao.ajustaDataDMA(dados.get(linha).getDt_venda().toString());
        }

        return null;
    }
}
