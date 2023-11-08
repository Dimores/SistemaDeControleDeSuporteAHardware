/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.FeedBackController;
import model.Servico;
import utils.NtpTimeClient;
import utils.SessionManager;

/**
 *
 * @author ruiz
 */
public class dlgTelaFeedBack extends javax.swing.JDialog {
    FeedBackController feedBackController;
    dlgSelecaoServico telaSelecaoServico;
    Servico servicoSelecionado;
    /**
     * Creates new form dlgTelaFeedBack
     */
    public dlgTelaFeedBack(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        feedBackController = new FeedBackController();
        System.out.print(SessionManager.idUsuarioLogado);
        telaSelecaoServico = new dlgSelecaoServico(this, modal);
        feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.idUsuarioLogado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panFundo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panPreencher = new javax.swing.JPanel();
        edtServicos = new view.graphicElements.TextField();
        textAreaScroll1 = new view.graphicElements.TextAreaScroll();
        txtComentario = new view.graphicElements.TextArea();
        jLabel1 = new javax.swing.JLabel();
        starRating1 = new view.graphicElements.StarRating();
        panTodosBotoes = new javax.swing.JPanel();
        btnEditar1 = new view.graphicElements.BotaoVermelho();
        btnExcluir1 = new view.graphicElements.BotaoVermelho();
        btnSalvar = new view.graphicElements.BotaoVermelho();
        btnHistorico = new view.graphicElements.BotaoVermelho();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdFeedBacks = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 153));

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setBackground(new java.awt.Color(20, 20, 20));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Deixe seu FeedBack");

        panPreencher.setForeground(new java.awt.Color(0, 0, 0));
        panPreencher.setOpaque(false);

        edtServicos.setEditable(false);
        edtServicos.setBackground(new java.awt.Color(20, 20, 20));
        edtServicos.setForeground(new java.awt.Color(251, 251, 251));
        edtServicos.setText("Clique aqui pra buscar um serviço.");
        edtServicos.setLabelText("Servico");
        edtServicos.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtServicos.setLineColor(new java.awt.Color(229, 9, 20));
        edtServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtServicosActionPerformed(evt);
            }
        });

        textAreaScroll1.setLabelText("Descrição");
        textAreaScroll1.setLabelTextColor(new java.awt.Color(251, 251, 251));
        textAreaScroll1.setLineColor(new java.awt.Color(229, 9, 20));
        textAreaScroll1.setOpaque(false);

        txtComentario.setBackground(new java.awt.Color(51, 51, 51));
        txtComentario.setColumns(20);
        txtComentario.setForeground(new java.awt.Color(251, 251, 251));
        txtComentario.setRows(5);
        txtComentario.setToolTipText("escreva aqui");
        txtComentario.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        textAreaScroll1.setViewportView(txtComentario);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Avalie nosso Serviço!");

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(starRating1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panPreencherLayout.setVerticalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(edtServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(starRating1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panTodosBotoes.setOpaque(false);

        btnEditar1.setBackground(new java.awt.Color(51, 51, 51));
        btnEditar1.setForeground(new java.awt.Color(251, 251, 251));
        btnEditar1.setText("Editar");
        btnEditar1.setBorderPainted(false);
        btnEditar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar1.setRadius(40);
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnExcluir1.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir1.setForeground(new java.awt.Color(251, 251, 251));
        btnExcluir1.setText("Excluir");
        btnExcluir1.setBorderPainted(false);
        btnExcluir1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcluir1.setRadius(40);
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(51, 51, 51));
        btnSalvar.setForeground(new java.awt.Color(251, 251, 251));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalvar.setRadius(40);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnHistorico.setBackground(new java.awt.Color(51, 51, 51));
        btnHistorico.setForeground(new java.awt.Color(251, 251, 251));
        btnHistorico.setText("Histórico de Comentarios");
        btnHistorico.setBorderPainted(false);
        btnHistorico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHistorico.setRadius(40);
        btnHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panTodosBotoesLayout = new javax.swing.GroupLayout(panTodosBotoes);
        panTodosBotoes.setLayout(panTodosBotoesLayout);
        panTodosBotoesLayout.setHorizontalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        panTodosBotoesLayout.setVerticalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        grdFeedBacks.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(grdFeedBacks);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtServicosActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        feedBackController.salvar(0, txtComentario.getText(), "", servicoSelecionado, SessionManager.idUsuarioLogado);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoActionPerformed
        // TODO add your handling code here:
        feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.idUsuarioLogado);
    }//GEN-LAST:event_btnHistoricoActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnEditar1;
    private view.graphicElements.BotaoVermelho btnExcluir1;
    private view.graphicElements.BotaoVermelho btnHistorico;
    private view.graphicElements.BotaoVermelho btnSalvar;
    private view.graphicElements.TextField edtServicos;
    private view.graphicElements.TableDark grdFeedBacks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panPreencher;
    private javax.swing.JPanel panTodosBotoes;
    private view.graphicElements.StarRating starRating1;
    private view.graphicElements.TextAreaScroll textAreaScroll1;
    private view.graphicElements.TextArea txtComentario;
    // End of variables declaration//GEN-END:variables
}
