/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ServicoController;
import model.Cliente;
import model.Tecnico;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Data;
import model.Servico;
import model.exceptions.ServicoException;

/**
 *
 * @author diego
 */
public class dlgCadastroServico extends javax.swing.JDialog {
    //Cliente clienteEscolhido;
    //Tecnico tecnicoEscolhido;
    dlgCadastrarInstalacaoRede dlgInstalacaoRede;
    dlgCadastrarManutencaoPreventiva dlgManutencaoPreventiva;
    dlgCadastrarConsertoComputador dlgConsertoComputador;
    

    /**
     * Creates new form dlgCadastroServico
     */
    public dlgCadastroServico(java.awt.Dialog parent) {
        super(parent);
        //clienteEscolhido = new Cliente();
        //tecnicoEscolhido = new Tecnico();
        initComponents();
        this.habilitarCampos(false);
        //servicoController.atualizarTabelaCliente(grdClientes);;
        //servicoController.atualizarTabelaTecnico(grdTecnicos);
        //servicoController.atualizarTabela(grdServicos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panMenu = new javax.swing.JPanel();
        btnConsertoComputador = new javax.swing.JButton();
        btnInstalacaoRede = new javax.swing.JButton();
        btnManutencaoPreventiva = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar serviço");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        btnConsertoComputador.setText("Conserto de Computador");
        btnConsertoComputador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsertoComputadorActionPerformed(evt);
            }
        });

        btnInstalacaoRede.setText("Instalação de Rede");
        btnInstalacaoRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstalacaoRedeActionPerformed(evt);
            }
        });

        btnManutencaoPreventiva.setText("Manutenção Preventiva");
        btnManutencaoPreventiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManutencaoPreventivaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMenuLayout = new javax.swing.GroupLayout(panMenu);
        panMenu.setLayout(panMenuLayout);
        panMenuLayout.setHorizontalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsertoComputador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInstalacaoRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManutencaoPreventiva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panMenuLayout.setVerticalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsertoComputador, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInstalacaoRede, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManutencaoPreventiva, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsertoComputadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsertoComputadorActionPerformed
        // Abrir a tela de conserta de computador
        this.dlgConsertoComputador = new dlgCadastrarConsertoComputador(this, true);
        dlgConsertoComputador.setVisible(true);       
    }//GEN-LAST:event_btnConsertoComputadorActionPerformed

    private void btnInstalacaoRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstalacaoRedeActionPerformed
        // Abrir a tela de instalação de rede
        this.dlgInstalacaoRede = new dlgCadastrarInstalacaoRede(this, true);
        dlgInstalacaoRede.setVisible(true);
    }//GEN-LAST:event_btnInstalacaoRedeActionPerformed

    private void btnManutencaoPreventivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManutencaoPreventivaActionPerformed
       // Abrir a tela de manutenção preventiva
       this.dlgManutencaoPreventiva = new dlgCadastrarManutencaoPreventiva(this, true);
       dlgManutencaoPreventiva.setVisible(true);     
    }//GEN-LAST:event_btnManutencaoPreventivaActionPerformed


    
        public void habilitarCampos(boolean flag) {
                /*lblServicoEfetuado.setEnabled(flag);
                boxEscolhaServico.setEnabled(flag);
                lblValor.setEnabled(flag);
                edtValor.setEnabled(flag);
                lblCpfCliente.setEnabled(flag);
                fEdtEmailCliente.setEnabled(flag);
                btnBuscarCliente.setEnabled(flag);
                grdClientes.setEnabled(flag);
                lblCpfTecnico.setEnabled(flag);
                fEdtEmailTecnico.setEnabled(flag);
                btnBuscarTecnico.setEnabled(flag);
                grdTecnicos.setEnabled(flag);
                lblDescricaoServico.setEnabled(flag);
                edtDescricaoServico.setEnabled(flag);
                lblServicos.setEnabled(flag);
                grdServicos.setEnabled(flag);*/
                
        }
        
        public void limparCampos(){
                /*edtValor.setText("");
                fEdtEmailCliente.setText("");
                fEdtEmailTecnico.setText("");
                edtDescricaoServico.setText("");*/
        }
        
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
            java.util.logging.Logger.getLogger(dlgCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new dlgCadastroServico().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsertoComputador;
    private javax.swing.JButton btnInstalacaoRede;
    private javax.swing.JButton btnManutencaoPreventiva;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panMenu;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
