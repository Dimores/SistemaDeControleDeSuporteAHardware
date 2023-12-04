/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import utils.SessionManager;

/**
 *
 * @author ruiz
 */
public class dlgUsuario extends javax.swing.JDialog {

    dlgCadastrarCliente telaCliente;
    dlgCadastrarTecnico telaTecnico;
    dlgCadastrarPeca telaCadastroPeca;
    dlgCadastroServico telaServico;
    dlgCadastrarDispositivoRede telaDispositivoRede;
    dlgCadastrarRelatorioManutencao telaRelatorioManutencao;
    dlgCadastrarRelatorioRede telaRelatorioRede;
    dlgHistoricoAtendimentosCliente telaHistoricoCliente;
    dlgHistoricoAtendimentosGerente telaHistoricoGerente;
    dlgTelaFeedBack telaFeed;
    dlgSolicitarServicoCliente socilitarServicoCliente;
    dlgPix telaPix;

    /**
     * Creates new form FrMain
     */
    public dlgUsuario(boolean modal) {
        initComponents();

    }

    public dlgUsuario() {

    }

    public dlgUsuario(int code) {
        initComponents();
        setModal(true);
        habilitarCamposDeAcordoComPrevilegio(code);
        telaTecnico = new dlgCadastrarTecnico(this);
        telaCliente = new dlgCadastrarCliente(this);
        telaCadastroPeca = new dlgCadastrarPeca(this);
        new dlgCadastrarRelatorioManutencao(this);
        telaServico = new dlgCadastroServico(this, code);
        telaDispositivoRede = new dlgCadastrarDispositivoRede(this);
        telaRelatorioManutencao = new dlgCadastrarRelatorioManutencao(this);
        telaRelatorioRede = new dlgCadastrarRelatorioRede(this, SessionManager.getId());
        telaHistoricoCliente = new dlgHistoricoAtendimentosCliente(this, true, SessionManager.getId());
        telaHistoricoGerente = new dlgHistoricoAtendimentosGerente(this, true);
        telaFeed = new dlgTelaFeedBack(this, true);
        socilitarServicoCliente = new dlgSolicitarServicoCliente(this, true);

    }

    public javax.swing.JLabel getLblUserName() {
        return this.lblUserName;
    }

    public String getNomeUsuario() {
        return lblUserName.getText();
    }

    public void habilitarCamposDeAcordoComPrevilegio(int code) {
        switch (code) {
            // Cliente
            case 1:
                btnCadastrarServico.setVisible(false);
                btnCadastrarPeca.setVisible(false);
                btnCadastrarTecnico.setVisible(false);
                btnCadastrarDispositivoDeRede.setVisible(false);
                btnCadastrarCliente.setVisible(false);
                btnGerarRelatorioManutencao.setVisible(false);
                btnHistoricoAtendimentoGerente.setVisible(false);
                btnRealizarPagamento.setVisible(false);

                break;

            // Tecnico
            case 2:
                btnSocilitarServico.setVisible(false);
                btnSocilitarSuporte.setVisible(false);
                btnCadastrarTecnico.setVisible(false);
                btnCadastrarCliente.setVisible(false);
                btnGerarRelatorioManutencao.setVisible(false);
                btnGerarRelatorioRede.setVisible(false);
                btnHistoricoAtendimentoGerente.setVisible(false);
                btnHistoricoAtendimento1.setVisible(false);
                btnFeedBack1.setVisible(false);
                btnRealizarPagamento.setVisible(false);

                break;

            // Gerente
            case 3:
                btnSocilitarSuporte.setVisible(false);
                btnHistoricoAtendimento1.setVisible(false);
                btnFeedBack1.setVisible(false);
                btnCadastrarPeca.setVisible(false);
                btnGerarRelatorioRede.setVisible(false);
                btnSocilitarServico.setVisible(false);
                btnCadastrarDispositivoDeRede.setVisible(false);
                btnRealizarPagamento.setVisible(false);
                break;
            default:
                break;
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
        panOpcoes = new javax.swing.JPanel();
        btnCadastrarServico = new view.graphicElements.BotaoVermelho();
        btnCadastrarPeca = new view.graphicElements.BotaoVermelho();
        btnCadastrarTecnico = new view.graphicElements.BotaoVermelho();
        btnGerarRelatorioRede = new view.graphicElements.BotaoVermelho();
        btnSocilitarServico = new view.graphicElements.BotaoVermelho();
        btnCadastrarDispositivoDeRede = new view.graphicElements.BotaoVermelho();
        btnCadastrarCliente = new view.graphicElements.BotaoVermelho();
        btnGerarRelatorioManutencao = new view.graphicElements.BotaoVermelho();
        btnSocilitarSuporte = new view.graphicElements.BotaoVermelho();
        btnHistoricoAtendimento1 = new view.graphicElements.BotaoVermelho();
        btnHistoricoAtendimentoGerente = new view.graphicElements.BotaoVermelho();
        btnFeedBack1 = new view.graphicElements.BotaoVermelho();
        btnRealizarPagamento = new view.graphicElements.BotaoVermelho();
        btnSair = new view.graphicElements.BotaoVermelho();
        panUser = new javax.swing.JPanel();
        lblLoginIcone = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setResizable(false);

        panFundo.setBackground(new java.awt.Color(20, 20, 20));

        panOpcoes.setBackground(new java.awt.Color(102, 102, 102));
        panOpcoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panOpcoes.setOpaque(false);
        panOpcoes.setLayout(new javax.swing.BoxLayout(panOpcoes, javax.swing.BoxLayout.Y_AXIS));

        btnCadastrarServico.setBackground(new java.awt.Color(51, 51, 51));
        btnCadastrarServico.setForeground(new java.awt.Color(251, 251, 251));
        btnCadastrarServico.setText("Cadastrar Serviço");
        btnCadastrarServico.setBorderPainted(false);
        btnCadastrarServico.setFocusPainted(false);
        btnCadastrarServico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarServico.setRadius(40);
        btnCadastrarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarServicoActionPerformed(evt);
            }
        });
        panOpcoes.add(btnCadastrarServico);

        btnCadastrarPeca.setBackground(new java.awt.Color(51, 51, 51));
        btnCadastrarPeca.setForeground(new java.awt.Color(251, 251, 251));
        btnCadastrarPeca.setText("Cadastrar Peça");
        btnCadastrarPeca.setBorderPainted(false);
        btnCadastrarPeca.setFocusPainted(false);
        btnCadastrarPeca.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarPeca.setRadius(40);
        btnCadastrarPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPecaActionPerformed(evt);
            }
        });
        panOpcoes.add(btnCadastrarPeca);

        btnCadastrarTecnico.setBackground(new java.awt.Color(51, 51, 51));
        btnCadastrarTecnico.setForeground(new java.awt.Color(251, 251, 251));
        btnCadastrarTecnico.setText("Cadastrar Técnico");
        btnCadastrarTecnico.setBorderPainted(false);
        btnCadastrarTecnico.setFocusPainted(false);
        btnCadastrarTecnico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarTecnico.setRadius(40);
        btnCadastrarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTecnicoActionPerformed(evt);
            }
        });
        panOpcoes.add(btnCadastrarTecnico);

        btnGerarRelatorioRede.setBackground(new java.awt.Color(51, 51, 51));
        btnGerarRelatorioRede.setForeground(new java.awt.Color(251, 251, 251));
        btnGerarRelatorioRede.setText("Gerar Relatório de Rede");
        btnGerarRelatorioRede.setBorderPainted(false);
        btnGerarRelatorioRede.setFocusPainted(false);
        btnGerarRelatorioRede.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGerarRelatorioRede.setRadius(40);
        btnGerarRelatorioRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioRedeActionPerformed(evt);
            }
        });
        panOpcoes.add(btnGerarRelatorioRede);

        btnSocilitarServico.setBackground(new java.awt.Color(51, 51, 51));
        btnSocilitarServico.setForeground(new java.awt.Color(251, 251, 251));
        btnSocilitarServico.setText("Socilitar Serviço");
        btnSocilitarServico.setBorderPainted(false);
        btnSocilitarServico.setFocusPainted(false);
        btnSocilitarServico.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSocilitarServico.setRadius(40);
        btnSocilitarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSocilitarServicoActionPerformed(evt);
            }
        });
        panOpcoes.add(btnSocilitarServico);

        btnCadastrarDispositivoDeRede.setBackground(new java.awt.Color(51, 51, 51));
        btnCadastrarDispositivoDeRede.setForeground(new java.awt.Color(251, 251, 251));
        btnCadastrarDispositivoDeRede.setText("Cadastrar Dispositivo de Rede");
        btnCadastrarDispositivoDeRede.setBorderPainted(false);
        btnCadastrarDispositivoDeRede.setFocusPainted(false);
        btnCadastrarDispositivoDeRede.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarDispositivoDeRede.setRadius(40);
        btnCadastrarDispositivoDeRede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarDispositivoDeRedeActionPerformed(evt);
            }
        });
        panOpcoes.add(btnCadastrarDispositivoDeRede);

        btnCadastrarCliente.setBackground(new java.awt.Color(51, 51, 51));
        btnCadastrarCliente.setForeground(new java.awt.Color(251, 251, 251));
        btnCadastrarCliente.setText("Cadastrar Cliente");
        btnCadastrarCliente.setBorderPainted(false);
        btnCadastrarCliente.setFocusPainted(false);
        btnCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastrarCliente.setRadius(40);
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });
        panOpcoes.add(btnCadastrarCliente);

        btnGerarRelatorioManutencao.setBackground(new java.awt.Color(51, 51, 51));
        btnGerarRelatorioManutencao.setForeground(new java.awt.Color(251, 251, 251));
        btnGerarRelatorioManutencao.setText("Gerar Relatório de Manutenção");
        btnGerarRelatorioManutencao.setBorderPainted(false);
        btnGerarRelatorioManutencao.setFocusPainted(false);
        btnGerarRelatorioManutencao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGerarRelatorioManutencao.setRadius(40);
        btnGerarRelatorioManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioManutencaoActionPerformed(evt);
            }
        });
        panOpcoes.add(btnGerarRelatorioManutencao);

        btnSocilitarSuporte.setBackground(new java.awt.Color(51, 51, 51));
        btnSocilitarSuporte.setForeground(new java.awt.Color(251, 251, 251));
        btnSocilitarSuporte.setText("Socilitar Suporte");
        btnSocilitarSuporte.setBorderPainted(false);
        btnSocilitarSuporte.setFocusPainted(false);
        btnSocilitarSuporte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSocilitarSuporte.setRadius(40);
        btnSocilitarSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSocilitarSuporteActionPerformed(evt);
            }
        });
        panOpcoes.add(btnSocilitarSuporte);

        btnHistoricoAtendimento1.setBackground(new java.awt.Color(51, 51, 51));
        btnHistoricoAtendimento1.setForeground(new java.awt.Color(251, 251, 251));
        btnHistoricoAtendimento1.setText("Histórico Atendimento");
        btnHistoricoAtendimento1.setBorderPainted(false);
        btnHistoricoAtendimento1.setFocusPainted(false);
        btnHistoricoAtendimento1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHistoricoAtendimento1.setRadius(40);
        btnHistoricoAtendimento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoAtendimento1ActionPerformed(evt);
            }
        });
        panOpcoes.add(btnHistoricoAtendimento1);

        btnHistoricoAtendimentoGerente.setBackground(new java.awt.Color(51, 51, 51));
        btnHistoricoAtendimentoGerente.setForeground(new java.awt.Color(251, 251, 251));
        btnHistoricoAtendimentoGerente.setText("Histórico Atendimento");
        btnHistoricoAtendimentoGerente.setBorderPainted(false);
        btnHistoricoAtendimentoGerente.setFocusPainted(false);
        btnHistoricoAtendimentoGerente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHistoricoAtendimentoGerente.setRadius(40);
        btnHistoricoAtendimentoGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoAtendimentoGerenteActionPerformed(evt);
            }
        });
        panOpcoes.add(btnHistoricoAtendimentoGerente);

        btnFeedBack1.setBackground(new java.awt.Color(51, 51, 51));
        btnFeedBack1.setForeground(new java.awt.Color(251, 251, 251));
        btnFeedBack1.setText("Deixar FeedBack");
        btnFeedBack1.setBorderPainted(false);
        btnFeedBack1.setFocusPainted(false);
        btnFeedBack1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFeedBack1.setRadius(40);
        btnFeedBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeedBack1ActionPerformed(evt);
            }
        });
        panOpcoes.add(btnFeedBack1);

        btnRealizarPagamento.setBackground(new java.awt.Color(51, 51, 51));
        btnRealizarPagamento.setForeground(new java.awt.Color(251, 251, 251));
        btnRealizarPagamento.setText("Realizar Pagamento");
        btnRealizarPagamento.setBorderPainted(false);
        btnRealizarPagamento.setFocusPainted(false);
        btnRealizarPagamento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRealizarPagamento.setRadius(40);
        btnRealizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagamentoActionPerformed(evt);
            }
        });
        panOpcoes.add(btnRealizarPagamento);

        btnSair.setBackground(new java.awt.Color(51, 51, 51));
        btnSair.setForeground(new java.awt.Color(251, 251, 251));
        btnSair.setText("Sair");
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setRadius(40);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        panOpcoes.add(btnSair);

        panUser.setOpaque(false);

        lblLoginIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        lblUserName.setFont(new java.awt.Font("Fira Sans", 0, 24)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(251, 251, 251));
        lblUserName.setText("nome_do_usuario");

        javax.swing.GroupLayout panUserLayout = new javax.swing.GroupLayout(panUser);
        panUser.setLayout(panUserLayout);
        panUserLayout.setHorizontalGroup(
            panUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoginIcone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panUserLayout.setVerticalGroup(
            panUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName)
                    .addComponent(lblLoginIcone))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CYBERNINJA(1).png"))); // NOI18N

        javax.swing.GroupLayout panFundoLayout = new javax.swing.GroupLayout(panFundo);
        panFundo.setLayout(panFundoLayout);
        panFundoLayout.setHorizontalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panFundoLayout.setVerticalGroup(
            panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addComponent(panUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(panOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panFundoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(169, 169, 169))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarServicoActionPerformed
        // TODO add your handling code here:
        telaServico.setVisible(true);
    }//GEN-LAST:event_btnCadastrarServicoActionPerformed

    private void btnCadastrarPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPecaActionPerformed
        // TODO add your handling code here:
        telaCadastroPeca.setVisible(true);
    }//GEN-LAST:event_btnCadastrarPecaActionPerformed

    private void btnCadastrarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTecnicoActionPerformed
        // TODO add your handling code here:
        telaTecnico.setVisible(true);
    }//GEN-LAST:event_btnCadastrarTecnicoActionPerformed

    private void btnHistoricoAtendimentoGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoAtendimentoGerenteActionPerformed
        telaHistoricoGerente.setVisible(true);
    }//GEN-LAST:event_btnHistoricoAtendimentoGerenteActionPerformed

    private void btnGerarRelatorioRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioRedeActionPerformed
        // TODO add your handling code here:
        telaRelatorioRede.setVisible(true);
    }//GEN-LAST:event_btnGerarRelatorioRedeActionPerformed

    private void btnSocilitarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSocilitarServicoActionPerformed
        // TODO add your handling code here:
        socilitarServicoCliente.setVisible(true);
    }//GEN-LAST:event_btnSocilitarServicoActionPerformed

    private void btnCadastrarDispositivoDeRedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarDispositivoDeRedeActionPerformed
        // TODO add your handling code here:
        telaDispositivoRede.setVisible(true);
    }//GEN-LAST:event_btnCadastrarDispositivoDeRedeActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed
        // TODO add your handling code here:
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnGerarRelatorioManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioManutencaoActionPerformed
        // TODO add your handling code here:
        telaRelatorioManutencao.setVisible(true);
    }//GEN-LAST:event_btnGerarRelatorioManutencaoActionPerformed

    private void btnSocilitarSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSocilitarSuporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSocilitarSuporteActionPerformed

    private void btnFeedBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeedBack1ActionPerformed
        telaFeed.setVisible(true);
    }//GEN-LAST:event_btnFeedBack1ActionPerformed

    private void btnHistoricoAtendimento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoAtendimento1ActionPerformed
        telaHistoricoCliente.setVisible(true);
    }//GEN-LAST:event_btnHistoricoAtendimento1ActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        SessionManager.close();
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRealizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagamentoActionPerformed
        // TODO add your handling code here:
        telaPix.setVisible(true);
    }//GEN-LAST:event_btnRealizarPagamentoActionPerformed

    /*public void fecharTodasAsJanelas()  {
        telaCliente.habilitarCampos(false);
        telaCliente.dispose();
        telaTecnico.habilitarCampos(false);
        telaTecnico.dispose();
    /*    telaCadastroPeca.habilitarCampos(telaCadastroPeca.getPanCampos1(),false);
        telaCadastroPeca.habilitarCampos(telaCadastroPeca.getPanCampos2(),false);
        telaCadastroPeca.dispose();
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.graphicElements.BotaoVermelho btnCadastrarCliente;
    private view.graphicElements.BotaoVermelho btnCadastrarDispositivoDeRede;
    private view.graphicElements.BotaoVermelho btnCadastrarPeca;
    private view.graphicElements.BotaoVermelho btnCadastrarServico;
    private view.graphicElements.BotaoVermelho btnCadastrarTecnico;
    private view.graphicElements.BotaoVermelho btnFeedBack1;
    private view.graphicElements.BotaoVermelho btnGerarRelatorioManutencao;
    private view.graphicElements.BotaoVermelho btnGerarRelatorioRede;
    private view.graphicElements.BotaoVermelho btnHistoricoAtendimento1;
    private view.graphicElements.BotaoVermelho btnHistoricoAtendimentoGerente;
    private view.graphicElements.BotaoVermelho btnRealizarPagamento;
    private view.graphicElements.BotaoVermelho btnSair;
    private view.graphicElements.BotaoVermelho btnSocilitarServico;
    private view.graphicElements.BotaoVermelho btnSocilitarSuporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLoginIcone;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel panFundo;
    private javax.swing.JPanel panOpcoes;
    private javax.swing.JPanel panUser;
    // End of variables declaration//GEN-END:variables
}
