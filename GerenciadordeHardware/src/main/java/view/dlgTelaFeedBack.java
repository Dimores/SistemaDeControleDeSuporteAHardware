/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.FeedBackController;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.FeedBack;
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
    FeedBack feedBack;
    private Long idFeedbackEditando;
    //feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.idUsuarioLogado);
    /**
     * Creates new form dlgTelaFeedBack
     */
    public dlgTelaFeedBack(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        feedBackController = new FeedBackController();
        telaSelecaoServico = new dlgSelecaoServico(this, modal);
        feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.getId());
        feedBack = new FeedBack();
        servicoSelecionado = new Servico();
        idFeedbackEditando = -1L;
        //feedBackController.salvar(panStars.getStar(), " ", NtpTimeClient.dataAtualToString(), null, SessionManager.idUsuarioLogado);
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
        edtServico = new view.graphicElements.TextField();
        textAreaScroll1 = new view.graphicElements.TextAreaScroll();
        txtComentario = new view.graphicElements.TextArea();
        jLabel1 = new javax.swing.JLabel();
        panStars = new view.graphicElements.StarRating();
        panTodosBotoes = new javax.swing.JPanel();
        btnExcluir = new view.graphicElements.BotaoVermelho();
        btnSalvar = new view.graphicElements.BotaoVermelho();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdFeedBacks = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 153));
        setResizable(false);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setBackground(new java.awt.Color(20, 20, 20));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Deixe seu FeedBack");

        panPreencher.setOpaque(false);

        edtServico.setEditable(false);
        edtServico.setBackground(new java.awt.Color(20, 20, 20));
        edtServico.setForeground(new java.awt.Color(251, 251, 251));
        edtServico.setText("Clique aqui pra buscar um serviço.");
        edtServico.setLabelText("Servico");
        edtServico.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtServico.setLineColor(new java.awt.Color(229, 9, 20));
        edtServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edtServicoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edtServicoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                edtServicoMouseReleased(evt);
            }
        });
        edtServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtServicoActionPerformed(evt);
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

        panStars.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                panStarsVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panStars, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panPreencherLayout.setVerticalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(edtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textAreaScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panStars, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        panTodosBotoes.setOpaque(false);

        btnExcluir.setBackground(new java.awt.Color(51, 51, 51));
        btnExcluir.setForeground(new java.awt.Color(251, 251, 251));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcluir.setRadius(40);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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

        javax.swing.GroupLayout panTodosBotoesLayout = new javax.swing.GroupLayout(panTodosBotoes);
        panTodosBotoes.setLayout(panTodosBotoesLayout);
        panTodosBotoesLayout.setHorizontalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        panTodosBotoesLayout.setVerticalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
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
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                                .addGap(0, 92, Short.MAX_VALUE)
                                .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
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
                .addContainerGap(119, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtServicoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        FeedBack feedBackExcluido = (FeedBack) this.getObjetoSelecionadoNaGrid();
        

        if (feedBackExcluido == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir o Feedback  \n("
                + feedBackExcluido.getComentário(),
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    feedBackController.excluir(feedBackExcluido);

                    feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.getId());
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
        feedBackController.excluir(feedBack);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        try {
            if (idFeedbackEditando > 0) {
               feedBackController.atualizar(idFeedbackEditando,panStars.getStar(), txtComentario.getText(), "23/11/2023", servicoSelecionado, SessionManager.getId());


            } else {

               feedBackController.salvar(panStars.getStar(), txtComentario.getText(),  "23/11/2023", servicoSelecionado, SessionManager.getId());
            }
            //Comando bastante importante
            this.idFeedbackEditando = -1L;

            feedBackController.atualizarTabelaHistórico(grdFeedBacks,SessionManager.getId());
            this.limparCampos();
            
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgTelaFeedBack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void edtServicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtServicoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_edtServicoMouseExited

    private void edtServicoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtServicoMouseReleased

    }//GEN-LAST:event_edtServicoMouseReleased

    private void panStarsVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_panStarsVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_panStarsVetoableChange

    private void edtServicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtServicoMousePressed
        // TODO add your handling code here:
        telaSelecaoServico.setVisible(true);
       
        if(telaSelecaoServico.getServicoSelecionado() != null){
            edtServico.setText(telaSelecaoServico.getServicoSelecionado().getDescricaoServico());
            servicoSelecionado = telaSelecaoServico.getServicoSelecionado();
        }
    }//GEN-LAST:event_edtServicoMousePressed

    /**
     * @param args the command line arguments
     */
    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdFeedBacks.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdFeedBacks.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnExcluir;
    private view.graphicElements.BotaoVermelho btnSalvar;
    private view.graphicElements.TextField edtServico;
    private view.graphicElements.TableDark grdFeedBacks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panPreencher;
    private view.graphicElements.StarRating panStars;
    private javax.swing.JPanel panTodosBotoes;
    private view.graphicElements.TextAreaScroll textAreaScroll1;
    private view.graphicElements.TextArea txtComentario;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        edtServico.setText("");
        txtComentario.setText("");
        panStars.setStar(0);
    }


}
