package mtp.projetofinal.view;

import java.util.HashMap;

/**
 *
 * @author luiz
 */
public class Loja extends javax.swing.JFrame {

    /**
     * Creates new form Loja
     * @param usuario Dados do usuário logado
     */
    public Loja(HashMap<String, String> usuario) {
        initComponents();
        jLabelUsername.setText(usuario.get("nome"));
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNavBar = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelConfig = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comercio Eletrônico");

        jLabelUsername.setText("nome");

        jButtonSair.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSair.setForeground(new java.awt.Color(81, 95, 255));
        jButtonSair.setText("sair");
        jButtonSair.setBorder(null);
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
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
                .addContainerGap(10, Short.MAX_VALUE))
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
            .addGap(0, 342, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new TelaInicial();
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jLabelConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfigMouseClicked
        new Configuracoes();
    }//GEN-LAST:event_jLabelConfigMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelNavBar;
    // End of variables declaration//GEN-END:variables
}
