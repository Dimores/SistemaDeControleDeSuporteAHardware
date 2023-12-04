/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import controller.ManutencaoPreventivaController;
import controller.ServicoController;
import controller.TecnicoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Cliente;
import utils.Data;
import model.ManutencaoPreventiva;
import model.Tecnico;
import model.exceptions.ServicoException;
import utils.SessionManager;

/**
 *
 * @author diego
 */
public class dlgCadastrarManutencaoPreventiva extends javax.swing.JDialog {

    ServicoController servicoController;
    ManutencaoPreventivaController manutencaoPreventivaController;
    TecnicoController tecnicoController;
    private Long idManutencaoEditando;
    private String data;

    dlgSelecaoCliente telaSelecaoCliente;
    dlgSelecaoTecnico telaSelecaoTecnico;

    Cliente clienteSelecionado;
    Tecnico tecnicoSelecionado;

    // Preço padrao de instalação de rede
    private float precoManutencaoPreventiva = 60;

    int code;

    /**
     * Creates new form dlgCadastrarManutencaoPreventiva
     *
     * @param parent
     * @param modal
     */
    public dlgCadastrarManutencaoPreventiva(java.awt.Dialog parent, boolean modal, int code) {
        super(parent, modal);
        initComponents();
        manutencaoPreventivaController = new ManutencaoPreventivaController();
        servicoController = new ServicoController();
        tecnicoController = new TecnicoController();
        this.habilitarCampos(false);
        this.code = code;
        idManutencaoEditando = -1L;
        data = Data.pegaDataSistema();
        manutencaoPreventivaController.atualizarTabela(grdManutencoes);

        clienteSelecionado = new Cliente();
        tecnicoSelecionado = new Tecnico();

        telaSelecaoCliente = new dlgSelecaoCliente(this, true);
        telaSelecaoTecnico = new dlgSelecaoTecnico(this, true);

        edtPreco.setText(String.valueOf(precoManutencaoPreventiva));

        if (code == 2) {
            tecnicoSelecionado = (Tecnico) tecnicoController.buscarTecnico(SessionManager.getId());
            edtTecnico.setText(tecnicoSelecionado.getNome());
            edtTecnico.setEnabled(false);
        }
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
        edtPreco = new view.graphicElements.TextField();
        edtDescricao = new view.graphicElements.TextField();
        edtCliente = new view.graphicElements.TextField();
        chkConcluido = new view.graphicElements.JCheckBoxCustom();
        edtTecnico = new view.graphicElements.TextField();
        edtEquipamentos = new view.graphicElements.TextField();
        chkPago = new view.graphicElements.JCheckBoxCustom();
        panTodosBotoes = new javax.swing.JPanel();
        btnEditar = new view.graphicElements.BotaoVermelho();
        btnExcluir = new view.graphicElements.BotaoVermelho();
        btnCancelar = new view.graphicElements.BotaoVermelho();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        btnNovo = new view.graphicElements.BotaoVermelho();
        jScrollPane4 = new javax.swing.JScrollPane();
        grdManutencoes = new view.graphicElements.TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo1.setBackground(new java.awt.Color(20, 20, 20));
        lblTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 44)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo1.setText("Cadastrar Manutenção Preventiva");

        panPreencher.setForeground(new java.awt.Color(0, 0, 0));
        panPreencher.setOpaque(false);

        edtPreco.setEditable(false);
        edtPreco.setBackground(new java.awt.Color(20, 20, 20));
        edtPreco.setForeground(new java.awt.Color(251, 251, 251));
        edtPreco.setLabelText("Preço");
        edtPreco.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtPreco.setLineColor(new java.awt.Color(229, 9, 20));
        edtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPrecoActionPerformed(evt);
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

        chkConcluido.setBackground(new java.awt.Color(251, 251, 251));
        chkConcluido.setForeground(new java.awt.Color(251, 251, 251));
        chkConcluido.setText("Concluido");

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

        edtEquipamentos.setBackground(new java.awt.Color(20, 20, 20));
        edtEquipamentos.setForeground(new java.awt.Color(251, 251, 251));
        edtEquipamentos.setLabelText("Equipamentos utilizados");
        edtEquipamentos.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtEquipamentos.setLineColor(new java.awt.Color(229, 9, 20));

        chkPago.setBackground(new java.awt.Color(251, 251, 251));
        chkPago.setForeground(new java.awt.Color(251, 251, 251));
        chkPago.setText("Pago");

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panPreencherLayout.createSequentialGroup()
                        .addComponent(chkConcluido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtTecnico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edtEquipamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPreencherLayout.setVerticalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtEquipamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkConcluido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
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

        grdManutencoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(grdManutencoes);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPrecoActionPerformed

    private void edtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edtClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edtClienteFocusGained

    private void edtClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edtClienteMousePressed
        // TODO add your handling code here:
        telaSelecaoCliente.setVisible(true);

        if (telaSelecaoCliente.getClienteEscolhido() != null) {
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
        if (!(code == 2)) {
            telaSelecaoTecnico.setVisible(true);

            if (telaSelecaoTecnico.getTecnicoEscolhido() != null) {
                edtTecnico.setText(telaSelecaoTecnico.getTecnicoEscolhido().getNome() + ".");
                tecnicoSelecionado = telaSelecaoTecnico.getTecnicoEscolhido();
            }
        }
    }//GEN-LAST:event_edtTecnicoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ManutencaoPreventiva manutencaoPreventivaEditando = (ManutencaoPreventiva) this.getObjetoSelecionadoNaGrid(grdManutencoes);

        if (manutencaoPreventivaEditando == null) {
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        } else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(manutencaoPreventivaEditando);
            this.idManutencaoEditando = manutencaoPreventivaEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        ManutencaoPreventiva manutencaoPreventivaExcluida = (ManutencaoPreventiva) this.getObjetoSelecionadoNaGrid(grdManutencoes);

        if (manutencaoPreventivaExcluida == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            int response = JOptionPane.showConfirmDialog(null,
                    "Deseja exlcuir a Manutenção  \n("
                    + manutencaoPreventivaExcluida.getId() + ", "
                    + manutencaoPreventivaExcluida.getValor() + ") ?",
                    "Confirmar exclusão",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    manutencaoPreventivaController.excluirManutencaoPreventiva(manutencaoPreventivaExcluida);

                    manutencaoPreventivaController.atualizarTabela(grdManutencoes);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (ServicoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            if (idManutencaoEditando > 0) {
                manutencaoPreventivaController.atualizarManutencaoPreventiva(idManutencaoEditando, tecnicoSelecionado,
                        clienteSelecionado, Float.parseFloat(edtPreco.getText()), edtDescricao.getText(),
                        data, chkConcluido.isSelected(), edtEquipamentos.getText(),
                        edtDescricao.getText(), chkPago.isSelected());
            } else {
                manutencaoPreventivaController.cadastrarManutencaoPreventiva(idManutencaoEditando, tecnicoSelecionado,
                        clienteSelecionado, Float.parseFloat(edtPreco.getText()),
                        edtDescricao.getText(), data, chkConcluido.isSelected(),
                        edtEquipamentos.getText(),
                        edtDescricao.getText(), chkPago.isSelected());
            }
            //Comando bastante importante
            this.idManutencaoEditando = -1L;
            this.limparCampos();
            this.habilitarCampos(false);
            manutencaoPreventivaController.atualizarTabela(grdManutencoes);

            this.limparCampos();
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
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
        edtPreco.setText(String.valueOf(precoManutencaoPreventiva));
        edtEquipamentos.setText("");
        edtDescricao.setText("");
        edtCliente.setText("Clique aqui para adicionar um Cliente.");
        if (this.code == 2) {
            edtTecnico.setText(tecnicoSelecionado.getNome());
        } else {
            edtTecnico.setText("Clique aqui para adicionar um Ténico.");
        }
        chkConcluido.setSelected(false);
        chkPago.setSelected(false);
    }

    private Object getObjetoSelecionadoNaGrid(JTable grd) {
        int rowCliked = grd.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grd.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }

    public void preencherFormulario(ManutencaoPreventiva manutencaoPreventivaEditando) {
        // Preencha os campos com os dados do consertoComputadorEditando
        edtPreco.setText(String.valueOf(manutencaoPreventivaEditando.getValor()));
        edtDescricao.setText(manutencaoPreventivaEditando.getDescricaoServico());
        edtEquipamentos.setText(manutencaoPreventivaEditando.getEquipamentos());

        // Obtenha o técnico associado à InstalacaoRede
        tecnicoSelecionado = manutencaoPreventivaEditando.getTecnicoResponsavel();

        // Obtenha o cliente associado à InstalacaoRede
        clienteSelecionado = manutencaoPreventivaEditando.getClienteAtendido();

        if (tecnicoSelecionado != null) {
            edtTecnico.setText(tecnicoSelecionado.getNome() + ".");
        }

        // Se o cliente não for nulo, selecione-o na grade de clientes (grdClientes)
        if (clienteSelecionado != null) {
            edtCliente.setText(clienteSelecionado.getNome() + ".");
        }

        chkConcluido.setSelected(manutencaoPreventivaEditando.isConcluido());
        chkPago.setSelected(manutencaoPreventivaEditando.isPago());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnCancelar;
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.BotaoVermelho btnEditar;
    private view.graphicElements.BotaoVermelho btnExcluir;
    private view.graphicElements.BotaoVermelho btnNovo;
    private view.graphicElements.JCheckBoxCustom chkConcluido;
    private view.graphicElements.JCheckBoxCustom chkPago;
    private view.graphicElements.TextField edtCliente;
    private view.graphicElements.TextField edtDescricao;
    private view.graphicElements.TextField edtEquipamentos;
    private view.graphicElements.TextField edtPreco;
    private view.graphicElements.TextField edtTecnico;
    private view.graphicElements.TableDark grdManutencoes;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panPreencher;
    private javax.swing.JPanel panTodosBotoes;
    // End of variables declaration//GEN-END:variables
}
