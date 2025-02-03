package mtp.projetofinal.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.utils.PanelProdutoCarrinho;

/**
 *
 * @author luiz
 */
public class CarrinhoView extends javax.swing.JFrame {

    private final Loja loja;
    private final Usuario usuario;
    private HashMap<Produto, Integer> produtos;

    /**
     * Creates new form CarrinhoView
     *
     * @param loja
     * @param usuario
     */
    public CarrinhoView(Loja loja, Usuario usuario) {
        this.loja = loja;
        this.usuario = usuario;

        ProdutoController pc = new ProdutoController();

        this.produtos = pc.getProdutosNoCarrinho(usuario.getId());

        initComponents();

        this.setLocationRelativeTo(loja);

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

        carregarProdutos();

        setVisible(true);
    }

    public void carregarProdutos() {

        if (this.produtos.isEmpty()) {
            jLabelCarrinhoVazio.setVisible(true);
        } else {
            
            jPanelProdutos.setLayout(new FlowLayout());
            
            jLabelCarrinhoVazio.setVisible(false);
            
            jPanelProdutos.setPreferredSize(new Dimension(700, 200 * this.produtos.size()));

            jPanelProdutos.removeAll();

            BigDecimal total = BigDecimal.ZERO;
            
            for (Map.Entry<Produto, Integer> entry : this.produtos.entrySet()) {

                PanelProdutoCarrinho ppc = new PanelProdutoCarrinho(this, entry.getKey(), entry.getValue());

                jPanelProdutos.add(ppc);
                jPanelProdutos.validate();
                jPanelProdutos.repaint();

                total = total.add(ppc.getSubtotal());

            }

            jLabelTotal.setText("R$: " + total);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonFechar = new javax.swing.JButton();
        jButtonComprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelProdutos = new javax.swing.JPanel();
        jLabelCarrinhoVazio = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Comércio Eletrônico - Carrinho");
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 450));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 450));

        jButtonFechar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonFechar.setText("Fechar / Comprar depois");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonComprar.setBackground(new java.awt.Color(81, 95, 255));
        jButtonComprar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonComprar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonComprar.setText("Comprar");
        jButtonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProdutos.setMinimumSize(new java.awt.Dimension(700, 375));
        jPanelProdutos.setPreferredSize(new java.awt.Dimension(700, 375));

        jLabelCarrinhoVazio.setText("O seu carrinho está vazio!");

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabelCarrinhoVazio)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabelCarrinhoVazio)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanelProdutos);

        jSeparator1.setMinimumSize(new java.awt.Dimension(650, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(700, 10));

        jLabelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotal.setText("R$: 0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButtonComprar)
                .addGap(83, 83, 83)
                .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButtonFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jLabelTotal)
                    .addComponent(jButtonComprar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        this.loja.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonComprarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonComprar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabelCarrinhoVazio;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
