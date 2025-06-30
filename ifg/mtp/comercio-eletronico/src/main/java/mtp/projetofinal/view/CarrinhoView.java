package mtp.projetofinal.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mtp.projetofinal.controller.PedidoController;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.controller.UsuarioController;
import mtp.projetofinal.model.Endereco;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.utils.FrameUtils;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.utils.PanelProdutoCarrinho;

/**
 *
 * @author luiz
 */
public class CarrinhoView extends javax.swing.JFrame {

    private Loja loja = null;
    private Usuario usuario = null;
    private MeusPedidos meusPedidos = null;

    /**
     * Relação de produtos e quantidades no carrinho
     */
    public HashMap<Produto, Integer> produtos;
    ArrayList<Endereco> enderecosDoUsuario;
    private Pedido pedido = new Pedido();
    BigDecimal total = BigDecimal.ZERO;

    /**
     * Creates new form CarrinhoView
     *
     * @param loja
     * @param usuario
     */
    public CarrinhoView(Loja loja, Usuario usuario) {
        this.loja = loja;
        this.usuario = usuario;

        initComponents();

        pedido.setId(UsuarioController.getIdCarrinho(usuario));
        pedido.setIdusuario(usuario.getId());

        FrameUtils.setFrameIcon(this);

        setLocationRelativeTo(loja);

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);

        jButtonFechar.setText("Comprar depois");

        carregarProdutos();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                salvarAlteracoes();
                loja.setEnabled(true);
            }
        });

        setVisible(true);
    }

    public CarrinhoView(MeusPedidos meusPedidos, Pedido pedido) {
        this.meusPedidos = meusPedidos;
        this.pedido = pedido;
        initComponents();
        FrameUtils.setFrameIcon(this);
        setLocationRelativeTo(meusPedidos);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        carregarProdutos();
        jButtonComprar.setVisible(false);
        jButtonFechar.setText("Fechar");
        setTitle("Detalhes do Pedido #" + pedido.getId());
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                meusPedidos.setEnabled(true);
            }
        });
    }

    /**
     * @return O usuário dono do carrinho
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @return A loja vinculada a este carrinho
     */
    public Loja getLoja() {
        return loja;
    }

    /**
     * Atualiza a lista de produtos que estão no carrinho
     */
    public void carregarProdutos() {

        jPanelProdutos.setLayout(new FlowLayout());

        jPanelProdutos.removeAll();

        Boolean modificavel = false;

        if (loja != null) {
            produtos = ProdutoController.getProdutosNoCarrinho(usuario);
            jPanelProdutos.setPreferredSize(new Dimension(700, 200 * produtos.size()));
            modificavel = true;
        }

        if (meusPedidos != null) {
            produtos = pedido.produtos();
            jPanelProdutos.setPreferredSize(new Dimension(700, 200 * (produtos.size() + 1)));
            modificavel = false;
        }

        if (produtos != null) {

            for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {

                PanelProdutoCarrinho ppc = new PanelProdutoCarrinho(this, entry.getKey(), entry.getValue(), modificavel);

                jPanelProdutos.add(ppc);
            }

            atualizarValorTotal();

            if (meusPedidos != null) {

                Endereco e = pedido.endereco();

                String estado = e.getEstado();
                
                estado = switch (estado) {
                    case "AC" -> "Acre";
                    case "AL" -> "Alagoas";
                    case "AP" -> "Amapá";
                    case "AM" -> "Amazonas";
                    case "BA" -> "Bahia";
                    case "CE" -> "Ceará";
                    case "DF" -> "Distrito Federal";
                    case "ES" -> "Espírito Santo";
                    case "GO" -> "Goiás";
                    case "MA" -> "Maranhão";
                    case "MT" -> "Mato Grosso";
                    case "MS" -> "Mato Grosso do Sul";
                    case "MG" -> "Minas Gerais";
                    case "PA" -> "Pará";
                    case "PB" -> "Paraíba";
                    case "PR" -> "Paraná";
                    case "PE" -> "Pernambuco";
                    case "PI" -> "Piauí";
                    case "RJ" -> "Rio de Janeiro";
                    case "RN" -> "Rio Grande do Norte";
                    case "RS" -> "Rio Grande do Sul";
                    case "RO" -> "Rondônia";
                    case "RR" -> "Roraima";
                    case "SC" -> "Santa Catarina";
                    case "SP" -> "São Paulo";
                    case "SE" -> "Sergipe";
                    case "TO" -> "Tocantins";
                    default -> "Sigla inválida";
                };
                

                jPanelProdutos.add(jPanelEntregarEm);
                jLabelRuaNumero.setText("Rua: " + e.getRua() + " Nº" + e.getNumero());
                jLabelBairro.setText(e.getBairro());
                jLabelCidadeEstado.setText(e.getCidade() + ", " + estado);
                jLabelComplemento.setText(e.getComplemento());

            }
        }

        jPanelProdutos.validate();
        jPanelProdutos.repaint();
    }

    /**
     * Percorre a relação de produtos e quantidades, salvando a soma da
     * multiplicação dos valores unitários e da quantidade de cada um deles numa
     * variável só, chamada total;
     */
    public void atualizarValorTotal() {

        total = BigDecimal.ZERO;

        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {

            Produto p = (Produto) entry.getKey();

            BigDecimal subtotal = p.getPreco().multiply(new BigDecimal(entry.getValue()));

            total = total.add(subtotal);

        }
        jLabelTotal.setText("R$: " + total);
    }

    /**
     * Atualiza a lista de endereços do usuário que é mostrada no jComboBox no
     * jDialog de finalização de compra
     */
    public void carregarEnderecos() {
        jComboBoxEndereco.removeAllItems();

        enderecosDoUsuario = UsuarioController.getEnderecos(usuario);

        jLabelNenhumEnderecoCadastrado.setVisible(enderecosDoUsuario.isEmpty());

        for (Endereco e : enderecosDoUsuario) {
            jComboBoxEndereco.addItem(e.getIdentificador());
        }
    }

    private void salvarAlteracoes() {
        PedidoController.atualizarProdutosCarrinho(produtos, usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogComprar = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jButtonFinalizarCompra = new javax.swing.JButton();
        jLabelValorTotalCompra = new javax.swing.JLabel();
        jLabelEntregarEm = new javax.swing.JLabel();
        jComboBoxEndereco = new javax.swing.JComboBox<>();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGerenciarEnderecos = new javax.swing.JButton();
        jLabelNenhumEnderecoCadastrado = new javax.swing.JLabel();
        jPanelEntregarEm = new javax.swing.JPanel();
        jLabelDecorativaEntregarEm = new javax.swing.JLabel();
        jLabelRuaNumero = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidadeEstado = new javax.swing.JLabel();
        jLabelDecorativoComplemento = new javax.swing.JLabel();
        jLabelComplemento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonFechar = new javax.swing.JButton();
        jButtonComprar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelProdutos = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTotal = new javax.swing.JLabel();

        jDialogComprar.setTitle("Comprar");
        jDialogComprar.setMinimumSize(new java.awt.Dimension(400, 300));
        jDialogComprar.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButtonFinalizarCompra.setBackground(new java.awt.Color(81, 95, 255));
        jButtonFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonFinalizarCompra.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFinalizarCompra.setText("Finalizar Compra");
        jButtonFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarCompraActionPerformed(evt);
            }
        });

        jLabelValorTotalCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelValorTotalCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelValorTotalCompra.setText("Total R$: 0,00");

        jLabelEntregarEm.setText("Entregar em:");

        jComboBoxEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonCancelar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGerenciarEnderecos.setBackground(new java.awt.Color(254, 255, 255));
        jButtonGerenciarEnderecos.setText("Gerenciar Endereços");
        jButtonGerenciarEnderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarEnderecosActionPerformed(evt);
            }
        });

        jLabelNenhumEnderecoCadastrado.setForeground(new java.awt.Color(204, 0, 51));
        jLabelNenhumEnderecoCadastrado.setText("Nenhum Endereço Cadastrado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelValorTotalCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonGerenciarEnderecos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelEntregarEm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNenhumEnderecoCadastrado)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonFinalizarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(54, 54, 54))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelValorTotalCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEntregarEm)
                    .addComponent(jComboBoxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNenhumEnderecoCadastrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGerenciarEnderecos)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizarCompra)
                    .addComponent(jButtonCancelar))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout jDialogComprarLayout = new javax.swing.GroupLayout(jDialogComprar.getContentPane());
        jDialogComprar.getContentPane().setLayout(jDialogComprarLayout);
        jDialogComprarLayout.setHorizontalGroup(
            jDialogComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogComprarLayout.setVerticalGroup(
            jDialogComprarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelEntregarEm.setBackground(new java.awt.Color(255, 255, 255));

        jLabelDecorativaEntregarEm.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabelDecorativaEntregarEm.setText("Entregar em:");

        jLabelRuaNumero.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabelRuaNumero.setText("Rua: x Nº");

        jLabelBairro.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabelBairro.setText("Bairro");

        jLabelCidadeEstado.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabelCidadeEstado.setText("Cidade, estado");

        jLabelDecorativoComplemento.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabelDecorativoComplemento.setText("Complemento:");

        jLabelComplemento.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabelComplemento.setText("algum complemento");

        javax.swing.GroupLayout jPanelEntregarEmLayout = new javax.swing.GroupLayout(jPanelEntregarEm);
        jPanelEntregarEm.setLayout(jPanelEntregarEmLayout);
        jPanelEntregarEmLayout.setHorizontalGroup(
            jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                        .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRuaNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                                .addComponent(jLabelDecorativoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEntregarEmLayout.createSequentialGroup()
                                .addComponent(jLabelComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                        .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                                .addComponent(jLabelDecorativaEntregarEm)
                                .addGap(0, 501, Short.MAX_VALUE))
                            .addComponent(jLabelCidadeEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanelEntregarEmLayout.setVerticalGroup(
            jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntregarEmLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelDecorativaEntregarEm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRuaNumero)
                    .addComponent(jLabelDecorativoComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEntregarEmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jLabelComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCidadeEstado)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comércio Eletrônico - Carrinho");
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

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelProdutos);

        jSeparator1.setMinimumSize(new java.awt.Dimension(650, 10));
        jSeparator1.setPreferredSize(new java.awt.Dimension(700, 10));

        jLabelTotal.setText("R$: 0,00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jButtonComprar)
                .addGap(102, 102, 102)
                .addComponent(jLabelTotal)
                .addGap(105, 105, 105)
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
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonComprar)
                    .addComponent(jLabelTotal))
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
        if (loja != null) {
            loja.setEnabled(true);
            salvarAlteracoes();

        }

        if (meusPedidos != null) {
            meusPedidos.setEnabled(true);
        }

        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprarActionPerformed

        if (!produtos.isEmpty()) {
            salvarAlteracoes();
            setEnabled(false);
            carregarEnderecos();

            pedido.setValortotal(total);
            jLabelValorTotalCompra.setText("R$: " + total);

            jDialogComprar.setLocationRelativeTo(this);
            jDialogComprar.setVisible(true);

        } else {
            Msg.exibirMensagem("Coloque alguns produtos no carrinho antes.", "Aviso", 2);
        }
    }//GEN-LAST:event_jButtonComprarActionPerformed

    private void jButtonGerenciarEnderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarEnderecosActionPerformed
        loja.jDialogConfig.setLocationRelativeTo(this);
        loja.jTabbedPaneOpcoes.setSelectedIndex(2);
        loja.carregarEnderecos();
        loja.setCarrinho(this);
        loja.jDialogConfig.setVisible(true);
    }//GEN-LAST:event_jButtonGerenciarEnderecosActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jDialogComprar.setVisible(false);
        setEnabled(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarCompraActionPerformed
        if (!enderecosDoUsuario.isEmpty()) {
            pedido.setIdendereco(enderecosDoUsuario.get(jComboBoxEndereco.getSelectedIndex()).getId());

            PedidoController.finalizarCompra(pedido);

            jDialogComprar.setVisible(false);
            dispose();
            Msg.exibirMensagem("Compra realizada com sucesso, acompanhe o status do seu pedido na sua lista de pedidos!", "Pedido #" + pedido.getId(), 1);
            loja.setEnabled(true);
            loja.carregarProdutos();

        } else {
            Msg.exibirMensagem("É necessário cadastrar um endereço de entrega.", "Aviso", 2);
        }
    }//GEN-LAST:event_jButtonFinalizarCompraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonComprar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonFinalizarCompra;
    private javax.swing.JButton jButtonGerenciarEnderecos;
    private javax.swing.JComboBox<String> jComboBoxEndereco;
    private javax.swing.JDialog jDialogComprar;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidadeEstado;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelDecorativaEntregarEm;
    private javax.swing.JLabel jLabelDecorativoComplemento;
    private javax.swing.JLabel jLabelEntregarEm;
    private javax.swing.JLabel jLabelNenhumEnderecoCadastrado;
    private javax.swing.JLabel jLabelRuaNumero;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelValorTotalCompra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelEntregarEm;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
