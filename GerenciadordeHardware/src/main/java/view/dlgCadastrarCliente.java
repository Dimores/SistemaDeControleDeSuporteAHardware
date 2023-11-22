/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ClienteController;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.exceptions.ClienteException;
import utils.Email;
import utils.NtpTimeClient;
import utils.PublicIP;

/**
 *
 * @author diego
 */
public class dlgCadastrarCliente extends javax.swing.JDialog {
    ClienteController clienteController;
    Long idClienteEditando;

    /**
     * Creates new form dlgCadastroServico
     */
    public dlgCadastrarCliente(java.awt.Dialog parent) {
        clienteController = new ClienteController();
        idClienteEditando = -1L;
        initComponents();
        this.criarMascaraCadastros();
        this.limparCampos();
        this.setModal(true);
        clienteController.atualizarTabela(grdClientes);
        setDefaultCloseOperation(dlgCadastrarCliente.DISPOSE_ON_CLOSE);
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
        fEdtTelefone = new view.graphicElements.FormattedTextField();
        edtSenha = new view.graphicElements.PasswordField();
        panTodosBotoes = new javax.swing.JPanel();
        btnEditar = new view.graphicElements.BotaoVermelho();
        btnExcluir = new view.graphicElements.BotaoVermelho();
        btnCancelar = new view.graphicElements.BotaoVermelho();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        btnNovo = new view.graphicElements.BotaoVermelho();
        jScrollPane2 = new javax.swing.JScrollPane();
        grdClientes = new view.graphicElements.TableDark();

        setResizable(false);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panBotoes, java.awt.BorderLayout.CENTER);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastrar cliente");

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
        fEdtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fEdtCpfFocusGained(evt);
            }
        });
        fEdtCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fEdtCpfMousePressed(evt);
            }
        });

        fEdtDataNasc.setBackground(new java.awt.Color(20, 20, 20));
        fEdtDataNasc.setForeground(new java.awt.Color(251, 251, 251));
        fEdtDataNasc.setLabelText("Data de Nascimento");
        fEdtDataNasc.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtDataNasc.setLineColor(new java.awt.Color(229, 9, 20));
        fEdtDataNasc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fEdtDataNascFocusGained(evt);
            }
        });
        fEdtDataNasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fEdtDataNascMousePressed(evt);
            }
        });

        fEdtTelefone.setBackground(new java.awt.Color(20, 20, 20));
        fEdtTelefone.setForeground(new java.awt.Color(251, 251, 251));
        fEdtTelefone.setLabelText("Telefone");
        fEdtTelefone.setLabelTextColor(new java.awt.Color(251, 251, 251));
        fEdtTelefone.setLineColor(new java.awt.Color(229, 9, 20));
        fEdtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fEdtTelefoneFocusGained(evt);
            }
        });
        fEdtTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fEdtTelefoneMousePressed(evt);
            }
        });

        edtSenha.setBackground(new java.awt.Color(20, 20, 20));
        edtSenha.setForeground(new java.awt.Color(251, 251, 251));
        edtSenha.setToolTipText("bla bla bla");
        edtSenha.setLabelText("Senha");
        edtSenha.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtSenha.setLineColor(new java.awt.Color(229, 9, 20));
        edtSenha.setName(""); // NOI18N

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                        .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fEdtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fEdtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panPreencherLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(222, 222, 222))
                    .addGroup(panPreencherLayout.createSequentialGroup()
                        .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edtSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(fEdtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fEdtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fEdtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 196, Short.MAX_VALUE))
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
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Cliente clienteEditando = (Cliente) this.getObjetoSelecionadoNaGrid();

        if (clienteEditando == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {
            this.limparCampos();
            this.habilitarCampos(true);
            this.preencherFormulario(clienteEditando);
            this.idClienteEditando = clienteEditando.getId();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Cliente clienteExcluido = (Cliente) this.getObjetoSelecionadoNaGrid();

        if (clienteExcluido == null)
        JOptionPane.showMessageDialog(this, "Primeiro selecione um registro na tabela.");
        else {

            int response = JOptionPane.showConfirmDialog(null,
                "Deseja exlcuir o Cliente  \n("
                + clienteExcluido.getNome() + ", "
                + clienteExcluido.getEmail() + ") ?",
                "Confirmar exclusão",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.OK_OPTION) {

                try {
                    clienteController.excluirCliente(clienteExcluido);

                    clienteController.atualizarTabela(grdClientes);
                    JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
                } catch (ClienteException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.idClienteEditando = -1L;
        this.habilitarCampos(false);
        this.limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        try {
            if (idClienteEditando > 0) {
                Email email = new Email(edtNome.getText(), fEdtEmail.getText(), "Alteções no seu cadastro", NtpTimeClient.dataAtualToString() + " em " + PublicIP.getPublicIpAdress(), "EmailAlteracaoCadastro.html");
                clienteController.atualizarCliente(idClienteEditando, edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()   ,edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
               
            } else {
                clienteController.cadastrarCliente(idClienteEditando, edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()  , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
                Email email = new Email(edtNome.getText(), fEdtEmail.getText(), "Mensagem de boas vindas da CyberNinja Support", "Seja Bem-Vindo!", "EmailBoasVindas.html");
            }
            //Comando bastante importante
            this.idClienteEditando = -1L;

            clienteController.atualizarTabela(grdClientes);

            this.habilitarCampos(false);
            this.limparCampos();
        } catch (ClienteException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(dlgCadastrarTecnico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        this.habilitarCampos(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void fEdtCpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fEdtCpfFocusGained
        // TODO add your handling code here:
        fEdtCpf.setCaretPosition(0);
    }//GEN-LAST:event_fEdtCpfFocusGained

    private void fEdtCpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fEdtCpfMousePressed
        // TODO add your handling code here:
        fEdtCpf.setCaretPosition(0);
    }//GEN-LAST:event_fEdtCpfMousePressed

    private void fEdtDataNascFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fEdtDataNascFocusGained
        // TODO add your handling code here:
        fEdtDataNasc.setCaretPosition(0);
    }//GEN-LAST:event_fEdtDataNascFocusGained

    private void fEdtDataNascMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fEdtDataNascMousePressed
        // TODO add your handling code here:
        fEdtDataNasc.setCaretPosition(0);
    }//GEN-LAST:event_fEdtDataNascMousePressed

    private void fEdtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fEdtTelefoneFocusGained
        // TODO add your handling code here:
        fEdtTelefone.setCaretPosition(0);
    }//GEN-LAST:event_fEdtTelefoneFocusGained

    private void fEdtTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fEdtTelefoneMousePressed
        // TODO add your handling code here:
        fEdtTelefone.setCaretPosition(0);
    }//GEN-LAST:event_fEdtTelefoneMousePressed


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
    private view.graphicElements.FormattedTextField fEdtTelefone;
    private view.graphicElements.TableDark grdClientes;
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
        } catch (ParseException ex) {
            Logger.getLogger(dlgCadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Object getObjetoSelecionadoNaGrid() {
            int rowCliked = grdClientes.getSelectedRow();
            Object obj = null;
            if (rowCliked >= 0) {
                obj = grdClientes.getModel().getValueAt(rowCliked, -1);
            }
            return obj;
        }
    
    public void habilitarCampos(boolean flag) {
            for (int i = 0; i < panPreencher.getComponents().length; i++) {
                panPreencher.getComponent(i).setVisible(flag);
            }
        }
        
        public void limparCampos() {
            edtNome.setText("");
            fEdtCpf.setText("");
            fEdtDataNasc.setText("");
            fEdtEmail.setText("");
            fEdtTelefone.setText("");
    }
        
        public void preencherFormulario(Cliente c) {
            edtNome.setText(c.getNome());
            fEdtCpf.setText(c.getCPF());
            fEdtDataNasc.setText(c.getDataNasc());
            //edtSenha.setText(c.getSenha());
            fEdtEmail.setText(c.getEmail());
            fEdtTelefone.setText(c.getTelefone());
    }
}
