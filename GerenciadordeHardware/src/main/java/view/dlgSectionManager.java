/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ClienteController;
import controller.LoginController;
import controller.TecnicoController;
import javax.swing.JFrame;
import model.Cliente;
import model.Tecnico;

/**
 *
 * @author ruiz
 */
public class dlgSectionManager extends javax.swing.JDialog {
    ClienteController clienteControll;
    TecnicoController tecnicoControll;
    dlgUsuario telaUsuario ;
    String email;
    /**
     * Creates new form dlgSectionManager
     */
    public dlgSectionManager(java.awt.Frame parent, boolean modal, String  email) {
        super(parent, modal);
        initComponents();
        this.email = email;
    }

    private dlgSectionManager(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        lblComoLogar = new javax.swing.JLabel();
        panOptions = new javax.swing.JPanel();
        btnCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnTecnico = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnGerente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblComoLogar.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        lblComoLogar.setText("Como você deseja Logar?");

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTituloLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblComoLogar)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
            .addGroup(panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panTituloLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(lblComoLogar)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        panOptions.setLayout(new javax.swing.BoxLayout(panOptions, javax.swing.BoxLayout.LINE_AXIS));

        btnCliente.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        panOptions.add(btnCliente);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panOptions.add(jSeparator1);

        btnTecnico.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        btnTecnico.setText("Tecnico");
        btnTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTecnicoActionPerformed(evt);
            }
        });
        panOptions.add(btnTecnico);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panOptions.add(jSeparator2);

        btnGerente.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        btnGerente.setText("Gerente");
        btnGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerenteActionPerformed(evt);
            }
        });
        panOptions.add(btnGerente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panOptions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(74, Short.MAX_VALUE)
                    .addComponent(panOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
      
      clienteControll = new ClienteController();
      Cliente clienteBuscado = clienteControll.buscarCliente(email);
      LoginController validaLogin = new LoginController();
      telaUsuario = new dlgUsuario(validaLogin.accessManager(clienteBuscado));
      telaUsuario.getLblUserName().setText(clienteBuscado.getNome());
      this.setVisible(false);
      telaUsuario.setVisible(true);
      this.setVisible(true);
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTecnicoActionPerformed
      tecnicoControll = new TecnicoController();
      Tecnico tecnicoBuscado = tecnicoControll.buscarTecnico(email);
      LoginController validaLogin = new LoginController();
      telaUsuario = new dlgUsuario(validaLogin.accessManager(tecnicoBuscado));
      telaUsuario.getLblUserName().setText(tecnicoBuscado.getNome());
      
      this.setVisible(false);
      telaUsuario.setVisible(true);
      this.setVisible(true);
    }//GEN-LAST:event_btnTecnicoActionPerformed

    private void btnGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGerenteActionPerformed

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
            java.util.logging.Logger.getLogger(dlgSectionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgSectionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgSectionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgSectionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgSectionManager dialog = new dlgSectionManager(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnGerente;
    private javax.swing.JButton btnTecnico;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblComoLogar;
    private javax.swing.JPanel panOptions;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
