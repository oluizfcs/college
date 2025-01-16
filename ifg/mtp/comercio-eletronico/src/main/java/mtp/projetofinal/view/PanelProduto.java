package mtp.projetofinal.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import mtp.projetofinal.model.Produto;

/**
 *
 * @author luiz
 */
public class PanelProduto extends javax.swing.JPanel {

    private Produto produto;
    
    /**
     * Creates new form PanelProduto
     *
     * @param produto
     */
    public PanelProduto(Produto produto) {
        initComponents();

        this.produto = produto;
        
        jLabelNome.setText(produto.getNome());
        jLabelPreco.setText("R$: " + String.valueOf(produto.getPreco()));

        if(produto.getFoto() != null) {
            jLabelFoto.setIcon(new ImageIcon(getClass().getResource("/produtos/" + produto.getFoto())));
        }
        
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddCarrinho = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jButtonAddCarrinho = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabelInfoPreco = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();

        jDialogAddCarrinho.setTitle("Informações do produto");
        jDialogAddCarrinho.setMinimumSize(new java.awt.Dimension(400, 410));
        jDialogAddCarrinho.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 410));

        jLabelTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelTitulo.setText("Descrição");

        jTextAreaDescricao.setEditable(false);
        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setFocusable(false);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jButtonAddCarrinho.setBackground(new java.awt.Color(81, 95, 255));
        jButtonAddCarrinho.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonAddCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAddCarrinho.setText("Adicionar ao Carrinho");

        jButtonFechar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabelInfoPreco.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        jLabelInfoPreco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfoPreco.setText("R$: 0,00");
        jLabelInfoPreco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabelTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonAddCarrinho)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonFechar))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jLabelInfoPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelInfoPreco)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCarrinho)
                    .addComponent(jButtonFechar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jDialogAddCarrinhoLayout = new javax.swing.GroupLayout(jDialogAddCarrinho.getContentPane());
        jDialogAddCarrinho.getContentPane().setLayout(jDialogAddCarrinhoLayout);
        jDialogAddCarrinhoLayout.setHorizontalGroup(
            jDialogAddCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddCarrinhoLayout.setVerticalGroup(
            jDialogAddCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setForeground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(230, 280));
        setMinimumSize(new java.awt.Dimension(230, 280));
        setPreferredSize(new java.awt.Dimension(230, 280));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        jLabelPreco.setFont(new java.awt.Font("Noto Mono", 1, 15)); // NOI18N
        jLabelPreco.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPreco.setText("R$: 0,00");
        jLabelPreco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNome.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabelNome.setText("Nome");

        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produto-sem-foto.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelNome)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabelFoto)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addGap(18, 18, 18)
                .addComponent(jLabelFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabelPreco)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBorder(BorderFactory.createLineBorder(new Color(81, 95, 255), 1, true));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jDialogAddCarrinho.setLocationRelativeTo(this);
        jTextAreaDescricao.setText(this.produto.getDescricao());
        jLabelInfoPreco.setText("R$: " + String.valueOf(this.produto.getPreco()));
        jDialogAddCarrinho.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        jDialogAddCarrinho.setVisible(false);
    }//GEN-LAST:event_jButtonFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCarrinho;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JDialog jDialogAddCarrinho;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelInfoPreco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    // End of variables declaration//GEN-END:variables
}
