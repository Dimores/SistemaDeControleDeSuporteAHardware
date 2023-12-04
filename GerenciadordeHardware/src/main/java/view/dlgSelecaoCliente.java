/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import model.Cliente;
import model.exceptions.ClienteException;

/**
 *
 * @author diego
 */
public class dlgSelecaoCliente extends javax.swing.JDialog {

    Cliente clienteEscolhido;
    ClienteController clienteController;

    /**
     * Creates new form dlgSelecaoCliente
     */
    public dlgSelecaoCliente(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        clienteEscolhido = new Cliente();
        clienteController = new ClienteController();
        clienteController.atualizarTabela(grdClientes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBotoes = new javax.swing.JPanel();
        panFundo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdClientes = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Selecione o cliente");

        btnConfirmar.setBackground(new java.awt.Color(51, 51, 51));
        btnConfirmar.setForeground(new java.awt.Color(251, 251, 251));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setRadius(40);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        grdClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(grdClientes);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        clienteEscolhido = (Cliente) this.getObjetoSelecionadoNaGrid();

        if (clienteEscolhido == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja escolher o Cliente  \n("
                    + clienteEscolhido.getNome() + ", "
                    + clienteEscolhido.getEmail() + ") ?",
                    "Confirmar escolha",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {
                try {
                    //JOptionPane.showMessageDialog(this, "Escolha feita com sucesso!");
                    this.dispose();
                } catch (ClienteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else if (response == JOptionPane.CANCEL_OPTION) {
                clienteEscolhido = null;
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdClientes.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdClientes.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    public Cliente getClienteEscolhido() {
        return this.clienteEscolhido;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.TableDark grdClientes;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panFundo;
    // End of variables declaration//GEN-END:variables
}
