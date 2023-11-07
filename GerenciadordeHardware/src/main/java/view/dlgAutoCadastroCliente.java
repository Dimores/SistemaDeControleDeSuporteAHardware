/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ClienteController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.Cliente;
import model.exceptions.ClienteException;
import utils.Email;

/**
 *
 * @author diego
 */
public class dlgAutoCadastroCliente extends javax.swing.JDialog {
    ClienteController clienteController;
    Long idClienteEditando;
    // Comentario
    /**
     * Creates new form dlgCadastroServico
     */
    public dlgAutoCadastroCliente(java.awt.Frame parent, boolean modal) {
        clienteController = new ClienteController();
        idClienteEditando = -1L;
        initComponents();
        this.criarMascaraCadastros();
        this.habilitarCampos(true);
        this.limparCampos();
        this.setModal(modal);
        setDefaultCloseOperation(dlgAutoCadastroCliente.DISPOSE_ON_CLOSE);
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
        edtNome = new view.graphicElements.TextField();
        fEdtEmail = new view.graphicElements.TextField();
        fEdtCpf = new view.graphicElements.FormattedTextField();
        fEdtDataNasc = new view.graphicElements.FormattedTextField();
        fEdtTelefone = new view.graphicElements.FormattedTextField();
        edtSenha = new view.graphicElements.PasswordField();
        edtConfirmarSenha = new view.graphicElements.PasswordField();
        panTodosBotoes = new javax.swing.JPanel();
        btnCancelar = new view.graphicElements.BotaoVermelho();
        btnConfirmar = new view.graphicElements.BotaoVermelho();
        panBotoes = new javax.swing.JPanel();

        setResizable(false);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        lblTitulo.setBackground(new java.awt.Color(20, 20, 20));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(251, 251, 251));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastre-se");

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

        edtConfirmarSenha.setBackground(new java.awt.Color(20, 20, 20));
        edtConfirmarSenha.setForeground(new java.awt.Color(251, 251, 251));
        edtConfirmarSenha.setLabelText("Confirmar senha");
        edtConfirmarSenha.setLabelTextColor(new java.awt.Color(251, 251, 251));
        edtConfirmarSenha.setLineColor(new java.awt.Color(229, 9, 20));
        edtConfirmarSenha.setName(""); // NOI18N

        javax.swing.GroupLayout panPreencherLayout = new javax.swing.GroupLayout(panPreencher);
        panPreencher.setLayout(panPreencherLayout);
        panPreencherLayout.setHorizontalGroup(
            panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPreencherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPreencherLayout.createSequentialGroup()
                        .addComponent(fEdtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPreencherLayout.createSequentialGroup()
                        .addGroup(panPreencherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edtConfirmarSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fEdtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fEdtDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fEdtCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panPreencherLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(222, 222, 222))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panTodosBotoes.setOpaque(false);

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

        javax.swing.GroupLayout panTodosBotoesLayout = new javax.swing.GroupLayout(panTodosBotoes);
        panTodosBotoes.setLayout(panTodosBotoesLayout);
        panTodosBotoesLayout.setHorizontalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panTodosBotoesLayout.setVerticalGroup(
            panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTodosBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTodosBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panPreencher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panTodosBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        getContentPane().add(panFundo, java.awt.BorderLayout.PAGE_START);

        panBotoes.setLayout(new javax.swing.BoxLayout(panBotoes, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panBotoes, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
         try {
            if(edtSenha.getText().equals(edtConfirmarSenha.getText())){
                clienteController.cadastrarCliente(idClienteEditando, edtNome.getText(), fEdtCpf.getText(), fEdtDataNasc.getText()  , edtSenha.getText(), fEdtEmail.getText(), fEdtTelefone.getText());
                Email email = new Email(edtNome.getText(), fEdtEmail.getText(), "Mensagem de boas vindas da CyberNinja Support", "Seja Bem-Vindo!", "EmailBoasVindas.html");
                //Comando bastante importante
                this.idClienteEditando = -1L;
                this.habilitarCampos(false);
                this.limparCampos();
                this.dispose();
            }
        } catch (ClienteException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(dlgAutoCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.idClienteEditando = -1L;
        this.limparCampos();
        this.habilitarCampos(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnCancelar;
    private view.graphicElements.BotaoVermelho btnConfirmar;
    private view.graphicElements.PasswordField edtConfirmarSenha;
    private view.graphicElements.TextField edtNome;
    private view.graphicElements.PasswordField edtSenha;
    private view.graphicElements.FormattedTextField fEdtCpf;
    private view.graphicElements.FormattedTextField fEdtDataNasc;
    private view.graphicElements.TextField fEdtEmail;
    private view.graphicElements.FormattedTextField fEdtTelefone;
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
            Logger.getLogger(dlgAutoCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
