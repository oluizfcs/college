package mtp.projetofinal.utils;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.view.Loja;

/**
 *
 * @author luiz
 */
public class PanelProduto extends javax.swing.JPanel {

    private final Loja loja;

    private Produto produto;

    private final Usuario usuario;

    /**
     * Creates new form PanelProduto
     *
     * @param loja
     * @param produto
     * @param usuario
     */
    public PanelProduto(Loja loja, Produto produto, Usuario usuario) {

        this.loja = loja;
        this.produto = produto;
        this.usuario = usuario;

        initComponents();

        jLabelNome.setText(produto.getNome());
        jLabelPreco.setText("R$: " + String.valueOf(produto.getPreco()));

        // Coloca a foto padrão caso o produto não tenha foto
        if (produto.getFoto() != null) {
            jLabelFoto.setIcon(new ImageIcon("produtos/" + produto.getFoto()));
        }
        
        setVisible(true);
    }

    /**
     * Coloca as informações do produto no card de detalhamento
     */
    public void atualizarDetalhesProduto() {
        jTextAreaDescricao.setText(this.produto.getDescricao());
        jLabelInfoPreco.setText("R$: " + String.valueOf(this.produto.getPreco()));

        if (!this.usuario.getAdmin()) {
            jButtonEditar.setVisible(false);
            jButtonExcluir.setVisible(false);
        }

        jDialogDetalhesProduto.setTitle(this.produto.getNome());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogDetalhesProduto = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jButtonAddCarrinho = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jLabelInfoPreco = new javax.swing.JLabel();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelPreco = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();

        jDialogDetalhesProduto.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialogDetalhesProduto.setTitle(this.produto.getNome());
        jDialogDetalhesProduto.setMinimumSize(new java.awt.Dimension(422, 476));
        jDialogDetalhesProduto.setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 465));

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
        jButtonAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCarrinhoActionPerformed(evt);
            }
        });

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

        jButtonEditar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(255, 19, 19));
        jButtonExcluir.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonExcluir))
                            .addComponent(jButtonAddCarrinho))
                        .addGap(86, 86, 86)
                        .addComponent(jButtonFechar)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelInfoPreco, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitulo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelInfoPreco)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCarrinho)
                    .addComponent(jButtonFechar))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogDetalhesProdutoLayout = new javax.swing.GroupLayout(jDialogDetalhesProduto.getContentPane());
        jDialogDetalhesProduto.getContentPane().setLayout(jDialogDetalhesProdutoLayout);
        jDialogDetalhesProdutoLayout.setHorizontalGroup(
            jDialogDetalhesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogDetalhesProdutoLayout.setVerticalGroup(
            jDialogDetalhesProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogDetalhesProdutoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        jLabelPreco.setForeground(new java.awt.Color(153, 153, 153));
        jLabelPreco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPreco.setText("R$: 0,00");
        jLabelPreco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNome.setFont(new java.awt.Font("Liberation Sans", 1, 10)); // NOI18N
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNome.setText("Nome");

        jLabelFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produto-sem-foto.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabelFoto)
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNome)
                .addGap(18, 18, 18)
                .addComponent(jLabelFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabelPreco)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cria uma borda azul em volta do card do produto quando o mouse está em
     * cima dele
     */
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBorder(BorderFactory.createLineBorder(new Color(81, 95, 255), 1, true));
    }//GEN-LAST:event_formMouseEntered

    /**
     * Remove a borda quando o mouse sai de cima do card
     */
    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }//GEN-LAST:event_formMouseExited

    /**
     * Abre o dialog de detalhes do produto
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        jDialogDetalhesProduto.setLocationRelativeTo(this);

        atualizarDetalhesProduto();
        loja.setEnabled(false);

        jDialogDetalhesProduto.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    /**
     * Fecha a aba de "detalhamento" do produto
     */
    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        jDialogDetalhesProduto.setVisible(false);
        loja.setEnabled(true);
    }//GEN-LAST:event_jButtonFecharActionPerformed

    /**
     * Abre a janela que permite editar o produto
     */
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        setEnabled(false);
        loja.setEnabled(false);
        new AddOuEditProduto(loja, this, produto, AddOuEditProduto.EDIT);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * Após uma confirmação, exclui o produto.
     */
    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Você tem certeza que deseja excluir este produto?", "Operação destrutiva", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == 0) {
            if (ProdutoController.excluir(this.produto)) {
                Msg.exibirMensagem("Produto excluido com sucesso", "Sucesso", 1);
                jDialogDetalhesProduto.setVisible(false);
                loja.carregarProdutos();
                loja.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * Adiciona o produto ao carrinho.
     */
    private void jButtonAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCarrinhoActionPerformed

        ProdutoController pc = new ProdutoController();

        if (pc.adicionarCarrinho(this.usuario.getId(), this.produto.getId())) {
            Msg.exibirMensagem("Produto adicionado ao carrinho com sucesso.", "Sucesso!", 1);
            jDialogDetalhesProduto.setVisible(false);
            loja.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonAddCarrinhoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCarrinho;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    public javax.swing.JDialog jDialogDetalhesProduto;
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
