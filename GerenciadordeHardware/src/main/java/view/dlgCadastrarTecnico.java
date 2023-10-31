/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TecnicoController;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import model.Tecnico;
import model.exceptions.TecnicoException;

/**
 *
 * @author diego
 */
public class dlgCadastrarTecnico extends javax.swing.JDialog{
    TecnicoController tecnicoController;
    Long idTecnicoEditando;

    /**
     * Creates new form dlgCadastroServico
     */
    public dlgCadastrarTecnico(java.awt.Dialog parent) {
        super(parent);
        tecnicoController = new TecnicoController();
        idTecnicoEditando = -1L;
        initComponents();
        this.setModal(true);
        this.criarMascaraCadastros();
        
        //this.habilitarCampos(false , panPreencher);
        tecnicoController.atualizarTabela(grdTecnicos);
        
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
        panPreencher = new javax.swing.JPanel();
        edtNome = new view.graphicElements.TextField();
        fEdtEmail = new view.graphicElements.TextField();
        fEdtCpf = new view.graphicElements.FormattedTextField();
        fEdtDataNasc = new view.graphicElements.FormattedTextField();
        fEdtSalario = new view.graphicElements.FormattedTextField();
        fEdtTelefone = new view.graphicElements.FormattedTextField();
        edtSenha = new view.graphicElements.PasswordField();
        panTodosBotoes = new javax.swing.JPanel();
        btnEditar = new view.graphicElements.BotaoVermelho();
        btnExcluir = new view.graphicElements.BotaoVermelho();
        btnCancelar = new view.graphicElements.BotaoVermelho();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        btnNovo = new view.graphicElements.BotaoVermelho();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdTecnicos = new view.graphicElements.TableDark();

        setResizable(false);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panBotoes, java.awt.BorderLayout.CENTER);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar técnico");

        panPreencher.setForeground(new java.awt.Color(0, 0, 0));
        panPreencher.setOpaque(false);

        edtNome.setBackground(new java.awt.Color(20, 20, 20));
        edtNome.setForeground(new java.awt.Color(251, 251, 251));
        edtNome.setLabelText("Nome");
        edtNome.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtNome.setLineColor(new java.awt.Color(229, 9, 20));
        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        fEdtEmail.setBackground(new java.awt.Color(20, 20, 20));
        fEdtEmail.setForeground(new java.awt.Color(251, 251, 251));
        fEdtEmail.setLabelText("Email");
        fEdtEmail.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtEmail.setLineColor(new java.awt.Color(229, 9, 20));

        fEdtCpf.setBackground(new java.awt.Color(20, 20, 20));
        fEdtCpf.setForeground(new java.awt.Color(251, 251, 251));
        fEdtCpf.setLabelText("CPF");
        fEdtCpf.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtCpf.setLineColor(new java.awt.Color(229, 9, 20));

        fEdtDataNasc.setBackground(new java.awt.Color(20, 20, 20));
        fEdtDataNasc.setForeground(new java.awt.Color(251, 251, 251));
        fEdtDataNasc.setLabelText("Data de Nascimento");
        fEdtDataNasc.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtDataNasc.setLineColor(new java.awt.Color(229, 9, 20));

        fEdtSalario.setBackground(new java.awt.Color(20, 20, 20));
        fEdtSalario.setForeground(new java.awt.Color(251, 251, 251));
        fEdtSalario.setLabelText("Salário");
        fEdtSalario.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtSalario.setLineColor(new java.awt.Color(229, 9, 20));

        fEdtTelefone.setBackground(new java.awt.Color(20, 20, 20));
        fEdtTelefone.setForeground(new java.awt.Color(251, 251, 251));
        fEdtTelefone.setLabelText("Telefone");
        fEdtTelefone.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtTelefone.setLineColor(new java.awt.Color(229, 9, 20));

        edtSenha.setBackground(new java.awt.Color(20, 20, 20));
        edtSenha.setForeground(new java.awt.Color(251, 251, 251));
        edtSenha.setLabelText("Senha");
        edtSenha.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtSenha.setLineColor(new java.awt.Color(229, 9, 20));
        edtSenha.setName(""); // NOI18N

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fEdtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fEdtSalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fEdtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fEdtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panPreencherLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(222, 222, 222))
        );
        panPreencherLayout.setVerticalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

        grdTecnicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(grdTecnicos);

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Tecnico tecnicoExcluido = (Tecnico) this.getObjetoSelecionadoNaGrid();

        if (tecnicoExcluido == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir o Tecnico  \n("
                + tecnicoExcluido.getNome() + ", "
                + tecnicoExcluido.getEmail() + ") ?",
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    tecnicoController.excluirTecnico(tecnicoExcluido);

                    tecnicoController.atualizarTabela(grdTecnicos);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (TecnicoException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.idTecnicoEditando = -1L;
        this.habilitarCampos(false, panPreencher);
        this.limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos(true, panPreencher);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Tecnico tecnicoEditando = (Tecnico) this.getObjetoSelecionadoNaGrid();

        if (tecnicoEditando == null)
            JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(true, panPreencher);
            this.preencherFormulario(tecnicoEditando);
            this.idTecnicoEditando = tecnicoEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            if (idTecnicoEditando > 0) {
                tecnicoController.atualizarTecnico(idTecnicoEditando, Double.valueOf(fEdtSalario.getText()), edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()   , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
            } else {
                tecnicoController.cadastrarTecnico(idTecnicoEditando, Double.valueOf(fEdtSalario.getText()), edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()  , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
            }
            //Comando bastante importante
            this.idTecnicoEditando = -1L;

            tecnicoController.atualizarTabela(grdTecnicos);

            this.habilitarCampos(false, panPreencher);
            this.limparCampos();
        } catch (TecnicoException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private Object getObjetoSelecionadoNaGrid() {
        int rowCliked = grdTecnicos.getSelectedRow();
        Object obj = null;
        if (rowCliked >= 0) {
            obj = grdTecnicos.getModel().getValueAt(rowCliked, -1);
        }
        return obj;
    }
    
    
    public void habilitarCampos(boolean flag, JPanel painel) {
        for (int i = 0; i < painel.getComponents().length; i++) {
            painel.getComponent(i).setVisible(flag);
        }
    }
        
        public void limparCampos() {
            edtNome.setText("");
            fEdtCpf.setText("");
            fEdtDataNasc.setText("");
            fEdtEmail.setText("");
            fEdtSalario.setText("");
            fEdtTelefone.setText("");
    }
        
    public void preencherFormulario(Tecnico t) {
            edtNome.setText(t.getNome());
            fEdtCpf.setText(t.getCPF());
            fEdtDataNasc.setText(t.getDataNasc());
            fEdtEmail.setText(t.getEmail());
            fEdtSalario.setText(String.valueOf(t.getSalario()));
            fEdtTelefone.setText(t.getTelefone());
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnCancelar;
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.BotaoVermelho btnEditar;
    private view.graphicElements.BotaoVermelho btnExcluir;
    private view.graphicElements.BotaoVermelho btnNovo;
    private view.graphicElements.TextField edtNome;
    private view.graphicElements.PasswordField edtSenha;
    private view.graphicElements.FormattedTextField fEdtCpf;
    private view.graphicElements.FormattedTextField fEdtDataNasc;
    private view.graphicElements.TextField fEdtEmail;
    private view.graphicElements.FormattedTextField fEdtSalario;
    private view.graphicElements.FormattedTextField fEdtTelefone;
    private view.graphicElements.TableDark grdTecnicos;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panBotoes;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panPreencher;
    private javax.swing.JPanel panTodosBotoes;
    // End of variables declaration//GEN-END:variables

    private void criarMascaraCadastros() {
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####");
            telefoneMask.install(fEdtTelefone);
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(fEdtCpf);
            MaskFormatter dataNascMask = new MaskFormatter("##/##/####");
            dataNascMask.install(fEdtDataNasc);
            MaskFormatter salarioMask = new MaskFormatter("####.##");
            salarioMask.install(fEdtSalario);
        } catch (ParseException ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
