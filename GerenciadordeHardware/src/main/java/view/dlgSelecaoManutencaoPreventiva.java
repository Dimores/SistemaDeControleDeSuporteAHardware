/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ManutencaoPreventivaController;
import javax.swing.JOptionPane;
import model.ManutencaoPreventiva;
import model.exceptions.ManutencaoPreventivaException;
import utils.SessionManager;

/**
 *
 * @author diego
 */
public class dlgSelecaoManutencaoPreventiva extends javax.swing.JDialog {

    ManutencaoPreventiva manutencaoPreventivaEscolhida;

    ManutencaoPreventivaController manutencaoPreventivaController;

    /**
     * Creates new form dlgSelecaoManutencaoPreventiva
     */
    public dlgSelecaoManutencaoPreventiva(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        manutencaoPreventivaEscolhida = new ManutencaoPreventiva();
        manutencaoPreventivaController = new ManutencaoPreventivaController();

        manutencaoPreventivaController.atualizarTabela(grdManutencoesPreventivas, SessionManager.getId());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBotoes1 = new javax.swing.JPanel();
        panFundo1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        btnConfirmar1 = new view.graphicElements.BotaoVermelho();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdManutencoesPreventivas = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panBotoes1.setLayout(new javax.swing.BoxLayout(panBotoes1, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panBotoes1, java.awt.BorderLayout.CENTER);

        panFundo1.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 44)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Selecione a Manutencão Preventiva");

        btnConfirmar1.setBackground(new java.awt.Color(51, 51, 51));
        btnConfirmar1.setForeground(new java.awt.Color(251, 251, 251));
        btnConfirmar1.setText("Confirmar");
        btnConfirmar1.setBorderPainted(false);
        btnConfirmar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar1.setRadius(40);
        btnConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar1ActionPerformed(evt);
            }
        });

        grdManutencoesPreventivas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(grdManutencoesPreventivas);

        javax.swing.GroupLayout panFundo1Layout = new javax.swing.GroupLayout(panFundo1);
        panFundo1.setLayout(panFundo1Layout);
        panFundo1Layout.setHorizontalGroup(
            panFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundo1Layout.createSequentialGroup()
                .addGroup(panFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundo1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panFundo1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panFundo1Layout.setVerticalGroup(
            panFundo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar1ActionPerformed
        // TODO add your handling code here:
        manutencaoPreventivaEscolhida = (ManutencaoPreventiva) this.getObjetoSelecionadoNaGrid();

        if (manutencaoPreventivaEscolhida == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja escolher a Manutencao Preventiva \n("
                    + manutencaoPreventivaEscolhida.getId() + ", "
                    + manutencaoPreventivaEscolhida.getDescricaoServico() + ") ?",
                    "Confirmar escolha",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {
                try {
                    //JOptionPane.showMessageDialog(this, "Escolha feita com sucesso!");
                    this.dispose();
                } catch (ManutencaoPreventivaException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else if (response == JOptionPane.CANCEL_OPTION) {
                manutencaoPreventivaEscolhida = null;
            }
        }
    }//GEN-LAST:event_btnConfirmar1ActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdManutencoesPreventivas.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdManutencoesPreventivas.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    public ManutencaoPreventiva getManutencaoPreventivaEscolhida() {
        return manutencaoPreventivaEscolhida;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnConfirmar1;
    private view.graphicElements.TableDark grdManutencoesPreventivas;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panBotoes1;
    private javax.swing.JPanel panFundo1;
    // End of variables declaration//GEN-END:variables
}