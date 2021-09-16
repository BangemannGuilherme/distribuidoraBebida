/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Calendario;
import apoio.Formatacao;
import apoio.Validacao;
import dao.VendaDAO;
import entidade.Cliente;
import entidade.VendaItens;
import entidade.Venda;
import apoio.Formatacao;
import apoio.Validacao;
import dao.VendaItensDAO;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gui
 */
public class IfrVenda extends javax.swing.JInternalFrame {

    int cod_venda = 0;
    float valortotal = 0;
    int cod_it = 0;
    /**
     * Creates new form IfrVenda
     */
    public IfrVenda() {
        initComponents();
        Formatacao.formatarData(tffDataVenda);
        tffDataVenda.setText(new Calendario().obterDataAtualDMA());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCliente = new javax.swing.JLabel();
        tfdCliente = new javax.swing.JTextField();
        lblCodcliente = new javax.swing.JLabel();
        tfdCodcliente = new javax.swing.JTextField();
        btnPesquisarCliente = new javax.swing.JButton();
        lblDataVenda = new javax.swing.JLabel();
        tffDataVenda = new javax.swing.JFormattedTextField();
        lblPessoa = new javax.swing.JLabel();
        tfdPessoa = new javax.swing.JTextField();
        lblCodPessoa = new javax.swing.JLabel();
        tfdCodpessoa = new javax.swing.JTextField();
        btnPesquisarPessoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscarProduto = new javax.swing.JTable();
        btnGerar = new javax.swing.JButton();
        btnPesquisarVenda = new javax.swing.JButton();
        lblProduto = new javax.swing.JLabel();
        lblCodproduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblValorProduto = new javax.swing.JLabel();
        lblQuantidade3 = new javax.swing.JLabel();
        tfdCodigoProduto = new javax.swing.JTextField();
        tfdQuantidade = new javax.swing.JTextField();
        tfdDescricao = new javax.swing.JTextField();
        btnPesquisarProduto = new javax.swing.JButton();
        tfdValorProduto = new javax.swing.JTextField();
        btnAdicionarProduto = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        tfdValorTotal = new javax.swing.JTextField();
        lblObs = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnSalvarItens = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Venda");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCliente.setText("Cliente*");

        tfdCliente.setEditable(false);

        lblCodcliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodcliente.setText("Código*");

        tfdCodcliente.setEditable(false);

        btnPesquisarCliente.setText("Pesquisar");
        btnPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarClienteActionPerformed(evt);
            }
        });

        lblDataVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataVenda.setText("Data Venda*");

        lblPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPessoa.setText("Pessoa*");

        tfdPessoa.setEditable(false);

        lblCodPessoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodPessoa.setText("Código*");

        tfdCodpessoa.setEditable(false);

        btnPesquisarPessoa.setText("Pesquisar");
        btnPesquisarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPessoaActionPerformed(evt);
            }
        });

        tblBuscarProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Produto", "Quantidade", "Valor Produto", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tblBuscarProduto);

        btnGerar.setText("Gerar/Atualizar Venda");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });

        btnPesquisarVenda.setText("Pesquisar Venda Existente");
        btnPesquisarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarVendaActionPerformed(evt);
            }
        });

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblProduto.setText("Produto");

        lblCodproduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodproduto.setText("Código*");

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade*");

        lblValorProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorProduto.setText("Valor");

        lblQuantidade3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade3.setText("Descrição*");

        tfdCodigoProduto.setEditable(false);

        tfdDescricao.setEditable(false);

        btnPesquisarProduto.setText("Pesquisar");
        btnPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdutoActionPerformed(evt);
            }
        });

        tfdValorProduto.setEditable(false);

        btnAdicionarProduto.setText("Adicionar");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValor.setText("Valor Total");

        tfdValorTotal.setEditable(false);

        lblObs.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblObs.setText("*Obs: Preencha os Campos Obrigatórios!");

        btnFechar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvarItens.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnSalvarItens.setText("Salvar");
        btnSalvarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarItensActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnReset.setText("Nova Venda");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblObs)
                                .addGap(31, 31, 31)
                                .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(btnSalvarItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblValor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdValorTotal)
                            .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tffDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCliente)
                                        .addGap(43, 43, 43)
                                        .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                                .addComponent(lblCodcliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdCodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblPessoa)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblCodPessoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfdCodpessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnPesquisarVenda))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPesquisarPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuantidade)
                                    .addComponent(lblCodproduto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdCodigoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(tfdQuantidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuantidade3)
                                    .addComponent(lblValorProduto))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAdicionarProduto))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(lblProduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(tfdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodcliente)
                    .addComponent(tfdCodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCliente))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataVenda)
                    .addComponent(tffDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPessoa)
                    .addComponent(tfdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodPessoa)
                    .addComponent(tfdCodpessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisarVenda)
                    .addComponent(btnGerar))
                .addGap(41, 41, 41)
                .addComponent(lblProduto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodproduto)
                    .addComponent(tfdCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade3)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarProduto))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorProduto)
                    .addComponent(tfdValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarProduto)
                    .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObs)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvarItens)
                    .addComponent(btnReset)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarClienteActionPerformed
        DlgBuscaCliente dlgBuscaCliente = new DlgBuscaCliente(null, true, this);
        dlgBuscaCliente.setVisible(true);
        // new DlgBuscaCliente(this ,true).setVisible(true);
    }//GEN-LAST:event_btnPesquisarClienteActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarItensActionPerformed
        if (tblBuscarProduto.getRowCount() > 0){
            DlgSalvarFinanceiro dlgSalvarFinanceiro = new DlgSalvarFinanceiro(null, true, this);
            dlgSalvarFinanceiro.setVisible(true);
            dlgSalvarFinanceiro.definirValorTotal(tfdValorTotal.getText(), new VendaDAO().ultimoIDInserido());
        } else {
            JOptionPane.showMessageDialog(null, "Crie ou selecione uma venda para continuar!");
        }
    }//GEN-LAST:event_btnSalvarItensActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        Venda venda = new Venda();
        tfdCliente.setText("");
        tfdCodcliente.setText("");
        tffDataVenda.setText("");
        tfdCodpessoa.setText("");
        tfdPessoa.setText("");
        valortotal = 0;
        tfdValorTotal.setText("");
        tfdValorProduto.setText("");
        tfdCodigoProduto.setText("");
        tfdQuantidade.setText("");
        tfdDescricao.setText("");
        venda.setCod(0);
        new VendaItensDAO().popularTabela(tblBuscarProduto, null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int cod = Integer.parseInt(String.valueOf(tblBuscarProduto.getValueAt(tblBuscarProduto.getSelectedRow(), 0)));
        VendaItensDAO leDAO = new VendaItensDAO();
        leDAO.excluir(cod);
        new VendaItensDAO().popularTabela(tblBuscarProduto, Integer.toString(cod_venda));
        float valor;
        valortotal = 0;
        for (int i = 0; i < tblBuscarProduto.getRowCount(); i++) {
            valor = Float.parseFloat(String.valueOf(tblBuscarProduto.getValueAt(i, 4)));
            valortotal = (valortotal + valor);
        }
        tfdValorTotal.setText("" + valortotal);    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPessoaActionPerformed
        DlgBuscaPessoa dlgPesquisarFuncionario = new DlgBuscaPessoa(null, true, this);
        dlgPesquisarFuncionario.setVisible(true);
    }//GEN-LAST:event_btnPesquisarPessoaActionPerformed

    public void apagarDados() {
        Venda venda = new Venda();
        tfdCliente.setText("");
        tfdCodcliente.setText("");
        tffDataVenda.setText("");
        tfdCodpessoa.setText("");
        tfdPessoa.setText("");
        valortotal = 0;
        tfdValorProduto.setText("");
        tfdCodigoProduto.setText("");
        tfdQuantidade.setText("");
        tfdDescricao.setText("");
        venda.setCod(0);

    }
    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        // Populando o objeto 
        try {
        Venda venda = new Venda();   
        venda.setCod(cod_venda);
        venda.setData_venda(tffDataVenda.getText());
        venda.setStatus('a');
        venda.setPessoa_cod(tfdCodpessoa.getText());
        venda.setCliente_cod(tfdCodcliente.getText());
        
        // Criando a instancia do ItemDAO
        VendaDAO vendaDAO = new VendaDAO();

        // Salvando registro

        if (tfdCliente.getText().equals("") || tfdCodcliente.getText().equals("") || tffDataVenda.getText().equals("") || tfdPessoa.getText().equals("") || tfdCodpessoa.equals("") || Validacao.validarDataFormatada(tffDataVenda.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Data invalida ou os campos obrigatorios não foram preenchidos!");
            btnPesquisarCliente.requestFocus();
            tfdCliente.setText("");
            tfdCodcliente.setText("");
            tffDataVenda.setText("");
            tfdPessoa.setText("");
            tfdCodpessoa.setText("");
            btnPesquisarCliente.requestFocus();
            
        } else {
                cod_venda = Integer.parseInt(vendaDAO.salvar(venda));
                System.out.println("ID venda" + cod_venda);
                JOptionPane.showMessageDialog(null, "Venda/Atualizada com sucesso!");
                // posiciona cursor
                btnPesquisarProduto.requestFocus();
                btnPesquisarVenda.setEnabled(false);
        }



        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida ou os campos obrigatorios não foram preenchidos!");
            tfdCliente.setText("");
            tfdCodcliente.setText("");
            tffDataVenda.setText("");
            tfdPessoa.setText("");
            tfdCodpessoa.setText("");
            btnPesquisarCliente.requestFocus();
            

        }

        /*String retorno = null;
        if (venda.getId() == 0) {
            retorno = vendaDAO.salvar(venda);
        } else {
            retorno = vendaDAO.atualizar(venda);
        }


        if (retorno == null) {
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");'
            System.out.println(retorno);

            id_venda= 0;
            
        } else {
            JOptionPane.showMessageDialog(null, "Problemas ao salvar registro!\n\n"
                    + "Mensagem técnica:\n"
                    + "Erro: " + retorno);
        }
        } 
      } catch (Exception e) {
          
      }*/
    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnPesquisarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarVendaActionPerformed
        DlgBuscaVenda dlgBuscaVenda = new DlgBuscaVenda(null, true, this);
        dlgBuscaVenda.setVisible(true);
    }//GEN-LAST:event_btnPesquisarVendaActionPerformed

    private void btnPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdutoActionPerformed
        DlgBuscaProduto dlgBuscaItem = new DlgBuscaProduto(null, true, this);
        dlgBuscaItem.setVisible(true);
    }//GEN-LAST:event_btnPesquisarProdutoActionPerformed

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        if (!tfdCliente.getText().isEmpty() && !tfdCodcliente.getText().isEmpty() && !tffDataVenda.getText().isEmpty() && !tfdPessoa.getText().isEmpty() && !tfdCodpessoa.getText().isEmpty()) {
        int idz;
        VendaItensDAO vi = new VendaItensDAO();
        VendaItens vendaitens = new VendaItens();
        Venda venda = new Venda();
        if ("".equals(tfdQuantidade.getText()) || "".equals(tfdCodigoProduto.getText()) || "".equals(tfdDescricao.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos Obrigatórios!");
        } else if (Validacao.validaNumero(tfdQuantidade.getText())) {

            //DecimalFormat f = new DecimalFormat("#.00");

            int codven = venda.getCod();
            String cod = tfdCodigoProduto.getText().trim();
            String descricao = tfdDescricao.getText().trim();
            String quantidade = tfdQuantidade.getText();

            float valor1 = Float.parseFloat(tfdValorProduto.getText());
            int quantidade1 = Integer.parseInt(tfdQuantidade.getText());
            float result = (valor1 * quantidade1);

            valortotal = (result + valortotal);
            tfdValorTotal.setText(Float.toString(valortotal));

            System.out.println("ID venda:" + cod_venda);
            System.out.println("ID item = " + cod_it);
            vendaitens.setCod(cod_it);
            vendaitens.setProduto_cod(Integer.parseInt(tfdCodigoProduto.getText()));
            vendaitens.setQuantidade(Integer.parseInt(tfdQuantidade.getText()));
            vendaitens.setVenda_cod(cod_venda);
            vendaitens.setValor_venda(Float.parseFloat(tfdValorTotal.getText()));

            JOptionPane.showMessageDialog(null, vi.salvar(vendaitens));

            DefaultTableModel val = (DefaultTableModel) tblBuscarProduto.getModel();
            //f.format(result);
            System.out.println("result =" + result);
            System.out.println("cod itm = " + vendaitens.getCod());
            val.addRow(new String[]{(Integer.toString(vi.ultimoIDInserido())), descricao, quantidade, Float.toString(valor1) ,Float.toString(result)});
            System.out.println("OK");
           /* System.out.println("ID = "+cod);
            System.out.println("Quantidade = " +quantidade);
            System.out.println("Descrição = "+descricao);
            System.out.println("Result = "+Double.toString(result)); 
            */

            tfdCodigoProduto.setText("");
            tfdDescricao.setText("");
            tfdQuantidade.setText("");
            tfdValorProduto.setText("");

            tfdDescricao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
        System.out.println("cod itm = " + vendaitens.getCod());
      } else {
            JOptionPane.showMessageDialog(null, "Para adicionar itens você precisa gerar uma venda ou selecionar uma existente!!");
            tfdCodigoProduto.setText("");
            tfdDescricao.setText("");
            tfdQuantidade.setText("");
            tfdValorProduto.setText("");
            btnPesquisarCliente.requestFocus();
        }
        
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    /*private void DefinirItens (Cliente c) {
        tfdCliente.setText(c.getRazao_social());
        tfdCodcliente.setText(c.getId()+"");
        
    }*/
    
    public void definirProduto(String cod, String descricao, String valor) {
        tfdCodigoProduto.setText(cod);
        tfdDescricao.setText(descricao);
        tfdValorProduto.setText(valor);

        tfdQuantidade.requestFocus();
    }
   
   // define valores para codigo, razão social e endereço do Cliente
   public void definirCliente(String cod, String razao_social) {
        tfdCodcliente.setText(cod); 
        tfdCliente.setText(razao_social);
        tffDataVenda.requestFocus();
    }
   // define valores para codigo e nome do funcionario
    public void definirFuncionario(String cod, String nome) {
        tfdPessoa.setText(nome);
        tfdCodpessoa.setText(cod);

        btnGerar.requestFocus();
    }
    
        public void definirVenda(String cod, String cliente, String clientecod, String datavenda, String pessoanome, String pessoacod, String statusvenda) {
        tfdCliente.setText(cliente);
        tfdCodcliente.setText(clientecod);
        tffDataVenda.setText(datavenda);
        tfdPessoa.setText(pessoanome);
        tfdCodpessoa.setText(pessoacod);
        valortotal = 0;
        tfdValorTotal.setText("0.00");
        
        cod_venda = Integer.parseInt(cod);
        new VendaItensDAO().popularTabela(tblBuscarProduto, cod);
        float valor;
        for (int i = 0; i < tblBuscarProduto.getRowCount(); i++) {
            valor = Float.parseFloat(String.valueOf(tblBuscarProduto.getValueAt(i, 4)));
            valortotal = (valortotal + valor);
            tfdValorTotal.setText("" + valortotal);
        }

        btnGerar.requestFocus();
    }
        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnPesquisarCliente;
    private javax.swing.JButton btnPesquisarPessoa;
    private javax.swing.JButton btnPesquisarProduto;
    private javax.swing.JButton btnPesquisarVenda;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSalvarItens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodPessoa;
    private javax.swing.JLabel lblCodcliente;
    private javax.swing.JLabel lblCodproduto;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblQuantidade3;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorProduto;
    private javax.swing.JTable tblBuscarProduto;
    private javax.swing.JTextField tfdCliente;
    private javax.swing.JTextField tfdCodcliente;
    private javax.swing.JTextField tfdCodigoProduto;
    private javax.swing.JTextField tfdCodpessoa;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdPessoa;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField tfdValorProduto;
    private javax.swing.JTextField tfdValorTotal;
    private javax.swing.JFormattedTextField tffDataVenda;
    // End of variables declaration//GEN-END:variables
}
