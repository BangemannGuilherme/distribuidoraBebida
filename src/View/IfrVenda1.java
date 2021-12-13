/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import DAO.VendaProdutoDAO;
import Entidade.Funcionario;
import Entidade.Produto;
import Entidade.Venda;
import Entidade.VendaProduto;
import TableModel.FuncionarioTableModel;
import TableModel.ProdutoTableModel;
import TableModel.VendaTableModel;
import Utils.Calendario;
import Utils.DateUtils;
import Utils.JTableUtilities;
import Utils.Sessao;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gui
 */
public class IfrVenda1 extends javax.swing.JInternalFrame {

    JDesktopPane dskPrincipal = new JDesktopPane();
    VendaTableModel tableModel = new VendaTableModel();
    int idEntidade = 0;
    int idFuncionario = 0;
    int idVenda = 0;
    int idRQ = 0;

    public IfrVenda1() {
        initComponents();
        tblFuncionario.setModel(tableModel);
        tblFuncionario.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblFuncionario.getColumnModel().getColumn(1).setPreferredWidth(780);
        JTableUtilities.setCellsAlignment(tblFuncionario, SwingConstants.CENTER, new int[]{0, 2});
        tblFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//seleção de única linha
        FrmPrincipal frmPrincipal = new FrmPrincipal();

        //datas default
        this.dcDataInicial.setDate(new Date());
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        this.dcDataFinal.setDate(DateUtils.asDate(tomorrow));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlProduto = new javax.swing.JTabbedPane();
        pnlCadastrar = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        tfdFuncionario = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        tfdMostraId = new javax.swing.JTextField();
        lbNome1 = new javax.swing.JLabel();
        tfdQuarto = new javax.swing.JTextField();
        pnlData = new javax.swing.JPanel();
        dcDataInicial = new com.toedter.calendar.JDateChooser();
        dcDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfdValorTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfdValorDiária = new javax.swing.JTextField();
        btnBuscarQuarto = new javax.swing.JButton();
        btnBuscarFuncionario = new javax.swing.JButton();
        lblIDQuarto = new javax.swing.JTextField();
        lblIDFuncionario = new javax.swing.JTextField();
        pnlConsultar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        tfdBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setTitle("Vendas");
        setPreferredSize(new java.awt.Dimension(992, 737));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/save-30.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Campos marcados com '*' são de preenchimento obrigatório.");

        lbNome.setText("Funcionário*");

        lbCodigo.setText("Código:");

        tfdMostraId.setEditable(false);

        lbNome1.setText("Produto*");

        pnlData.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));

        jLabel2.setText("Data Inicial*");

        jLabel3.setText("Data Final*");

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel4.setText("Valor Total");

        tfdValorTotal.setEditable(false);
        tfdValorTotal.setText(" ");
        tfdValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdValorTotalActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor diária");

        tfdValorDiária.setEditable(false);
        tfdValorDiária.setText(" ");
        tfdValorDiária.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdValorDiáriaActionPerformed(evt);
            }
        });

        btnBuscarQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/search-30.png"))); // NOI18N
        btnBuscarQuarto.setText("Buscar");
        btnBuscarQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarQuartoActionPerformed(evt);
            }
        });

        btnBuscarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/search-30.png"))); // NOI18N
        btnBuscarFuncionario.setText("Buscar");
        btnBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFuncionarioActionPerformed(evt);
            }
        });

        lblIDQuarto.setEditable(false);

        lblIDFuncionario.setEditable(false);

        javax.swing.GroupLayout pnlCadastrarLayout = new javax.swing.GroupLayout(pnlCadastrar);
        pnlCadastrar.setLayout(pnlCadastrarLayout);
        pnlCadastrarLayout.setHorizontalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome)
                                    .addComponent(lbCodigo))
                                .addGap(48, 48, 48)
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                        .addComponent(lblIDFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                    .addComponent(tfdMostraId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNome1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(44, 44, 44)
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                        .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfdValorDiária, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                        .addComponent(lblIDQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
                        .addGap(149, 149, 149))
                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                        .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(677, 677, 677))))
        );
        pnlCadastrarLayout.setVerticalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(tfdMostraId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome1)
                    .addComponent(tfdQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIDQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfdValorDiária, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarLayout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        pnlProduto.addTab("Cadastrar", pnlCadastrar);

        jLabel1.setText("Buscar:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/search-30.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblFuncionario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblFuncionario);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/delete-30.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/edit-30.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConsultarLayout = new javax.swing.GroupLayout(pnlConsultar);
        pnlConsultar.setLayout(pnlConsultarLayout);
        pnlConsultarLayout.setHorizontalGroup(
            pnlConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlConsultarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConsultarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlConsultarLayout.setVerticalGroup(
            pnlConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConsultarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(pnlConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlProduto.addTab("Consultar", pnlConsultar);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/cancel-30.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProduto)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (validaCampos()) {
            VendaDAO vendaDAO = new VendaDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();
            VendaProdutoDAO rqDAO = new VendaProdutoDAO();
            Venda r = new Venda();
            VendaProduto rq = new VendaProduto();
            Integer VendaReturnOfSavedID = null;
            Integer RQReturnOfSavedID = null;
            //----------------------------------------------------
            r.setData(new Date(new Calendario().obterDataAtualDMA()));
            r.setUsuario(Sessao.getInstance().getUsuario().getId());
            r.setValorTotal(Double.parseDouble(this.tfdValorTotal.getText()));//verificar depois
            r.setEntidade(new FuncionarioDAO().findById(Integer.parseInt(lblIDFuncionario.getText())).getIdEntidade());
            if (idVenda == 0) {
                VendaReturnOfSavedID = vendaDAO.save(r);
                if (VendaReturnOfSavedID != null) {
                    //JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    //limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String retorno = vendaDAO.update(r);
                if (retorno == null) {
                    //JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    this.idVenda = 0;
                    // limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar venda\nMensagem técnica: " + retorno, "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            }
            //-------------------------------------------------------------
            //PK's
            rq.setId(vendaDAO.findById(VendaReturnOfSavedID));//id da venda
            rq.setProduto(produtoDAO.findById(Integer.parseInt(lblIDProduto.getText())));//id produto
            //###################################################
            rq.setDataInicio(dcDataInicial.getDate());
            rq.setDataFim(dcDataFinal.getDate());
            if (idRQ == 0) {
                rqDAO.saveD(rq);
                if (VendaReturnOfSavedID != null) {//alterar comparação
                    JOptionPane.showMessageDialog(null, "Venda de produto cadastrada com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    //limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda de produto", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String retorno = rqDAO.update(rq);
                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Venda de produto atualizada com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    this.idRQ = 0;
                    //limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar venda de produto\nMensagem técnica: " + retorno, "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.tableModel.updateData(tfdBuscar.getText());
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tfdValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdValorTotalActionPerformed

    private void tfdValorDiáriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdValorDiáriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdValorDiáriaActionPerformed

    private void btnBuscarQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarQuartoActionPerformed
        // ABRE A JANELA DE BUSCAR UM QUARTO PARA REGISTRO DA RESERVA
        ProdutoTableModel tableModel = new ProdutoTableModel();
        DlgSelecionaObjeto dlgso = new DlgSelecionaObjeto(this, true, "Produto", tableModel);
        dlgso.setVisible(true);
    }//GEN-LAST:event_btnBuscarQuartoActionPerformed

    private void btnBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFuncionarioActionPerformed
        // ABRE A JANELA DE BUSCAR UMA PESSOA PARA REGISTRO DA RESERVA
        FuncionarioTableModel tableModel = new FuncionarioTableModel();
        DlgSelecionaObjeto dlgso = new DlgSelecionaObjeto(this, true, "Funcionario Física", tableModel);
        dlgso.setVisible(true);
    }//GEN-LAST:event_btnBuscarFuncionarioActionPerformed
    public void setFields(Produto q) {
        this.lblIDProduto.setText(q.getId_produto() + "");
        this.tfdProduto.setText(q.getNr_produto());
        this.tfdValorDiária.setText(q.getId_tipo_produto().getVl_venda() + "");
        int dias = DateUtils.getDaysBetweenDates(DateUtils.asLocalDate(this.dcDataInicial.getDate()),
                DateUtils.asLocalDate(this.dcDataFinal.getDate()));
        double valorTotal = dias * (q.getId_tipo_produto().getVl_venda());
        this.tfdValorTotal.setText(valorTotal + "");

    }
    public void setFields(Funcionario pf) {
        this.lblIDFuncionario.setText(pf.getId() + "");
        this.tfdFuncionario.setText(pf.getNome());
    }

    private void limpaCampos() {
//        tfdFuncionario.setText("");
//        
//        tfdDataNascimento.setText("");
//        tfdRg.setText("");
//        tfdCpf.setText("");
//        tfdBairro.setText("");
//        tfdEndereco.setText("");
//        tfdTelefone.setText("");
//        tfdCelular.setText("");
//        jcbSexo.setSelectedIndex(0);
//        tfdEmail.setText("");
    }

    private boolean validaCampos() {
        boolean valido = true;
//        if (tfdFuncionario.getText().length() == 0
//                || Formatacao.removerFormatacao(tfdDataNascimento.getText()).length() == 0
//                || tfdRg.getText().length() == 0
//                || tfdCpf.getText().length() == 0
//                || tfdBairro.getText().length() == 0
//                || tfdEndereco.getText().length() == 0
//                || tfdTelefone.getText().length() == 0
//                || tfdCelular.getText().length() == 0
//                || tfdEmail.getText().length() == 0) {
//            valido = false;
//            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios.", "Verifique os campos!", JOptionPane.WARNING_MESSAGE);
//        }
        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarFuncionario;
    private javax.swing.JButton btnBuscarQuarto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private com.toedter.calendar.JDateChooser dcDataFinal;
    private com.toedter.calendar.JDateChooser dcDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JTextField lblIDFuncionario;
    private javax.swing.JTextField lblIDQuarto;
    private javax.swing.JPanel pnlCadastrar;
    private javax.swing.JPanel pnlConsultar;
    private javax.swing.JPanel pnlData;
    private javax.swing.JTabbedPane pnlProduto;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField tfdBuscar;
    private javax.swing.JTextField tfdFuncionario;
    private javax.swing.JTextField tfdMostraId;
    private javax.swing.JTextField tfdQuarto;
    private javax.swing.JTextField tfdValorDiária;
    private javax.swing.JTextField tfdValorTotal;
    // End of variables declaration//GEN-END:variables
}
