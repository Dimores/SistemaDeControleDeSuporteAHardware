/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ManutencaoPreventivaController;
import controller.ServicoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.exceptions.ServicoException;

/**
 *
 * @author diego
 */
public class dlgCadastrarManutencaoPreventiva extends javax.swing.JDialog {
    ServicoController servicoController;
    ManutencaoPreventivaController manutencaoPreventivaController;
    private Long idManutencaoEditando;
    /**
     * Creates new form dlgCadastrarManutencaoPreventiva
     */
    public dlgCadastrarManutencaoPreventiva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        manutencaoPreventivaController = new ManutencaoPreventivaController();
        servicoController = new ServicoController();
        servicoController.atualizarTabelaCliente(grdClientes);
        servicoController.atualizarTabelaTecnico(grdTecnicos);
        this.habilitarCampos(false);
        
        idManutencaoEditando = -1L;
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
        lblSelecaoCliente = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        lblSelecaoTecnico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdTecnicos = new javax.swing.JTable();
        panCamposManutencao = new javax.swing.JPanel();
        lblEquipamentos = new javax.swing.JLabel();
        edtEquipamentos = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        edtDescricao = new javax.swing.JTextField();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdManutencoes = new javax.swing.JTable();
        lblManutencoes = new javax.swing.JLabel();
        panPreco = new javax.swing.JPanel();
        lblPreco = new javax.swing.JLabel();
        edtPreco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar Manutenção Preventiva");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblSelecaoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelecaoCliente.setText("Selecione o Cliente");

        grdClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grdClientes);

        lblSelecaoTecnico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelecaoTecnico.setText("Selecione o Técnico");

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

        lblEquipamentos.setText("Equipamentos utilizados:");

        lblDescricao.setText("Descrição:");

        javax.swing.GroupLayout panCamposManutencaoLayout = new javax.swing.GroupLayout(panCamposManutencao);
        panCamposManutencao.setLayout(panCamposManutencaoLayout);
        panCamposManutencaoLayout.setHorizontalGroup(
            panCamposManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCamposManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCamposManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCamposManutencaoLayout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtDescricao))
                    .addGroup(panCamposManutencaoLayout.createSequentialGroup()
                        .addComponent(lblEquipamentos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtEquipamentos))))
        );
        panCamposManutencaoLayout.setVerticalGroup(
            panCamposManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCamposManutencaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCamposManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEquipamentos)
                    .addComponent(edtEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panCamposManutencaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        panBotoes.add(btnEditar);

        btnExcluir.setText("Excluir");
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

        grdManutencoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grdManutencoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdManutencoesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(grdManutencoes);

        lblManutencoes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManutencoes.setText("Manutenções:");

        lblPreco.setText("Preço:");

        javax.swing.GroupLayout panPrecoLayout = new javax.swing.GroupLayout(panPreco);
        panPreco.setLayout(panPrecoLayout);
        panPrecoLayout.setHorizontalGroup(
            panPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrecoLayout.createSequentialGroup()
                .addComponent(lblPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtPreco))
        );
        panPrecoLayout.setVerticalGroup(
            panPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPrecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelecaoTecnico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(panCamposManutencao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addComponent(lblManutencoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelecaoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSelecaoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelecaoTecnico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCamposManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblManutencoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_grdClientesMouseClicked

    private void grdTecnicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdTecnicosMouseClicked

    }//GEN-LAST:event_grdTecnicosMouseClicked

    private void grdManutencoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdManutencoesMouseClicked

    }//GEN-LAST:event_grdManutencoesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            if (idManutencaoEditando > 0) {
                manutencaoPreventivaController.atualizarManutencaoPreventiva();
            } else {
                manutencaoPreventivaController.cadastrarManutencaoPreventiva();
            }
            //Comando bastante importante
            this.idManutencaoEditando = -1L;

            manutencaoPreventivaController.atualizarTabela(grdManutencoes);

            this.habilitarCampos(false);
            this.limparCampos();
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    public void habilitarCampos(boolean flag){
        // Labels
        lblDescricao.setEnabled(flag);
        lblEquipamentos.setEnabled(flag);
        lblManutencoes.setEnabled(flag);
        lblSelecaoCliente.setEnabled(flag);
        lblSelecaoTecnico.setEnabled(flag);
        lblPreco.setEnabled(flag);
        
        // Grids
        grdClientes.setEnabled(flag);
        grdClientes.setVisible(flag);
        grdManutencoes.setEnabled(flag);
        grdManutencoes.setVisible(flag);
        grdTecnicos.setEnabled(flag);
        grdTecnicos.setVisible(flag);
        
        // Text Fields
        edtDescricao.setEnabled(flag);
        edtPreco.setEnabled(flag);
        edtEquipamentos.setEnabled(flag);
    }
    
    private void limparCampos(){
        edtPreco.setText("");
        edtEquipamentos.setText("");
        edtDescricao.setText("");
    }
    
    private Object getObjetoSelecionadoNaGrid(JTable grd) {
        int rowCliked = grd.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grd.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
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
            java.util.logging.Logger.getLogger(dlgCadastrarManutencaoPreventiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarManutencaoPreventiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarManutencaoPreventiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCadastrarManutencaoPreventiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCadastrarManutencaoPreventiva dialog = new dlgCadastrarManutencaoPreventiva(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTextField edtEquipamentos;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTable grdClientes;
    private javax.swing.JTable grdManutencoes;
    private javax.swing.JTable grdTecnicos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEquipamentos;
    private javax.swing.JLabel lblManutencoes;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblSelecaoCliente;
    private javax.swing.JLabel lblSelecaoTecnico;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panCamposManutencao;
    private javax.swing.JPanel panPreco;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
