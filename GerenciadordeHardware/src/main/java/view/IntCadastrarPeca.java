/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class IntCadastrarPeca extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntCadastrarPeca
     */
    public IntCadastrarPeca() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        panBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panCampos1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        edtPreco = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        edtCodigo = new javax.swing.JTextField();
        panCampos2 = new javax.swing.JPanel();
        lblEstoque = new javax.swing.JLabel();
        edtEstoque = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        edtCategoria = new javax.swing.JTextField();
        lblDataFabricacao = new javax.swing.JLabel();
        fEdtDataFabricacao = new javax.swing.JFormattedTextField();
        lblTipo = new javax.swing.JLabel();
        edtTipo = new javax.swing.JTextField();

        setForeground(java.awt.Color.orange);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar peça");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

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
        jScrollPane1.setViewportView(grdClientes);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));

        btnNovo.setText("Novo");
        panBotoes.add(btnNovo);

        jButton3.setText("Editar");
        panBotoes.add(jButton3);

        jButton4.setText("Excluir");
        panBotoes.add(jButton4);

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panBotoes.add(jButton1);

        jButton2.setText("Cancelar");
        panBotoes.add(jButton2);

        panCampos1.setLayout(new javax.swing.BoxLayout(panCampos1, javax.swing.BoxLayout.LINE_AXIS));

        lblNome.setText("Nome:");
        panCampos1.add(lblNome);
        panCampos1.add(edtNome);

        lblPreco.setText("Preço:");
        panCampos1.add(lblPreco);
        panCampos1.add(edtPreco);

        lblCodigo.setText("Codigo");
        panCampos1.add(lblCodigo);

        edtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCodigoActionPerformed(evt);
            }
        });
        panCampos1.add(edtCodigo);

        panCampos2.setLayout(new javax.swing.BoxLayout(panCampos2, javax.swing.BoxLayout.LINE_AXIS));

        lblEstoque.setText("Estoque");
        panCampos2.add(lblEstoque);
        panCampos2.add(edtEstoque);

        lblCategoria.setText("Categoria");
        panCampos2.add(lblCategoria);
        panCampos2.add(edtCategoria);

        lblDataFabricacao.setText("DataFabric");
        panCampos2.add(lblDataFabricacao);

        fEdtDataFabricacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fEdtDataFabricacaoActionPerformed(evt);
            }
        });
        panCampos2.add(fEdtDataFabricacao);

        lblTipo.setText("Tipo");
        panCampos2.add(lblTipo);
        panCampos2.add(edtTipo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addComponent(panCampos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCampos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCampos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panCampos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdClientesMouseClicked

    }//GEN-LAST:event_grdClientesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void edtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCodigoActionPerformed
        // TODO add your handling code here:
        // Sim eu sou maluco demais
        System.out.print("Malucio");
    }//GEN-LAST:event_edtCodigoActionPerformed

    private void fEdtDataFabricacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fEdtDataFabricacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fEdtDataFabricacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtCategoria;
    private javax.swing.JTextField edtCodigo;
    private javax.swing.JTextField edtEstoque;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTextField edtTipo;
    private javax.swing.JFormattedTextField fEdtDataFabricacao;
    private javax.swing.JTable grdClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataFabricacao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panCampos1;
    private javax.swing.JPanel panCampos2;
    // End of variables declaration//GEN-END:variables
}
