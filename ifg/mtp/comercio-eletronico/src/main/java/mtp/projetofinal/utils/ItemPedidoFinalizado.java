package mtp.projetofinal.utils;

import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.view.CarrinhoView;
import mtp.projetofinal.view.MeusPedidos;

/**
 *
 * @author luizf
 */
public class ItemPedidoFinalizado extends javax.swing.JPanel {

    Pedido pedido;
    MeusPedidos meusPedidos;

    /**
     * Creates new form ItemPedidoFinalizado
     *
     * @param meusPedidos
     * @param pedido
     */
    public ItemPedidoFinalizado(MeusPedidos meusPedidos, Pedido pedido) {
        this.pedido = pedido;
        this.meusPedidos = meusPedidos;
        initComponents();
        jLabelID.setText("#" + pedido.getId());
        jLabelValorTotal.setText("R$: " + pedido.getValortotal());
        setVisible(true);
    }

    private void detalharProduto() {
        meusPedidos.setEnabled(false);
        new CarrinhoView(meusPedidos, pedido);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelID = new javax.swing.JLabel();
        jLabelValorTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("#");
        jLabelID.setToolTipText("");
        jLabelID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIDMouseClicked(evt);
            }
        });

        jLabelValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValorTotal.setText("R$");
        jLabelValorTotal.setToolTipText("");
        jLabelValorTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelValorTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValorTotalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelID)
                    .addComponent(jLabelValorTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        detalharProduto();
    }//GEN-LAST:event_formMouseClicked

    private void jLabelIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIDMouseClicked
        detalharProduto();
    }//GEN-LAST:event_jLabelIDMouseClicked

    private void jLabelValorTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValorTotalMouseClicked
        detalharProduto();
    }//GEN-LAST:event_jLabelValorTotalMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabelID;
    public javax.swing.JLabel jLabelValorTotal;
    // End of variables declaration//GEN-END:variables
}
