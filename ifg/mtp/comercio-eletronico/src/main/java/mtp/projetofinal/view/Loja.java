package mtp.projetofinal.view;

import mtp.projetofinal.controller.LojaController;
import mtp.projetofinal.Msg;
import mtp.projetofinal.model.Usuario;

/**
 *
 * @author luiz
 */
public class Loja extends javax.swing.JFrame {

    Usuario usuario;

    /**
     * Creates new form Loja
     *
     * @param usuario Dados do usuário logado
     */
    public Loja(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        jLabelUsername.setText(usuario.getNome());
        jTextFieldNome.setText(usuario.getNome());
        jTextFieldEmail.setText(usuario.getEmail());
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogConfig = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonAlterarNome = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelSenhaAtual = new javax.swing.JLabel();
        jLabelNovaSenha = new javax.swing.JLabel();
        jLabelConfirmarNovaSenha = new javax.swing.JLabel();
        jPasswordFieldSenhaAtual = new javax.swing.JPasswordField();
        jPasswordFieldNovaSenha = new javax.swing.JPasswordField();
        jPasswordFieldConfirmarNovaSenha = new javax.swing.JPasswordField();
        jButtonSalvarSenha = new javax.swing.JButton();
        jButtonCancelar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        jPanelNavBar = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelConfig = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jDialogConfig.setTitle("Configurações");
        jDialogConfig.setMinimumSize(new java.awt.Dimension(505, 467));
        jDialogConfig.setModal(true);
        jDialogConfig.setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNome.setText("Nome:");

        jTextFieldNome.setText("usuario");

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setText("usuario@email.com");
        jTextFieldEmail.setFocusable(false);

        jLabelEmail.setText("Email:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel2.setText("O e-mail não pode ser editado.");

        jButtonAlterarNome.setBackground(new java.awt.Color(81, 95, 255));
        jButtonAlterarNome.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonAlterarNome.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAlterarNome.setText("Alterar Nome");
        jButtonAlterarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarNomeActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabel2))
                        .addContainerGap(264, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAlterarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(63, 63, 63))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterarNome)
                    .addComponent(jButtonCancelar))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Nome e Email", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSenhaAtual.setText("Senha atual:");

        jLabelNovaSenha.setText("Nova senha:");

        jLabelConfirmarNovaSenha.setText("Confirme a nova senha:");

        jButtonSalvarSenha.setBackground(new java.awt.Color(81, 95, 255));
        jButtonSalvarSenha.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonSalvarSenha.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarSenha.setText("Alterar Senha");
        jButtonSalvarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarSenhaActionPerformed(evt);
            }
        });

        jButtonCancelar1.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar1.setText("Cancelar");
        jButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSenhaAtual)
                            .addComponent(jLabelNovaSenha)
                            .addComponent(jLabelConfirmarNovaSenha)
                            .addComponent(jPasswordFieldSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(309, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonSalvarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar1)
                        .addGap(63, 63, 63))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelSenhaAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabelNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelConfirmarNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarSenha)
                    .addComponent(jButtonCancelar1))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Senha", jPanel3);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Alteração de dados");

        javax.swing.GroupLayout jDialogConfigLayout = new javax.swing.GroupLayout(jDialogConfig.getContentPane());
        jDialogConfig.getContentPane().setLayout(jDialogConfigLayout);
        jDialogConfigLayout.setHorizontalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jDialogConfigLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogConfigLayout.setVerticalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfigLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comercio Eletrônico");
        setMinimumSize(new java.awt.Dimension(610, 422));

        jLabelUsername.setText("nome");

        jButtonSair.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSair.setForeground(new java.awt.Color(81, 95, 255));
        jButtonSair.setText("sair");
        jButtonSair.setBorder(null);
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
        jLabelConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConfigMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNavBarLayout = new javax.swing.GroupLayout(jPanelNavBar);
        jPanelNavBar.setLayout(jPanelNavBarLayout);
        jPanelNavBarLayout.setHorizontalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsername)
                    .addComponent(jButtonSair))
                .addContainerGap(503, Short.MAX_VALUE))
        );
        jPanelNavBarLayout.setVerticalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavBarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelConfig)
                    .addGroup(jPanelNavBarLayout.createSequentialGroup()
                        .addComponent(jLabelUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSair)))
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Volta para a tela inicial
     */
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new TelaInicial();
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * Mostra o dialog de configurações
     */
    private void jLabelConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfigMouseClicked
        jDialogConfig.setLocationRelativeTo(this);
        jDialogConfig.setVisible(true);
    }//GEN-LAST:event_jLabelConfigMouseClicked

    /**
     * Esconde a tela de configurações
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jDialogConfig.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Valida o campo nome e manda para a controller
     */
    private void jButtonAlterarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarNomeActionPerformed

        String nome = jTextFieldNome.getText();

        if (!nome.equals("")) {
            LojaController lc = new LojaController();

            if (lc.alterarNome()) {
                Msg.exibirMensagem("Nome alterado com sucesso!", "Sucesso!", 1);
            }
        } else {
            Msg.exibirMensagem("O campo nome não pode estar vazio", "Aviso", 2);
        }

    }//GEN-LAST:event_jButtonAlterarNomeActionPerformed

    /**
     * Valida os campos e manda os dados para a controller
     */
    private void jButtonSalvarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSenhaActionPerformed
        String senhaAtual = String.valueOf(jPasswordFieldSenhaAtual.getPassword());
        String novaSenha = String.valueOf(jPasswordFieldNovaSenha.getPassword());
        String confirmarNovaSenha = String.valueOf(jPasswordFieldConfirmarNovaSenha.getPassword());

        if (senhaAtual.equals("") || novaSenha.equals("") || confirmarNovaSenha.equals("")) {
            Msg.exibirMensagem("Todos os campos devem estar preenchidos", "Aviso", 2);
        } else if (!senhaAtual.equals(this.usuario.getSenha())) {
            Msg.exibirMensagem("A senha atual está incorreta!", "Aviso", 2);
        } else if (!novaSenha.equals(confirmarNovaSenha)) {
            Msg.exibirMensagem("A senha nova não coincide", "Aviso", 2);
        } else {
            LojaController lc = new LojaController();

            if (lc.alterarSenha()) {
                Msg.exibirMensagem("Sua senha foi alterada com sucesso!", "Sucesso!", 1);
            }
        }
    }//GEN-LAST:event_jButtonSalvarSenhaActionPerformed

    /**
     * Esconde a tela de configurações
     */
    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
        jDialogConfig.setVisible(false);
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarNome;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvarSenha;
    private javax.swing.JDialog jDialogConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelConfirmarNovaSenha;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNovaSenha;
    private javax.swing.JLabel jLabelSenhaAtual;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelNavBar;
    private javax.swing.JPasswordField jPasswordFieldConfirmarNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldSenhaAtual;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
