/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.RelatorioManutencaoController;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Data;
import model.RelatorioManutencao;
import model.Tecnico;
import model.exceptions.RelatorioManutencaoException;

/**
 *
 * @author diego
 */
public class dlgCadastrarRelatorioManutencao extends javax.swing.JDialog {
    private String dataRelatorio;
    Long idManutencaoEditando;
    
    dlgSelecaoCliente telaSelecaoCliente;
    dlgSelecaoTecnico telaSelecaoTecnico;
    
    Cliente clienteSelecionado;
    Tecnico tecnicoSelecionado;
    
    RelatorioManutencaoController relatorioManutencaoController;
    /**
     * Creates new form dlgCadastrarRelatorioRede
     */
    public dlgCadastrarRelatorioManutencao(java.awt.Dialog parent) {
        super(parent);
        initComponents();  
        this.setModal(true);
        dataRelatorio = Data.pegaDataSistema();   
        
        relatorioManutencaoController = new RelatorioManutencaoController();
        
        clienteSelecionado = new Cliente();
        tecnicoSelecionado = new Tecnico();
        
        idManutencaoEditando = -1L;
        
        telaSelecaoCliente = new dlgSelecaoCliente(this, true);
        telaSelecaoTecnico = new dlgSelecaoTecnico(this, true);
        
        relatorioManutencaoController.atualizarTabela(grdRelatoriosManutencao);
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
        lblTitulo1 = new javax.swing.JLabel();
        panPreencher = new javax.swing.JPanel();
        edtEquipamentos = new view.graphicElements.TextField();
        edtDescricao = new view.graphicElements.TextField();
        edtCliente = new view.graphicElements.TextField();
        edtTecnico = new view.graphicElements.TextField();
        panTodosBotoes = new javax.swing.JPanel();
        btnEditar = new view.graphicElements.BotaoVermelho();
        btnExcluir = new view.graphicElements.BotaoVermelho();
        btnCancelar = new view.graphicElements.BotaoVermelho();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        btnNovo = new view.graphicElements.BotaoVermelho();
        jScrollPane3 = new javax.swing.JScrollPane();
        grdRelatoriosManutencao = new view.graphicElements.TableDark();

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo1.setBackground(new java.awt.Color(20, 20, 20));
        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 44)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Cadastrar Relatório de Manutenção");

        panPreencher.setForeground(new java.awt.Color(0, 0, 0));
        panPreencher.setOpaque(false);

        edtEquipamentos.setBackground(new java.awt.Color(20, 20, 20));
        edtEquipamentos.setForeground(new java.awt.Color(251, 251, 251));
        edtEquipamentos.setLabelText("Equipamentos");
        edtEquipamentos.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtEquipamentos.setLineColor(new java.awt.Color(229, 9, 20));
        edtEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtEquipamentosActionPerformed(evt);
            }
        });

        edtDescricao.setBackground(new java.awt.Color(20, 20, 20));
        edtDescricao.setForeground(new java.awt.Color(251, 251, 251));
        edtDescricao.setLabelText("Descrição");
        edtDescricao.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtDescricao.setLineColor(new java.awt.Color(229, 9, 20));

        edtCliente.setEditable(false);
        edtCliente.setBackground(new java.awt.Color(20, 20, 20));
        edtCliente.setForeground(new java.awt.Color(251, 251, 251));
        edtCliente.setText("Clique aqui para adicionar um Cliente.");
        edtCliente.setLabelText("Cliente");
        edtCliente.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtCliente.setLineColor(new java.awt.Color(229, 9, 20));
        edtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edtClienteFocusGained(evt);
            }
        });
        edtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edtClienteMousePressed(evt);
            }
        });
        edtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtClienteActionPerformed(evt);
            }
        });

        edtTecnico.setEditable(false);
        edtTecnico.setBackground(new java.awt.Color(20, 20, 20));
        edtTecnico.setForeground(new java.awt.Color(251, 251, 251));
        edtTecnico.setText("Clique aqui para adicionar um Ténico.");
        edtTecnico.setLabelText("Técnico");
        edtTecnico.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtTecnico.setLineColor(new java.awt.Color(229, 9, 20));
        edtTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edtTecnicoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edtEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPreencherLayout.setVerticalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addComponent(edtEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panTodosBotoes.setOpaque(false);

        btnEditar.setBackground(new java.awt.Color(51, 51, 51));
        btnEditar.setForeground(new java.awt.Color(251, 251, 251));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setRadius(40);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

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

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setForeground(new java.awt.Color(251, 251, 251));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCancelar.setRadius(40);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        btnNovo.setBackground(new java.awt.Color(51, 51, 51));
        btnNovo.setForeground(new java.awt.Color(251, 251, 251));
        btnNovo.setText("Novo");
        btnNovo.setBorderPainted(false);
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNovo.setRadius(40);
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panTodosBotoesLayout = new javax.swing.GroupLayout(panTodosBotoes);
        panTodosBotoes.setLayout(panTodosBotoesLayout);
        panTodosBotoesLayout.setHorizontalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panTodosBotoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panTodosBotoesLayout.createSequentialGroup()
                        .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panTodosBotoesLayout.setVerticalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        grdRelatoriosManutencao.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(grdRelatoriosManutencao);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtEquipamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtEquipamentosActionPerformed

    private void edtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtClienteFocusGained

    private void edtClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtClienteMousePressed
        // TODO add your handling code here:
        telaSelecaoCliente.setVisible(true);

        if(telaSelecaoCliente.getClienteEscolhido() != null){
            edtCliente.setText(telaSelecaoCliente.getClienteEscolhido().getNome() + ".");
            clienteSelecionado = telaSelecaoCliente.getClienteEscolhido();
        }

    }//GEN-LAST:event_edtClienteMousePressed

    private void edtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtClienteActionPerformed
        // TODO add your handling code here:
        // Aqui
    }//GEN-LAST:event_edtClienteActionPerformed

    private void edtTecnicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtTecnicoMouseClicked
        // TODO add your handling code here:
        telaSelecaoTecnico.setVisible(true);

        if(telaSelecaoTecnico.getTecnicoEscolhido() != null){
            edtTecnico.setText(telaSelecaoTecnico.getTecnicoEscolhido().getNome() + ".");
            tecnicoSelecionado = telaSelecaoTecnico.getTecnicoEscolhido();
        }

    }//GEN-LAST:event_edtTecnicoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        RelatorioManutencao relatorioManutencaoEditando = (RelatorioManutencao) this.getObjetoSelecionadoNaGrid();
        
        if(relatorioManutencaoEditando == null){
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        }else{
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(relatorioManutencaoEditando);
            this.idManutencaoEditando = relatorioManutencaoEditando.getIdRelatorio();         
        }  

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        RelatorioManutencao relatorioManutencaoExcluido = (RelatorioManutencao) this.getObjetoSelecionadoNaGrid();

        if (relatorioManutencaoExcluido == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir o Relatorio de Manutencao  \n("
                + relatorioManutencaoExcluido.getIdRelatorio()+ ", "
                + relatorioManutencaoExcluido.getDescricao()+ ") ?",
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    relatorioManutencaoController.excluirRelatorioManutencao(relatorioManutencaoExcluido);

                    relatorioManutencaoController.atualizarTabela(grdRelatoriosManutencao);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (RelatorioManutencaoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        idManutencaoEditando = -1L;
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            if (idManutencaoEditando > 0) {
                relatorioManutencaoController.atualizarRelatorioManutencao(idManutencaoEditando, dataRelatorio, edtDescricao.getText(), clienteSelecionado, tecnicoSelecionado, edtEquipamentos.getText());
            } else {
                relatorioManutencaoController.cadastrarRelatorioManutencao(idManutencaoEditando, dataRelatorio, edtDescricao.getText(), clienteSelecionado, tecnicoSelecionado, edtEquipamentos.getText());
            }
            //Comando bastante importante
            this.idManutencaoEditando = -1L;

            relatorioManutencaoController.atualizarTabela(grdRelatoriosManutencao);

            this.habilitarCampos(false);
            this.limparCampos();
        } catch (RelatorioManutencaoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarRelatorioManutencao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.limparCampos();
        this.habilitarCampos(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    public void habilitarCampos(boolean flag) {
        for (int i = 0; i < panPreencher.getComponents().length; i++) {
            panPreencher.getComponent(i).setVisible(flag);
        }    
    }
    
    private void limparCampos() {
        // Limpa os Edts
        edtDescricao.setText("");
        edtEquipamentos.setText("");
        edtCliente.setText("Clique aqui para adicionar um Cliente.");
        edtTecnico.setText("Clique aqui para adicionar um Ténico.");
    }
    
    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdRelatoriosManutencao.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdRelatoriosManutencao.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }
    
    public void preencherFormulario(RelatorioManutencao relatorioManutencao) {
        edtEquipamentos.setText(relatorioManutencao.getEquipamentos());
        edtDescricao.setText(relatorioManutencao.getDescricao());
        
        // Obtenha o técnico associado ao ConsertoComputador
        tecnicoSelecionado = relatorioManutencao.getTecnico();

        // Obtenha o cliente associado ao ConsertoComputador
        clienteSelecionado = relatorioManutencao.getCliente();
        
        if (tecnicoSelecionado != null) {
            edtTecnico.setText(tecnicoSelecionado.getNome() + ".");
        }

        // Se o cliente não for nulo, selecione-o na grade de clientes (grdClientes)
        if (clienteSelecionado != null) {
            edtCliente.setText(clienteSelecionado.getNome() + ".");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnCancelar;
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.BotaoVermelho btnEditar;
    private view.graphicElements.BotaoVermelho btnExcluir;
    private view.graphicElements.BotaoVermelho btnNovo;
    private view.graphicElements.TextField edtCliente;
    private view.graphicElements.TextField edtDescricao;
    private view.graphicElements.TextField edtEquipamentos;
    private view.graphicElements.TextField edtTecnico;
    private view.graphicElements.TableDark grdRelatoriosManutencao;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panPreencher;
    private javax.swing.JPanel panTodosBotoes;
    // End of variables declaration//GEN-END:variables
}
