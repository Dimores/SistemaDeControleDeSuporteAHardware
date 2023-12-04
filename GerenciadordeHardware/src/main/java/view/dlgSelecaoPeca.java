/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.PecaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Peca;
import model.exceptions.PecaException;
import controller.PecaExemplarController;
/**
 *
 * @author diego
 */
public class dlgSelecaoPeca extends javax.swing.JDialog {
    List<Peca> pecasSelecionadas;
    PecaController pecaController;
    PecaExemplarController exemplar;
    /**
     * Creates new form dlgSelecaoPeca
     */
    public dlgSelecaoPeca(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pecaController = new PecaController();
        pecaController.atualizarTabela(grdPecas);
        exemplar = new PecaExemplarController();
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
        grdPecas = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panBotoes, java.awt.BorderLayout.CENTER);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 44)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Selecione uma ou mais Peça(s)");

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

        grdPecas.setModel(new javax.swing.table.DefaultTableModel(
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
        grdPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdPecasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grdPecas);

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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
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

        getContentPane().add(panFundo, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
     if (pecasSelecionadas.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
     } else {
         int response = JOptionPane.showConfirmDialog(null,
                 "Deseja escolher essas Peças?  \n(",
                 "Confirmar escolha",
                 JOptionPane.OK_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE);
         if (response == JOptionPane.OK_OPTION) {
             try {
                 List<Peca> pecasRemover = new ArrayList<>();
                 for (Peca peca : pecasSelecionadas) {
                    if(peca.getEstoque() <=0){
                       pecasRemover.add(peca);
                    }
                 }
                 if(!pecasRemover.isEmpty()){
                     JOptionPane.showMessageDialog(this, "Algumas peças estavam fora dde estoque e não puderam ser selecionadas");
                 }
                 pecasSelecionadas.removeAll(pecasRemover);
                 
                 this.dispose();
             } catch (PecaException ex) {
                 JOptionPane.showMessageDialog(this, ex.getMessage());
             }
         } else if (response == JOptionPane.CANCEL_OPTION) {
             pecasSelecionadas = null;
         }
     }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void grdPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdPecasMouseClicked
        // TODO add your handling code here:
        pecasSelecionadas = getObjetosSelecionadosNaGrid();

        if (!pecasSelecionadas.isEmpty()) {
            //System.out.println("Peças Selecionadas:");
            for (Peca peca : pecasSelecionadas) {
                //System.out.println(peca.getNome());
            }
        } else {
            //System.out.println("Nenhuma peça selecionada.");
        }
    }//GEN-LAST:event_grdPecasMouseClicked

    public List<Peca> getPecasSelecionadas(){
        return this.pecasSelecionadas;
    }
    
    private List<Peca> getObjetosSelecionadosNaGrid() {
        int[] selectedRows = grdPecas.getSelectedRows();
        List<Peca> objetosSelecionados = new ArrayList<>();

        for (int row : selectedRows) {
            Object obj = grdPecas.getModel().getValueAt(row, -1); // Substitua o índice da coluna de acordo com sua necessidade
            if (obj != null) {
                objetosSelecionados.add((Peca)(obj));
                
            }
        }

        return objetosSelecionados;
    }
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.TableDark grdPecas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panFundo;
    // End of variables declaration//GEN-END:variables
}
