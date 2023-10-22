/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TecnicoController;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Tecnico;
import model.exceptions.TecnicoException;

/**
 *
 * @author diego
 */
public class dlgCadastrarTecnico extends javax.swing.JDialog{
    TecnicoController tecnicoController;
    Long idTecnicoEditando;


    /**
     * Creates new form dlgCadastroServico
     */
    public dlgCadastrarTecnico(java.awt.Dialog parent) {
        super(parent);
        tecnicoController = new TecnicoController();
        idTecnicoEditando = -1L;
        initComponents();
        this.criarMascaraCadastros();
        this.habilitarCampos(false);
        this.limparCampos();
        this.setModal(true);
        tecnicoController.atualizarTabela(grdTecnicos);
        setDefaultCloseOperation(dlgCadastrarTecnico.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panTitulo = new javax.swing.JPanel();
        lblTitulo6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdTecnicos = new javax.swing.JTable();
        panFormulario = new javax.swing.JPanel();
        fEdtSalario = new javax.swing.JFormattedTextField();
        fEdtTelefone = new javax.swing.JFormattedTextField();
        fEdtEmail = new javax.swing.JFormattedTextField();
        fEdtCpf = new javax.swing.JFormattedTextField();
        fEdtDataNasc = new javax.swing.JFormattedTextField();
        lblDataNasc = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setResizable(false);

        lblTitulo6.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo6.setText("Cadastrar tecnico");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo6, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        grdTecnicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdTecnicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdTecnicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdTecnicos);

        fEdtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fEdtEmailActionPerformed(evt);
            }
        });

        fEdtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fEdtDataNascActionPerformed(evt);
            }
        });

        lblDataNasc.setText("Nasc:");

        lblEmail.setText("Email:");

        lblTelefone.setText("Telefone:");

        lblCpf.setText("CPF:");

        lblNome.setText("Nome:");

        lblSalario.setText("Salario:");

        lblSenha.setText("Senha:");

        javax.swing.GroupLayout panFormularioLayout = new javax.swing.GroupLayout(panFormulario);
        panFormulario.setLayout(panFormularioLayout);
        panFormularioLayout.setHorizontalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addContainerGap(664, Short.MAX_VALUE)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fEdtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFormularioLayout.createSequentialGroup()
                        .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSenha)))
                .addContainerGap())
            .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panFormularioLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panFormularioLayout.createSequentialGroup()
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCpf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fEdtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFormularioLayout.createSequentialGroup()
                            .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fEdtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fEdtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(230, Short.MAX_VALUE)))
        );
        panFormularioLayout.setVerticalGroup(
            panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFormularioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fEdtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario))
                .addGap(18, 18, 18)
                .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panFormularioLayout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fEdtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fEdtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(3, 3, 3)
                    .addGroup(panFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTelefone)
                        .addComponent(fEdtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(13, 13, 13)))
        );

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        panBotoes.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panBotoes.add(btnEditar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        panBotoes.add(btnExcluir);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panBotoes.add(btnCancelar);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        panBotoes.add(btnConfirmar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void grdTecnicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdTecnicosMouseClicked

    }//GEN-LAST:event_grdTecnicosMouseClicked

    private void fEdtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fEdtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fEdtEmailActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        try {
            if (idTecnicoEditando > 0) {
                tecnicoController.atualizarTecnico(idTecnicoEditando, Double.valueOf(fEdtSalario.getText()), edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()   , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
            } else {
                tecnicoController.cadastrarTecnico(idTecnicoEditando, Double.valueOf(fEdtSalario.getText()), edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()  , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
            }
            //Comando bastante importante
            this.idTecnicoEditando = -1L;

            tecnicoController.atualizarTabela(grdTecnicos);

            this.habilitarCampos(false);
            this.limparCampos();
        } catch (TecnicoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Tecnico tecnicoEditando = (Tecnico) this.getObjetoSelecionadoNaGrid();

        if (tecnicoEditando == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(tecnicoEditando);
            this.idTecnicoEditando = tecnicoEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Tecnico tecnicoExcluido = (Tecnico) this.getObjetoSelecionadoNaGrid();

        if (tecnicoExcluido == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir o Tecnico  \n("
                + tecnicoExcluido.getNome() + ", "
                + tecnicoExcluido.getEmail() + ") ?",
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    tecnicoController.excluirTecnico(tecnicoExcluido);

                    tecnicoController.atualizarTabela(grdTecnicos);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (TecnicoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.idTecnicoEditando = -1L;

        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void fEdtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fEdtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fEdtDataNascActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdTecnicos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdTecnicos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }
    
    
    public void habilitarCampos(boolean flag) {
        for (int i = 0; i < panFormulario.getComponents().length; i++) {
            panFormulario.getComponent(i).setEnabled(flag);
        }
    }
        
        public void limparCampos() {
            edtNome.setText("");
            fEdtCpf.setText("");
            fEdtDataNasc.setText("");
            fEdtEmail.setText("");
            fEdtSalario.setText("");
            fEdtTelefone.setText("");
    }
        
    public void preencherFormulario(Tecnico t) {
            edtNome.setText(t.getNome());
            fEdtCpf.setText(t.getCPF());
            fEdtDataNasc.setText(t.getDataNasc());
            fEdtEmail.setText(t.getEmail());
            fEdtSalario.setText(String.valueOf(t.getSalario()));
            fEdtTelefone.setText(t.getTelefone());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new dlgCadastrarTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtNome;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JFormattedTextField fEdtCpf;
    private javax.swing.JFormattedTextField fEdtDataNasc;
    private javax.swing.JFormattedTextField fEdtEmail;
    private javax.swing.JFormattedTextField fEdtSalario;
    private javax.swing.JFormattedTextField fEdtTelefone;
    private javax.swing.JTable grdTecnicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panFormulario;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables

    private void criarMascaraCadastros() {
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.install(fEdtTelefone);
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(fEdtCpf);
            MaskFormatter dataNascMask = new MaskFormatter("##/##/####");
            dataNascMask.install(fEdtDataNasc);
            MaskFormatter salarioMask = new MaskFormatter("#####.###");
            salarioMask.install(fEdtSalario);
        } catch (ParseException ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
