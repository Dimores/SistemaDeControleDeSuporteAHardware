/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PecaController;
import java.awt.Component;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import model.Peca;
import model.exceptions.PecaException;

/**
 *
 * @author diego
 */
public class dlgCadastrarPeca extends javax.swing.JDialog {
        PecaController pecaController;
        Long idPecaEditando;

    /**
     * Creates new form dlgCadastroServico
     */
    public dlgCadastrarPeca(java.awt.Dialog parent) {
        super(parent);
        pecaController = new PecaController();
        idPecaEditando = -1L;
        initComponents();
        this.setModal(true);
        this.adicionarMascaranosCampos();
        this.habilitarCampos(panCampos1, false);
        this.habilitarCampos(panCampos2, false);
        pecaController.atualizarTabela(grdPecas);
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
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdPecas = new javax.swing.JTable();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        panCampos1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        edtPreco = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        lblEstoque = new javax.swing.JLabel();
        edtEstoque = new javax.swing.JTextField();
        panCampos2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtCategoria = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        edtTipo = new javax.swing.JTextField();
        lblDataFabricacao = new javax.swing.JLabel();
        fEdtDataFabricacao = new javax.swing.JFormattedTextField();
        lblDescricao = new javax.swing.JLabel();
        edtDescricao = new javax.swing.JTextField();

        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar peça");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        grdPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdPecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdPecas);

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

        panCampos1.setLayout(new javax.swing.BoxLayout(panCampos1, javax.swing.BoxLayout.LINE_AXIS));

        lblNome.setText("Nome:");
        panCampos1.add(lblNome);
        panCampos1.add(edtNome);

        lblPreco.setText("Preço:");
        panCampos1.add(lblPreco);
        panCampos1.add(edtPreco);

        lblCodigo.setText("Codigo:");
        panCampos1.add(lblCodigo);
        panCampos1.add(edtCodigo);

        lblEstoque.setText("Estoque:");
        panCampos1.add(lblEstoque);
        panCampos1.add(edtEstoque);

        panCampos2.setLayout(new javax.swing.BoxLayout(panCampos2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Categoria:");
        panCampos2.add(jLabel1);
        panCampos2.add(edtCategoria);

        lblTipo.setText("Tipo:");
        panCampos2.add(lblTipo);
        panCampos2.add(edtTipo);

        lblDataFabricacao.setText("DataFabric");
        panCampos2.add(lblDataFabricacao);
        panCampos2.add(fEdtDataFabricacao);

        lblDescricao.setText("Descricao:");
        panCampos2.add(lblDescricao);

        edtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDescricaoActionPerformed(evt);
            }
        });
        panCampos2.add(edtDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE))
                    .addComponent(panCampos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCampos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCampos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(panCampos1, true);
        this.habilitarCampos(panCampos2, true);
        /*JFrame frame = new JFrame("Exemplo com JOptionPane");
        Object[] options = {"Sim", "Não"};
        int result = JOptionPane.showOptionDialog(frame,
            "Era essa peça que você queria?",
            "",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]);*/
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
            try {
            if (idPecaEditando > 0) {
                pecaController.atualizarPeca(idPecaEditando, edtCodigo.getText(), edtNome.getText(), edtDescricao.getText(), Double.parseDouble(edtPreco.getText()), Integer.parseInt(edtEstoque.getText()), edtCategoria.getText(), fEdtDataFabricacao.getText(), edtTipo.getText());
            } else {
                pecaController.cadastrarPeca(idPecaEditando, edtCodigo.getText(), edtNome.getText(), edtDescricao.getText(), Double.parseDouble(edtPreco.getText()), Integer.parseInt(edtEstoque.getText()), edtCategoria.getText(), fEdtDataFabricacao.getText(), edtTipo.getText());
            }
            //Comando bastante importante
            this.idPecaEditando = -1L;

            pecaController.atualizarTabela(grdPecas);

        this.habilitarCampos(panCampos1, false);
        this.habilitarCampos(panCampos2, false);
        
        this.limparCampos();
        } catch (PecaException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void grdPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdPecasMouseClicked
        
    }//GEN-LAST:event_grdPecasMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Peca pecaEditando = (Peca) this.getObjetoSelecionadoNaGrid();

        if (pecaEditando == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(panCampos1, true);
            this.habilitarCampos(panCampos2, true);
            this.preencherFormulario(pecaEditando);
            this.idPecaEditando = pecaEditando.getIdPeca();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.idPecaEditando = -1L;
        this.limparCampos();
        this.habilitarCampos(panCampos1, false);
        this.habilitarCampos(panCampos2, false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Peca pecaExcluida = (Peca) this.getObjetoSelecionadoNaGrid();

        if (pecaExcluida == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir a Peca  \n("
                + pecaExcluida.getNome() + ", "
                + pecaExcluida.getCodigo() + ") ?",
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    pecaController.excluirPeca(pecaExcluida);

                    pecaController.atualizarTabela(grdPecas);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (PecaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }  
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void edtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDescricaoActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdPecas.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdPecas.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }
    
    public void preencherFormulario(Peca peca) {
        edtNome.setText(peca.getNome());
        edtCategoria.setText(peca.getCategoria());
        edtCodigo.setText(peca.getCodigo());
        edtEstoque.setText(String.valueOf(peca.getEstoque()));
        edtTipo.setText(peca.getTipo());
        edtPreco.setText(String.valueOf(peca.getPreco()));
        edtDescricao.setText(peca.getDescricao());
        fEdtDataFabricacao.setText(peca.getDataFabricacao());

    }
    
    public void habilitarCampos(JPanel panel, boolean flag) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            component.setEnabled(flag);
        }
    }
        
    private void limparCampos() {
        edtCategoria.setText("");
        edtCodigo.setText("");
        edtEstoque.setText("");
        edtNome.setText("");
        edtPreco.setText("");
        edtTipo.setText("");
        edtDescricao.setText("");
        fEdtDataFabricacao.setText("");
    }

    private void adicionarMascaranosCampos()  {
        try {
            MaskFormatter dataFabric = new MaskFormatter("##/##/####");
            dataFabric.install(fEdtDataFabricacao);
        } catch (ParseException ex) {
            Logger.getLogger(IntCadastrarPeca.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(dlgCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new dlgCadastrarPeca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtCategoria;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTextField edtEstoque;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTextField edtTipo;
    private javax.swing.JFormattedTextField fEdtDataFabricacao;
    private javax.swing.JTable grdPecas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataFabricacao;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panCampos1;
    private javax.swing.JPanel panCampos2;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
