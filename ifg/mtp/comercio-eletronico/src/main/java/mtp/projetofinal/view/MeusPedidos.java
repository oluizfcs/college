package mtp.projetofinal.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import mtp.projetofinal.controller.PedidoController;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.utils.FrameUtils;
import mtp.projetofinal.utils.ItemPedidoFinalizado;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.utils.WrapLayout;

/**
 *
 * @author luizf
 */
public class MeusPedidos extends javax.swing.JFrame {

    Usuario usuario;

    /**
     * Creates new form MeusPedidos
     *
     * @param loja
     * @param usuario
     */
    public MeusPedidos(Loja loja, Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        carregarPedidos();
        setLocationRelativeTo(loja);
        FrameUtils.setFrameIcon(this);
        jScrollPaneListaPedidos.getVerticalScrollBar().setUnitIncrement(16);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loja.setEnabled(true);
            }
        });
    }

    private void carregarPedidos() {
        ArrayList<Pedido> pedidos = PedidoController.getPedidos(usuario);

        if (pedidos != null) {

            jLabelSemPedidos.setVisible(false);
            
            jPanelPedidos.setPreferredSize(new Dimension(330, (50 * pedidos.size())));

            Color x = Color.WHITE;
            for (Pedido p : pedidos) {

                ItemPedidoFinalizado ipf = new ItemPedidoFinalizado(this, p);
                ipf.setBackground(x);
                ipf.jLabelID.setForeground(x == Color.WHITE ? Color.BLACK : Color.WHITE);
                ipf.jLabelValorTotal.setForeground(x == Color.WHITE ? Color.BLACK : Color.WHITE);

                jPanelPedidos.add(ipf);

                x = (x == Color.WHITE) ? new Color(81, 95, 255) : Color.WHITE;

                jPanelPedidos.revalidate();
                jPanelPedidos.repaint();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneListaPedidos = new javax.swing.JScrollPane();
        jPanelPedidos = new javax.swing.JPanel();
        jLabelSemPedidos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meus Pedidos");
        setResizable(false);

        jScrollPaneListaPedidos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneListaPedidos.setMinimumSize(new java.awt.Dimension(330, 342));

        jPanelPedidos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPedidos.setPreferredSize(new java.awt.Dimension(320, 340));

        jLabelSemPedidos.setText("Você não fez nenhum pedido!");
        jPanelPedidos.add(jLabelSemPedidos);

        jScrollPaneListaPedidos.setViewportView(jPanelPedidos);
        jPanelPedidos.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneListaPedidos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPaneListaPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelSemPedidos;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JScrollPane jScrollPaneListaPedidos;
    // End of variables declaration//GEN-END:variables
}
