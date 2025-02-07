package mtp.projetofinal.utils;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import mtp.projetofinal.controller.LojaController;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.view.Loja;

/**
 *
 * @author luizf
 */
public class AddOuEditProduto extends javax.swing.JFrame {

    private final Loja loja;
    private final PanelProduto pp;
    private final int acao;
    private String fotoDoProduto = null;
    private Produto produto;

    public static final int ADD = 1;
    public static final int EDIT = 2;

    /**
     * Creates new form AddOuEditProduto
     *
     * @param loja
     * @param pp Panel Produto pode ser nulo
     * @param produto
     * @param acao Adicionar ou Editar produto
     */
    public AddOuEditProduto(Loja loja, PanelProduto pp, Produto produto, int acao) {
        this.loja = loja;
        this.pp = pp;
        this.produto = produto;
        this.acao = acao;

        initComponents();

        setLocationRelativeTo(loja);

        if (this.pp != null) {
            setLocationRelativeTo(pp);
        }

        FrameUtils.setFrameIcon(this);

        if (acao == ADD) {
            jButtonAdicionarSalvar.setText("Adicionar");
        } else if (acao == EDIT) {
            
            pp.jDialogDetalhesProduto.setEnabled(false);
            
            jButtonAdicionarSalvar.setText("Salvar Alterações");
            jTextFieldNome.setText(this.produto.getNome());
            jTextAreaDescricao.setText(this.produto.getDescricao());
            jTextFieldPreco.setText(String.valueOf(this.produto.getPreco()));
            if (produto.getFoto() == null) {
                jLabelFotoAdicionando.setIcon(new ImageIcon(getClass().getResource("/produto-sem-foto.png")));
                fotoDoProduto = null;
            } else {
                jLabelFotoAdicionando.setIcon(new ImageIcon("produtos/" + produto.getFoto()));
                fotoDoProduto = produto.getFoto();
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(acao == ADD) {
                    loja.setEnabled(true);
                }
                
                if (pp != null) {
                    pp.jDialogDetalhesProduto.setEnabled(true);
                }
            }
        });

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonCarregarArquivo = new javax.swing.JButton();
        jButtonAdicionarSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPaneDescricao = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jSeparatorDecoracao = new javax.swing.JSeparator();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelFotoAdicionando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar ou Editar Produto");
        setResizable(false);

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setMinimumSize(new java.awt.Dimension(650, 450));

        jLabelNome.setText("Nome:");

        jLabelDescricao.setText("Descrição");

        jLabelFoto.setText("Foto (opcional)");

        jLabelInfo.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelInfo.setText("Utilize . (ponto) para as casas decimais");

        jLabelPreco.setText("Preço R$:");

        jButtonCarregarArquivo.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCarregarArquivo.setText("Carregar Arquivo");
        jButtonCarregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCarregarArquivoActionPerformed(evt);
            }
        });

        jButtonAdicionarSalvar.setBackground(new java.awt.Color(81, 95, 255));
        jButtonAdicionarSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonAdicionarSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionarSalvar.setText("Adicionar / Salvar Alterações");
        jButtonAdicionarSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setTabSize(2);
        jScrollPaneDescricao.setViewportView(jTextAreaDescricao);

        jLabelFotoAdicionando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produto-sem-foto.png"))); // NOI18N

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jButtonAdicionarSalvar)
                .addGap(89, 89, 89)
                .addComponent(jButtonCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jSeparatorDecoracao, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabelInfo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelDescricao)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabelPreco)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldNome)
                            .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                        .addComponent(jLabelFoto)
                                        .addGap(26, 26, 26)))
                                .addGap(30, 30, 30))
                            .addComponent(jLabelFotoAdicionando, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(49, 49, 49))))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabelDescricao)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabelFotoAdicionando)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFoto)
                        .addGap(9, 9, 9)
                        .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorDecoracao, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAdicionarSalvar))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 420, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarSalvarActionPerformed

        if (acao == ADD) {
            try {

                Produto p = new Produto();
                p.setNome(jTextFieldNome.getText());
                p.setDescricao(jTextAreaDescricao.getText());

                p.setPreco(BigDecimal.valueOf(Double.parseDouble(jTextFieldPreco.getText())));

                if (fotoDoProduto != null) {
                    p.setFoto(fotoDoProduto);
                }

                if (p.getNome().isBlank() || p.getDescricao().isBlank()) {
                    Msg.exibirMensagem("Nome e descrição são obrigatórios", "Aviso", 2);
                } else {
                    LojaController lc = new LojaController();

                    if (lc.novoProduto(p)) {
                        Msg.exibirMensagem("Produto adicionado com sucesso!", "Sucesso", 1);
                        dispose();
                        loja.carregarProdutos();
                        loja.setEnabled(true);
                    }
                }
            } catch (NumberFormatException e) {
                Msg.exibirMensagem("O valor inserido no campo Preço é inválido", "Aviso", 2);
            }
        }

        if (acao == EDIT) {

            String pnome = jTextFieldNome.getText();
            String pdescricao = jTextAreaDescricao.getText();

            try {
                BigDecimal ppreco = BigDecimal.valueOf(Double.parseDouble(jTextFieldPreco.getText()));

                if (pnome.isBlank() || pdescricao.isBlank()) {
                    Msg.exibirMensagem("Nome e descrição devem ser preenchidos", "Aviso", 2);
                } else {
                    Produto p = new Produto();
                    ProdutoController pc = new ProdutoController();

                    p.setId(produto.getId());
                    p.setNome(pnome);
                    p.setDescricao(pdescricao);
                    p.setPreco(ppreco);
                    p.setFoto(fotoDoProduto);

                    if (pc.editarProduto(p)) {
                        Msg.exibirMensagem("Produto editado com sucesso!", "Sucesso", 1);
                        dispose();
                        produto = pc.getProdutoAtualizado();
                        pp.jDialogDetalhesProduto.setEnabled(true);
                        pp.atualizarDetalhesProduto();
                        this.loja.carregarProdutos();
                    }
                }
            } catch (NumberFormatException e) {
                Msg.exibirMensagem("Insira um preço válido!", "Aviso", 2);
            }
        }
    }//GEN-LAST:event_jButtonAdicionarSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        dispose();

        if(acao == ADD) {
            loja.setEnabled(true);
        }

        if (pp != null) {
            pp.jDialogDetalhesProduto.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCarregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCarregarArquivoActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int retorno = fc.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            String nomeFoto = new LojaController().salvarFoto(fc.getSelectedFile());

            if (nomeFoto != null) {
                jLabelFotoAdicionando.setIcon(new ImageIcon("produtos/" + nomeFoto));
                fotoDoProduto = nomeFoto;

            }
        }
    }//GEN-LAST:event_jButtonCarregarArquivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarSalvar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCarregarArquivo;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelFotoAdicionando;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPaneDescricao;
    private javax.swing.JSeparator jSeparatorDecoracao;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
