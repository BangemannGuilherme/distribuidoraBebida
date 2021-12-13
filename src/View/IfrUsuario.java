/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.UsuarioDAO;
import Entidade.Usuario;
import TableModel.UsuarioTableModel;
import Utils.AES;
import Utils.DateUtils;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author evand
 */
public class IfrUsuario extends javax.swing.JInternalFrame {

    UsuarioTableModel tableModel = new UsuarioTableModel();
    int id = 0;

    public IfrUsuario() {
        initComponents();
        tblUsuario.setModel(tableModel);
        tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(780);
        tblUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//seleção de única linha

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlUsuario = new javax.swing.JTabbedPane();
        pnlCadastrar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdMostraId = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfdLogin = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfdPessoa = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbPermissao = new javax.swing.JComboBox<>();
        pnlConsultar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        tfdBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setResizable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(992, 737));

        jLabel2.setText("Código:");

        jLabel3.setText("Login: *");

        tfdMostraId.setEditable(false);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/save-30.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Campos marcados com '*' são de preenchimento obrigatório.");

        jLabel6.setText("Senha: *");

        jLabel4.setText("Funcionário: *");

        jLabel7.setText("Permissão: *");

        jcbPermissao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuário" }));

        javax.swing.GroupLayout pnlCadastrarLayout = new javax.swing.GroupLayout(pnlCadastrar);
        pnlCadastrar.setLayout(pnlCadastrarLayout);
        pnlCadastrarLayout.setHorizontalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                        .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addComponent(tfdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196))
                            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdMostraId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfdLogin)
                                    .addComponent(jpfSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jcbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlCadastrarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlCadastrarLayout.setVerticalGroup(
            pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdMostraId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tfdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcbPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tfdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addGroup(pnlCadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        pnlUsuario.addTab("Cadastrar", pnlCadastrar);

        jLabel1.setText("Buscar:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/search-30.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblUsuario);

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
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
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
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlUsuario.addTab("Consultar", pnlConsultar);

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
            .addComponent(pnlUsuario)
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
                .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaCampos()) {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = new Usuario();
            u.setId_usuario(id);
            u.setLogin(tfdLogin.getText());
            u.setSenha(AES.encrypt(jpfSenha.getText(), "EASY"));
            LocalDate currentDate = LocalDate.now();
            u.setDt_criacao(DateUtils.asDate(currentDate));
            u.setDt_alteracao_senha(DateUtils.asDate(currentDate));
            u.setId_funcionario(Integer.parseInt(tfdPessoa.getText()));
            u.setSituacao('A');
            
            if (jcbPermissao.getSelectedIndex() == 0){ // Administrador
                u.setPermissao(0);
            }else if (jcbPermissao.getSelectedIndex() == 1){ //Usuário
                u.setPermissao(1);
            }
            if (id == 0) {
                Integer returnOfSavedID = dao.save(u);//ID recem adicionado pronto para ser usado em outro local
                if (returnOfSavedID != null) {
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário", "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String retorno = dao.update(u);
                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                    this.id = 0;
                    limpaCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário\nMensagem técnica: " + retorno, "ERRO!", JOptionPane.ERROR_MESSAGE);
                }
            }
            this.tableModel.updateData("");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.tableModel.updateData(tfdBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblUsuario.getSelectedRow() != -1) {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.findById((int) tableModel.getValueAt(tblUsuario.getSelectedRow(), 0));
            u.setSituacao('I'); //INATIVANDO
            String retorno = dao.update(u);
            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso", "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                this.tableModel.updateData("");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir usuário\nMensagem técnica: " + retorno, "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para Excluir.", "Verifique a seleção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblUsuario.getSelectedRow() != -1) {
            this.id = (int) tableModel.getValueAt(tblUsuario.getSelectedRow(), 0);
            tfdMostraId.setText(String.valueOf(id));
            tfdLogin.setText(String.valueOf(tableModel.getValueAt(tblUsuario.getSelectedRow(), 1)));
            jpfSenha.setText("");
            tfdPessoa.setText(String.valueOf(tableModel.getValueAt(tblUsuario.getSelectedRow(), 2)));

            //retorna à aba de cadastro
            pnlUsuario.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para Editar.", "Verifique a seleção!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (pnlUsuario.getSelectedIndex() == 0) {
            limpaCampos();
        } else {
            pnlUsuario.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void limpaCampos() {
        tfdMostraId.setText("");
        tfdLogin.setText("");
        jpfSenha.setText("");
        tfdPessoa.setText("");
        tfdLogin.requestFocus();
    }

    private boolean validaCampos() {
        boolean valido = true;
        if (tfdLogin.getText().length() == 0 || jpfSenha.getText().length() == 0 || tfdPessoa.getText().length() == 0) {
            valido = false;
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios.", "Verifique os campos!", JOptionPane.WARNING_MESSAGE);
        } 
        
        return valido;
    }
    
    public void definirValoresPessoa(String id) {
        tfdPessoa.setText(id);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbPermissao;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JPanel pnlCadastrar;
    private javax.swing.JPanel pnlConsultar;
    private javax.swing.JTabbedPane pnlUsuario;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField tfdBuscar;
    private javax.swing.JFormattedTextField tfdLogin;
    private javax.swing.JTextField tfdMostraId;
    private javax.swing.JFormattedTextField tfdPessoa;
    // End of variables declaration//GEN-END:variables
}
