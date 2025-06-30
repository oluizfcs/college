package mtp.projetofinal.utils;

import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.controller.UsuarioController;
import mtp.projetofinal.model.PedidoProduto;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.view.CarrinhoView;

/**
 *
 * @author luiz
 */
public class PanelProdutoCarrinho extends javax.swing.JPanel {

    Produto produto;
    CarrinhoView cv;
    BigDecimal subtotal;
    Integer quantidade;

    /**
     * Creates new form PanelProdutoCarrinho
     *
     * @param cv
     * @param produto
     * @param quantidade
     * @param modificavel
     */
    public PanelProdutoCarrinho(CarrinhoView cv, Produto produto, Integer quantidade, Boolean modificavel) {

        this.cv = cv;
        this.produto = produto;
        this.quantidade = quantidade;

        initComponents();

        jLabelNome.setText(this.produto.getNome());
        jLabelPreco.setText("R$: " + String.valueOf(this.produto.getPreco()));

        // Coloca a foto padrão caso o produto não tenha foto
        if (produto.getFoto() != null) {
            jLabelFoto.setIcon(new ImageIcon("produtos/" + produto.getFoto()));
        }

        atualizarQuantidade();
        
        jButtonMais.setEnabled(modificavel);
        jButtonMenos.setEnabled(modificavel);
    }

    private void atualizarQuantidade() {
        jLabelQuantidade.setText(String.valueOf(quantidade));
        subtotal = BigDecimal.valueOf(quantidade).multiply(produto.getPreco());
        jLabelPrecoSubtotal.setText("R$: " + subtotal);

        cv.produtos.replace(produto, quantidade);
        cv.atualizarValorTotal();
    }

    /**
     * @return O valor unitário do produto vezes a quantidade dele no carrinho
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelPreco = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelValorUnitario = new javax.swing.JLabel();
        jLabelQuantidade = new javax.swing.JLabel();
        jLabelSubtotal = new javax.swing.JLabel();
        jLabelPrecoSubtotal = new javax.swing.JLabel();
        jButtonMenos = new javax.swing.JButton();
        jButtonMais = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(645, 200));
        setMinimumSize(new java.awt.Dimension(645, 200));
        setPreferredSize(new java.awt.Dimension(645, 200));

        jLabelPreco.setFont(new java.awt.Font("Noto Mono", 1, 15)); // NOI18N
        jLabelPreco.setForeground(new java.awt.Color(153, 153, 153));
        jLabelPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPreco.setText("R$: 0,00");
        jLabelPreco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNome.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNome.setText("Nome");

        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produto-sem-foto.png"))); // NOI18N

        jLabelValorUnitario.setText("Valor Unitário");

        jLabelQuantidade.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelQuantidade.setText("1");

        jLabelSubtotal.setText("Subtotal");

        jLabelPrecoSubtotal.setFont(new java.awt.Font("Noto Mono", 1, 15)); // NOI18N
        jLabelPrecoSubtotal.setForeground(new java.awt.Color(153, 153, 153));
        jLabelPrecoSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPrecoSubtotal.setText("R$: 0,00");
        jLabelPrecoSubtotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonMenos.setBackground(new java.awt.Color(254, 255, 255));
        jButtonMenos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonMenos.setText("-");
        jButtonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosActionPerformed(evt);
            }
        });

        jButtonMais.setBackground(new java.awt.Color(254, 255, 255));
        jButtonMais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonMais.setText("+");
        jButtonMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelFoto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelValorUnitario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(jButtonMenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelSubtotal))
                    .addComponent(jLabelPrecoSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelFoto)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelValorUnitario))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelPrecoSubtotal)
                                        .addGap(8, 8, 8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelQuantidade)
                                            .addComponent(jButtonMenos)
                                            .addComponent(jButtonMais))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jLabelSubtotal)))
                        .addGap(45, 45, 45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNome)
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosActionPerformed
        if (Integer.parseInt(jLabelQuantidade.getText()) > 1) {
            quantidade--;
            atualizarQuantidade();
        } else {
            if (JOptionPane.showConfirmDialog(this, "Deseja remover o produto do carrinho?", "Confirmação", JOptionPane.YES_NO_OPTION) == 0) {

                PedidoProduto pp = new PedidoProduto();

                pp.setIdproduto(produto.getId());
                pp.setIdpedido(UsuarioController.getIdCarrinho(cv.getUsuario()));

                ProdutoController.removerDoCarrinho(pp);

                cv.carregarProdutos();
                cv.getLoja().carregarProdutos();
            }
        }
    }//GEN-LAST:event_jButtonMenosActionPerformed

    private void jButtonMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisActionPerformed
        if (Integer.parseInt(jLabelQuantidade.getText()) < 100) {
            quantidade++;
            atualizarQuantidade();
            jButtonMenos.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonMaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMais;
    private javax.swing.JButton jButtonMenos;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelPrecoSubtotal;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelValorUnitario;
    // End of variables declaration//GEN-END:variables
}
