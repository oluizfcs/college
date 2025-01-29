package mtp.projetofinal.utils;

import java.awt.Color;
import java.math.BigDecimal;
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
            jLabelFoto.setIcon(new ImageIcon(getClass().getResource("/produtos/" + produto.getFoto())));
        }

        setVisible(true);
    }

    /**
     * Coloca as informações do produto no card de detalhamento
     */
    private void atualizarDetalhesProduto() {
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
        jDialogConfigProduto = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabelProdutoNome = new javax.swing.JLabel();
        jTextFieldProdutoNome = new javax.swing.JTextField();
        jLabelProdutoDescricao = new javax.swing.JLabel();
        jLabelProdutoFoto = new javax.swing.JLabel();
        jButtonCarregarArquivo = new javax.swing.JButton();
        jButtonSalvarAlteracoes = new javax.swing.JButton();
        jButtonCancelarProduto = new javax.swing.JButton();
        jLabelProdutoInfo = new javax.swing.JLabel();
        jLabelProdutoPreco = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaProdutoDescricao = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldProdutoPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();

        jDialogDetalhesProduto.setTitle(this.produto.getNome());
        jDialogDetalhesProduto.setAlwaysOnTop(true);
        jDialogDetalhesProduto.setMinimumSize(new java.awt.Dimension(400, 465));
        jDialogDetalhesProduto.setModal(true);
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
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonExcluir))
                            .addComponent(jButtonAddCarrinho))
                        .addGap(110, 110, 110)
                        .addComponent(jButtonFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelInfoPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitulo))
                        .addGap(8, 8, 8)))
                .addGap(9, 9, 9))
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

        jDialogConfigProduto.setTitle("Editar Produto");
        jDialogConfigProduto.setAlwaysOnTop(true);
        jDialogConfigProduto.setMinimumSize(new java.awt.Dimension(650, 450));
        jDialogConfigProduto.setModal(true);
        jDialogConfigProduto.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(650, 450));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 450));

        jLabelProdutoNome.setText("Nome:");

        jLabelProdutoDescricao.setText("Descrição");

        jLabelProdutoFoto.setText("Foto (opcional)");

        jButtonCarregarArquivo.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCarregarArquivo.setText("Carregar Arquivo");

        jButtonSalvarAlteracoes.setBackground(new java.awt.Color(81, 95, 255));
        jButtonSalvarAlteracoes.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonSalvarAlteracoes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarAlteracoes.setText("Salvar Alterações");
        jButtonSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarAlteracoesActionPerformed(evt);
            }
        });

        jButtonCancelarProduto.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelarProduto.setText("Cancelar");
        jButtonCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarProdutoActionPerformed(evt);
            }
        });

        jLabelProdutoInfo.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jLabelProdutoInfo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelProdutoInfo.setText("Utilize . (ponto) para as casas decimais");

        jLabelProdutoPreco.setText("Preço R$:");

        jTextAreaProdutoDescricao.setColumns(20);
        jTextAreaProdutoDescricao.setLineWrap(true);
        jTextAreaProdutoDescricao.setRows(5);
        jTextAreaProdutoDescricao.setTabSize(2);
        jScrollPane3.setViewportView(jTextAreaProdutoDescricao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButtonSalvarAlteracoes)
                .addGap(89, 89, 89)
                .addComponent(jButtonCancelarProduto)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabelProdutoInfo))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelProdutoNome)
                        .addComponent(jLabelProdutoDescricao)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelProdutoPreco)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextFieldProdutoNome)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelProdutoFoto)
                        .addGap(26, 26, 26)))
                .addGap(59, 59, 59))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelProdutoFoto)
                        .addGap(9, 9, 9)
                        .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelProdutoNome)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabelProdutoDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProdutoPreco)
                            .addComponent(jTextFieldProdutoPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProdutoInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarProduto)
                    .addComponent(jButtonSalvarAlteracoes))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jDialogConfigProdutoLayout = new javax.swing.GroupLayout(jDialogConfigProduto.getContentPane());
        jDialogConfigProduto.getContentPane().setLayout(jDialogConfigProdutoLayout);
        jDialogConfigProdutoLayout.setHorizontalGroup(
            jDialogConfigProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfigProdutoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDialogConfigProdutoLayout.setVerticalGroup(
            jDialogConfigProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfigProdutoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jDialogDetalhesProduto.setVisible(true);
    }//GEN-LAST:event_formMouseClicked

    /**
     * Fecha a aba de "detalhamento" do produto
     */
    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        jDialogDetalhesProduto.setVisible(false);
    }//GEN-LAST:event_jButtonFecharActionPerformed

    /**
     * Abre a janela que permite editar o produto
     */
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jTextFieldProdutoNome.setText(this.produto.getNome());
        jTextAreaProdutoDescricao.setText(this.produto.getDescricao());
        jTextFieldProdutoPreco.setText(String.valueOf(this.produto.getPreco()));

        jDialogConfigProduto.setVisible(true);
        jDialogConfigProduto.setLocationRelativeTo(jDialogDetalhesProduto);
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
                this.loja.carregarProdutos();
            }
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**
     * Manda os dados dos campos para a ProdutoController lidar com a alteração.
     */
    private void jButtonSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarAlteracoesActionPerformed
        String pnome = jTextFieldProdutoNome.getText();
        String pdescricao = jTextAreaProdutoDescricao.getText();
        try {
            BigDecimal ppreco = BigDecimal.valueOf(Double.parseDouble(jTextFieldProdutoPreco.getText()));

            if (pnome.isBlank() || pdescricao.isBlank()) {
                Msg.exibirMensagem("Nome e descrição devem ser preenchidos", "Aviso", 2);
            } else {
                Produto p = new Produto();
                ProdutoController pc = new ProdutoController();

                p.setId(this.produto.getId());
                p.setNome(pnome);
                p.setDescricao(pdescricao);
                p.setPreco(ppreco);

                if (pc.editarProduto(p)) {
                    Msg.exibirMensagem("Produto editado com sucesso!", "Sucesso", 1);
                    jDialogConfigProduto.setVisible(false);
                    this.produto = pc.getProdutoAtualizado();
                    atualizarDetalhesProduto();
                    this.loja.carregarProdutos();
                }
            }
        } catch (NumberFormatException e) {
            Msg.exibirMensagem("Insira um preço válido!", "Aviso", 2);
        }
    }//GEN-LAST:event_jButtonSalvarAlteracoesActionPerformed

    /**
     * Fecha a tela de editar o produto.
     */
    private void jButtonCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarProdutoActionPerformed
        jDialogConfigProduto.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarProdutoActionPerformed

    /**
     * Adiciona o produto ao carrinho.
     */
    private void jButtonAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCarrinhoActionPerformed

        ProdutoController pc = new ProdutoController();

        if (pc.adicionarCarrinho(this.usuario.getId(), this.produto.getId())) {
            Msg.exibirMensagem("Produto adicionado ao carrinho com sucesso.", "Sucesso!", 1);
            jDialogDetalhesProduto.setVisible(false);
        }
    }//GEN-LAST:event_jButtonAddCarrinhoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddCarrinho;
    private javax.swing.JButton jButtonCancelarProduto;
    private javax.swing.JButton jButtonCarregarArquivo;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonSalvarAlteracoes;
    private javax.swing.JDialog jDialogConfigProduto;
    private javax.swing.JDialog jDialogDetalhesProduto;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelInfoPreco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelProdutoDescricao;
    private javax.swing.JLabel jLabelProdutoFoto;
    private javax.swing.JLabel jLabelProdutoInfo;
    private javax.swing.JLabel jLabelProdutoNome;
    private javax.swing.JLabel jLabelProdutoPreco;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextArea jTextAreaProdutoDescricao;
    private javax.swing.JTextField jTextFieldProdutoNome;
    private javax.swing.JTextField jTextFieldProdutoPreco;
    // End of variables declaration//GEN-END:variables
}
