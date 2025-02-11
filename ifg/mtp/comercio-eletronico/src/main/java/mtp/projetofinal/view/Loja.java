package mtp.projetofinal.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import mtp.projetofinal.utils.PanelProduto;
import java.util.ArrayList;
import mtp.projetofinal.controller.LojaController;
import mtp.projetofinal.controller.ProdutoController;
import mtp.projetofinal.controller.UsuarioController;
import mtp.projetofinal.model.Endereco;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.utils.AddOuEditProduto;
import mtp.projetofinal.utils.FrameUtils;

/**
 *
 * @author luiz
 */
public class Loja extends javax.swing.JFrame {

    private Usuario usuario;
    private ArrayList<Produto> produtos;
    private int paginaAtual = 1;
    private int qtdItens = 9;
    private int ultimaPagina = paginaAtual;
    ArrayList<Endereco> enderecosDoUsuario;
    private CarrinhoView carrinho = null;

    /**
     * Creates new form Loja
     *
     * @param usuario usuário logado
     * @param paginaAtual qual página a loja será aberta
     * @param qtdItens quantos intens serão exibidos por página
     */
    public Loja(Usuario usuario, int paginaAtual, int qtdItens) {
        this.usuario = usuario;
        this.paginaAtual = paginaAtual;
        this.qtdItens = qtdItens;

        enderecosDoUsuario = UsuarioController.getEnderecos(usuario);

        initComponents();

        FrameUtils.setFrameIcon(this);

        jLabelAdicionarProduto.setVisible(usuario.getAdmin());

        // Dados do usuário
        jLabelUsername.setText(usuario.getNome());
        jTextFieldNome.setText(usuario.getNome());
        jTextFieldEmail.setText(usuario.getEmail());

        // Faz com que a barra de rolagem desca mais rápido
        jScrollPaneProdutos.getVerticalScrollBar().setUnitIncrement(16);

        // Organiza os panels dos produtos
        jPanelProdutos.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        carregarProdutos();

        setVisible(true);
    }

    /**
     * Exibe os produtos na loja
     */
    public void carregarProdutos() {

        setQtdNoCarrinho(ProdutoController.getProdutosNoCarrinho(usuario).size());

        jPanelProdutos.removeAll();

        if (LojaController.getCountProdutos() == 0) {
            jPanelProdutos.add(jLabelSemProduto);
            jLabelSemProduto.setVisible(true);
            jButtonProxima.setEnabled(false);
            jButtonAnterior.setEnabled(false);
            jButtonPrimeira.setEnabled(false);
            jButtonUltima.setEnabled(false);

        } else {
            jLabelSemProduto.setVisible(false);

            produtos = LojaController.getProdutos(paginaAtual, qtdItens);

            if (produtos.isEmpty()) {
                paginaAtual--;
                produtos = LojaController.getProdutos(paginaAtual, qtdItens);
            }

            ultimaPagina = Math.ceilDiv(LojaController.getCountProdutos(), qtdItens);

            Dimension dim = new Dimension(700, ((330 * Math.ceilDiv(produtos.size(), 3) + 50)));
            jPanelProdutos.setPreferredSize(dim);
            jScrollPaneProdutos.setPreferredSize(dim);

            for (Produto p : produtos) {

                PanelProduto pp = new PanelProduto(this, p, usuario);

                jPanelProdutos.add(pp);
            }

            botoesNavegacao();
        }

        jPanelProdutos.validate();
        jPanelProdutos.repaint();
        jScrollPaneProdutos.validate();
        jScrollPaneProdutos.repaint();
    }

    /**
     * Lógica para mostrar os botões de navegação das páginas
     */
    private void botoesNavegacao() {
        jButtonProxima.setEnabled(produtos.size() == qtdItens && !LojaController.getProdutos(paginaAtual + 1, qtdItens).isEmpty());
        jButtonAnterior.setEnabled(paginaAtual != 1);
        jLabelNumeroPagina.setText("Página: " + String.valueOf(paginaAtual));
        jButtonPrimeira.setEnabled(paginaAtual != 1);
        jButtonUltima.setEnabled(paginaAtual != ultimaPagina);
    }

    /**
     * Usado para atualizar as informações do carrinho quando necessário
     *
     * @param carrinho a view do carrinho
     */
    public void setCarrinho(CarrinhoView carrinho) {
        this.carrinho = carrinho;
    }

    public void setQtdNoCarrinho(Integer qtd) {
        jLabelQtdTotalNoCarrinho.setText(String.valueOf(qtd));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogConfig = new javax.swing.JDialog();
        jTabbedPaneOpcoes = new javax.swing.JTabbedPane();
        jPanelNomeEmail = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelEmailTip = new javax.swing.JLabel();
        jButtonAlterarNome = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelSenha = new javax.swing.JPanel();
        jLabelSenhaAtual = new javax.swing.JLabel();
        jLabelNovaSenha = new javax.swing.JLabel();
        jLabelConfirmarNovaSenha = new javax.swing.JLabel();
        jPasswordFieldSenhaAtual = new javax.swing.JPasswordField();
        jPasswordFieldNovaSenha = new javax.swing.JPasswordField();
        jPasswordFieldConfirmarNovaSenha = new javax.swing.JPasswordField();
        jButtonSalvarSenha = new javax.swing.JButton();
        jButtonCancelar1 = new javax.swing.JButton();
        jPanelEndereco = new javax.swing.JPanel();
        jComboBoxEnderecos = new javax.swing.JComboBox<>();
        jButtonCriarNovoEndereco = new javax.swing.JButton();
        jButtonExcluirEnderecoSelecionado = new javax.swing.JButton();
        jPanelCamposEndereco = new javax.swing.JPanel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelIdentificadorEndereco = new javax.swing.JLabel();
        jTextFieldIdentificadorEndereco = new javax.swing.JTextField();
        jLabelExemploIdentificador = new javax.swing.JLabel();
        jButtonSalvarEndereco = new javax.swing.JButton();
        jComboBoxEstados = new javax.swing.JComboBox<>();
        jLabelNenhumEnderecoCadastrado = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelNavBar = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelConfig = new javax.swing.JLabel();
        jLabelCarrinho = new javax.swing.JLabel();
        jLabelAdicionarProduto = new javax.swing.JLabel();
        jLabelMeusPedidos = new javax.swing.JLabel();
        jLabelQtdTotalNoCarrinho = new javax.swing.JLabel();
        jScrollPaneProdutos = new javax.swing.JScrollPane();
        jPanelProdutos = new javax.swing.JPanel();
        jLabelSemProduto = new javax.swing.JLabel();
        jButtonAnterior = new javax.swing.JButton();
        jLabelNumeroPagina = new javax.swing.JLabel();
        jButtonProxima = new javax.swing.JButton();
        jButtonUltima = new javax.swing.JButton();
        jButtonPrimeira = new javax.swing.JButton();

        jDialogConfig.setTitle("Configurações");
        jDialogConfig.setMinimumSize(new java.awt.Dimension(505, 450));
        jDialogConfig.setModal(true);
        jDialogConfig.setResizable(false);

        jTabbedPaneOpcoes.setBackground(new java.awt.Color(255, 255, 255));

        jPanelNomeEmail.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNome.setText("Nome:");

        jTextFieldNome.setText("usuario");

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldEmail.setText("usuario@email.com");
        jTextFieldEmail.setFocusable(false);

        jLabelEmail.setText("Email:");

        jLabelEmailTip.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabelEmailTip.setText("O e-mail não pode ser editado.");

        jButtonAlterarNome.setBackground(new java.awt.Color(81, 95, 255));
        jButtonAlterarNome.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonAlterarNome.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAlterarNome.setText("Alterar Nome");
        jButtonAlterarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarNomeActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNomeEmailLayout = new javax.swing.GroupLayout(jPanelNomeEmail);
        jPanelNomeEmail.setLayout(jPanelNomeEmailLayout);
        jPanelNomeEmailLayout.setHorizontalGroup(
            jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                        .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelEmailTip))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                        .addComponent(jButtonAlterarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)))
                .addGap(64, 64, 64))
        );
        jPanelNomeEmailLayout.setVerticalGroup(
            jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmailTip)
                .addGap(65, 65, 65)
                .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterarNome)
                    .addComponent(jButtonCancelar))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPaneOpcoes.addTab("Nome e Email", jPanelNomeEmail);

        jPanelSenha.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSenhaAtual.setText("Senha atual:");

        jLabelNovaSenha.setText("Nova senha:");

        jLabelConfirmarNovaSenha.setText("Confirme a nova senha:");

        jButtonSalvarSenha.setBackground(new java.awt.Color(81, 95, 255));
        jButtonSalvarSenha.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonSalvarSenha.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarSenha.setText("Alterar Senha");
        jButtonSalvarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarSenhaActionPerformed(evt);
            }
        });

        jButtonCancelar1.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelar1.setText("Cancelar");
        jButtonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSenhaLayout = new javax.swing.GroupLayout(jPanelSenha);
        jPanelSenha.setLayout(jPanelSenhaLayout);
        jPanelSenhaLayout.setHorizontalGroup(
            jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSenhaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSenhaLayout.createSequentialGroup()
                        .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSenhaAtual)
                            .addComponent(jLabelNovaSenha)
                            .addComponent(jLabelConfirmarNovaSenha)
                            .addComponent(jPasswordFieldSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(339, Short.MAX_VALUE))
                    .addGroup(jPanelSenhaLayout.createSequentialGroup()
                        .addComponent(jButtonSalvarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar1)
                        .addGap(63, 63, 63))))
        );
        jPanelSenhaLayout.setVerticalGroup(
            jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSenhaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelSenhaAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabelNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelConfirmarNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldConfirmarNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarSenha)
                    .addComponent(jButtonCancelar1))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jTabbedPaneOpcoes.addTab("Senha", jPanelSenha);

        jPanelEndereco.setBackground(new java.awt.Color(255, 255, 255));

        jComboBoxEnderecos.setBackground(new java.awt.Color(254, 255, 255));
        jComboBoxEnderecos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonCriarNovoEndereco.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCriarNovoEndereco.setText("Novo endereço");
        jButtonCriarNovoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarNovoEnderecoActionPerformed(evt);
            }
        });

        jButtonExcluirEnderecoSelecionado.setBackground(new java.awt.Color(255, 0, 0));
        jButtonExcluirEnderecoSelecionado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonExcluirEnderecoSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluirEnderecoSelecionado.setText("Excluir Selecionado");
        jButtonExcluirEnderecoSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirEnderecoSelecionadoActionPerformed(evt);
            }
        });

        jPanelCamposEndereco.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEstado.setText("Estado");

        jLabelCidade.setText("Cidade");

        jLabelBairro.setText("Bairro");

        jLabelRua.setText("Rua");

        jLabelNumero.setText("Numero");

        jLabelComplemento.setText("Complemento (opcional)");

        jLabelIdentificadorEndereco.setText("Identificador do Endereço:");

        jTextFieldIdentificadorEndereco.setToolTipText("");

        jLabelExemploIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabelExemploIdentificador.setForeground(new java.awt.Color(153, 153, 153));
        jLabelExemploIdentificador.setText("Exemplo: casa, trabalho...");

        jButtonSalvarEndereco.setBackground(new java.awt.Color(81, 95, 255));
        jButtonSalvarEndereco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSalvarEndereco.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarEndereco.setText("Salvar");
        jButtonSalvarEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarEnderecoActionPerformed(evt);
            }
        });

        jComboBoxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanelCamposEnderecoLayout = new javax.swing.GroupLayout(jPanelCamposEndereco);
        jPanelCamposEndereco.setLayout(jPanelCamposEnderecoLayout);
        jPanelCamposEnderecoLayout.setHorizontalGroup(
            jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                        .addComponent(jButtonSalvarEndereco)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                        .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelCidade)
                                .addComponent(jLabelEstado)
                                .addComponent(jLabelBairro)
                                .addComponent(jTextFieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(jTextFieldCidade))
                            .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRua)
                            .addComponent(jLabelNumero)
                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelComplemento)
                            .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamposEnderecoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelExemploIdentificador)
                .addGap(160, 160, 160))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCamposEnderecoLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabelIdentificadorEndereco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIdentificadorEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 122, Short.MAX_VALUE))
        );
        jPanelCamposEnderecoLayout.setVerticalGroup(
            jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdentificadorEndereco)
                    .addComponent(jTextFieldIdentificadorEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabelExemploIdentificador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCamposEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabelRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelComplemento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCamposEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabelEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabelCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonSalvarEndereco)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabelNenhumEnderecoCadastrado.setForeground(new java.awt.Color(204, 0, 51));
        jLabelNenhumEnderecoCadastrado.setText("Você não tem nenhum endereço, crie um novo.");

        javax.swing.GroupLayout jPanelEnderecoLayout = new javax.swing.GroupLayout(jPanelEndereco);
        jPanelEndereco.setLayout(jPanelEnderecoLayout);
        jPanelEnderecoLayout.setHorizontalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jComboBoxEnderecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonCriarNovoEndereco)
                .addGap(30, 30, 30)
                .addComponent(jButtonExcluirEnderecoSelecionado)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanelEnderecoLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabelNenhumEnderecoCadastrado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanelCamposEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelEnderecoLayout.setVerticalGroup(
            jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnderecoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEnderecos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCriarNovoEndereco)
                    .addComponent(jButtonExcluirEnderecoSelecionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNenhumEnderecoCadastrado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelCamposEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneOpcoes.addTab("Endereço", jPanelEndereco);

        jLabelTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelTitulo.setText("Alteração de dados");

        javax.swing.GroupLayout jDialogConfigLayout = new javax.swing.GroupLayout(jDialogConfig.getContentPane());
        jDialogConfig.getContentPane().setLayout(jDialogConfigLayout);
        jDialogConfigLayout.setHorizontalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogConfigLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPaneOpcoes)
        );
        jDialogConfigLayout.setVerticalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfigLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneOpcoes))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comercio Eletrônico");
        setMinimumSize(new java.awt.Dimension(930, 600));

        jPanelNavBar.setMinimumSize(new java.awt.Dimension(900, 0));
        jPanelNavBar.setPreferredSize(new java.awt.Dimension(900, 68));

        jLabelUsername.setText("nome");

        jButtonSair.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSair.setForeground(new java.awt.Color(81, 95, 255));
        jButtonSair.setText("sair");
        jButtonSair.setBorder(null);
        jButtonSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/config.png"))); // NOI18N
        jLabelConfig.setToolTipText("Alterarção de dados");
        jLabelConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConfigMouseClicked(evt);
            }
        });

        jLabelCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrinho.png"))); // NOI18N
        jLabelCarrinho.setToolTipText("Carrinho");
        jLabelCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCarrinhoMouseClicked(evt);
            }
        });

        jLabelAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adicionar.png"))); // NOI18N
        jLabelAdicionarProduto.setToolTipText("Adicionar Produto");
        jLabelAdicionarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdicionarProdutoMouseClicked(evt);
            }
        });

        jLabelMeusPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/meus-pedidos.png"))); // NOI18N
        jLabelMeusPedidos.setToolTipText("Meus Pedidos");
        jLabelMeusPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMeusPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMeusPedidosMouseClicked(evt);
            }
        });

        jLabelQtdTotalNoCarrinho.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabelQtdTotalNoCarrinho.setText("0");

        javax.swing.GroupLayout jPanelNavBarLayout = new javax.swing.GroupLayout(jPanelNavBar);
        jPanelNavBar.setLayout(jPanelNavBarLayout);
        jPanelNavBarLayout.setHorizontalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNavBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsername)
                    .addComponent(jButtonSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                .addComponent(jLabelAdicionarProduto)
                .addGap(18, 18, 18)
                .addComponent(jLabelMeusPedidos)
                .addGap(18, 18, 18)
                .addComponent(jLabelCarrinho)
                .addGap(7, 7, 7)
                .addComponent(jLabelQtdTotalNoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelNavBarLayout.setVerticalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavBarLayout.createSequentialGroup()
                .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNavBarLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelConfig)
                            .addGroup(jPanelNavBarLayout.createSequentialGroup()
                                .addComponent(jLabelUsername)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSair))
                            .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelAdicionarProduto)
                                .addComponent(jLabelCarrinho)
                                .addComponent(jLabelMeusPedidos))))
                    .addGroup(jPanelNavBarLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelQtdTotalNoCarrinho)))
                .addGap(26, 26, 26))
        );

        jScrollPaneProdutos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneProdutos.setMinimumSize(new java.awt.Dimension(900, 330));
        jScrollPaneProdutos.setPreferredSize(new java.awt.Dimension(900, 330));

        jPanelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProdutos.setMinimumSize(new java.awt.Dimension(900, 330));
        jPanelProdutos.setPreferredSize(new java.awt.Dimension(900, 330));

        jLabelSemProduto.setText("Não há produtos a serem exibidos");

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addComponent(jLabelSemProduto)
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdutosLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabelSemProduto)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jScrollPaneProdutos.setViewportView(jPanelProdutos);

        jButtonAnterior.setBackground(new java.awt.Color(255, 255, 254));
        jButtonAnterior.setText("<");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jLabelNumeroPagina.setText("Página: 1");

        jButtonProxima.setBackground(new java.awt.Color(255, 254, 255));
        jButtonProxima.setText(">");
        jButtonProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximaActionPerformed(evt);
            }
        });

        jButtonUltima.setBackground(new java.awt.Color(255, 254, 255));
        jButtonUltima.setText(">>");
        jButtonUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimaActionPerformed(evt);
            }
        });

        jButtonPrimeira.setBackground(new java.awt.Color(255, 255, 254));
        jButtonPrimeira.setText("<<");
        jButtonPrimeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonPrimeira, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNumeroPagina)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonProxima)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUltima, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProxima)
                    .addComponent(jLabelNumeroPagina)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonUltima)
                    .addComponent(jButtonPrimeira))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Volta para a tela inicial
     */
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new TelaInicial();
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * Mostra o dialog de configurações
     */
    private void jLabelConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfigMouseClicked
        jDialogConfig.setLocationRelativeTo(this);
        carregarEnderecos();

        jComboBoxEnderecos.addActionListener((ActionEvent event) -> {
            preencherCamposEndereco();
        });
        jDialogConfig.setVisible(true);
    }//GEN-LAST:event_jLabelConfigMouseClicked

    /**
     * Atualiza a lista de endereços do usuário que é mostrada no jComboBox da
     * aba de alteração de dados.
     */
    public void carregarEnderecos() {
        enderecosDoUsuario = UsuarioController.getEnderecos(usuario);
        jComboBoxEnderecos.removeAllItems();

        if (enderecosDoUsuario.isEmpty()) {
            jLabelNenhumEnderecoCadastrado.setVisible(true);
            jPanelCamposEndereco.setVisible(false);
            jButtonExcluirEnderecoSelecionado.setVisible(false);
        } else {
            jLabelNenhumEnderecoCadastrado.setVisible(false);
            jPanelCamposEndereco.setVisible(true);
            jButtonExcluirEnderecoSelecionado.setVisible(true);

            for (int i = 0; i < enderecosDoUsuario.size(); i++) {
                jComboBoxEnderecos.addItem(enderecosDoUsuario.get(i).getIdentificador());
            }

            preencherCamposEndereco();
        }
    }

    private void preencherCamposEndereco() {
        int selecionado = jComboBoxEnderecos.getSelectedIndex();

        if (selecionado >= 0) {
            Endereco e = enderecosDoUsuario.get(selecionado);

            jTextFieldIdentificadorEndereco.setText(e.getIdentificador());
            jComboBoxEstados.setSelectedItem(e.getEstado());
            jTextFieldCidade.setText(e.getCidade());
            jTextFieldBairro.setText(e.getBairro());
            jTextFieldRua.setText(e.getRua());
            jTextFieldNumero.setText(e.getNumero());
            jTextFieldComplemento.setText(e.getComplemento());

            Boolean editavel = !LojaController.enderecoJaFoiUsado(e);

            jTextFieldIdentificadorEndereco.setEditable(editavel);
            jComboBoxEstados.setEnabled(editavel);
            jComboBoxEstados.setForeground(Color.BLACK);
            jTextFieldCidade.setEditable(editavel);
            jTextFieldBairro.setEditable(editavel);
            jTextFieldRua.setEditable(editavel);
            jTextFieldNumero.setEditable(editavel);
            jTextFieldComplemento.setEditable(editavel);

        }
    }

    /**
     * Esconde a tela de configurações
     */
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jDialogConfig.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * Valida o campo nome e manda para a controller
     */
    private void jButtonAlterarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarNomeActionPerformed

        String nome = jTextFieldNome.getText();

        if (nome.isBlank()) {
            Msg.exibirMensagem("O campo nome não pode estar vazio", "Aviso", 2);
        } else if (nome.length() > 45) {
            Msg.exibirMensagem("O nome pode ter no máximo 45 caracteres.", "Aviso", 2);
        } else {

            usuario.setNome(nome);

            LojaController lc = new LojaController();

            if (lc.alterarDados(usuario)) {
                Msg.exibirMensagem("Nome alterado com sucesso!", "Sucesso!", 1);
                usuario = lc.getUsuarioAtualizado();
                jLabelUsername.setText(usuario.getNome());
            }
        }
    }//GEN-LAST:event_jButtonAlterarNomeActionPerformed

    /**
     * Valida os campos e manda os dados para a controller
     */
    private void jButtonSalvarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSenhaActionPerformed
        String senhaAtual = String.valueOf(jPasswordFieldSenhaAtual.getPassword());
        String novaSenha = String.valueOf(jPasswordFieldNovaSenha.getPassword());
        String confirmarNovaSenha = String.valueOf(jPasswordFieldConfirmarNovaSenha.getPassword());

        if (senhaAtual.isBlank() || novaSenha.isBlank() || confirmarNovaSenha.isBlank()) {
            Msg.exibirMensagem("Todos os campos devem estar preenchidos", "Aviso", 2);
        } else if (!senhaAtual.equals(usuario.getSenha())) {
            Msg.exibirMensagem("A senha atual está incorreta!", "Aviso", 2);
        } else if (!novaSenha.equals(confirmarNovaSenha)) {
            Msg.exibirMensagem("A senha nova não coincide", "Aviso", 2);
        } else if (novaSenha.length() > 255) {
            Msg.exibirMensagem("A sua senha é desnecessáriamente grande", "Aviso", 2);
        } else {
            LojaController lc = new LojaController();

            usuario.setSenha(novaSenha);

            if (lc.alterarDados(usuario)) {
                Msg.exibirMensagem("Sua senha foi alterada com sucesso!", "Sucesso!", 1);
            }
        }
    }//GEN-LAST:event_jButtonSalvarSenhaActionPerformed

    /**
     * Esconde a tela de configurações
     */
    private void jButtonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar1ActionPerformed
        jDialogConfig.setVisible(false);
    }//GEN-LAST:event_jButtonCancelar1ActionPerformed

    /**
     * Abre a tela de gerenciamento de produto que só administradores possuem
     * acesso
     */
    private void jLabelAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAdicionarProdutoMouseClicked
        setEnabled(false);
        new AddOuEditProduto(this, null, null, AddOuEditProduto.ADD);
    }//GEN-LAST:event_jLabelAdicionarProdutoMouseClicked

    /**
     * Volta uma página
     */
    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        paginaAtual--;
        carregarProdutos();
        jScrollPaneProdutos.getVerticalScrollBar().setValue(0);
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    /**
     * Avança uma página
     */
    private void jButtonProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximaActionPerformed
        paginaAtual++;
        carregarProdutos();
        jScrollPaneProdutos.getVerticalScrollBar().setValue(0);
    }//GEN-LAST:event_jButtonProximaActionPerformed

    /**
     * Abre o carrinho
     */
    private void jLabelCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCarrinhoMouseClicked
        setEnabled(false);
        new CarrinhoView(this, usuario);
    }//GEN-LAST:event_jLabelCarrinhoMouseClicked

    /**
     * Avança para a última página
     */
    private void jButtonUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimaActionPerformed
        ultimaPagina = Math.ceilDiv(LojaController.getCountProdutos(), qtdItens);
        paginaAtual = ultimaPagina;
        carregarProdutos();
    }//GEN-LAST:event_jButtonUltimaActionPerformed

    /**
     * Volta para a primeira página
     */
    private void jButtonPrimeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiraActionPerformed
        paginaAtual = 1;
        carregarProdutos();
    }//GEN-LAST:event_jButtonPrimeiraActionPerformed

    private void jButtonSalvarEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarEnderecoActionPerformed

        String identificador = jTextFieldIdentificadorEndereco.getText();
        String cidade = jTextFieldCidade.getText();
        String bairro = jTextFieldBairro.getText();
        String rua = jTextFieldRua.getText();
        String numero = jTextFieldNumero.getText();

        if (identificador.isBlank() || cidade.isBlank() || bairro.isBlank() || rua.isBlank() || numero.isBlank()) {
            Msg.exibirMensagem("Preencha todos os campos, só o complemento que é opcional.", "Aviso", 2);
        } else if (identificador.length() > 20) {
            Msg.exibirMensagem("O identificador pode ter no máximo 20 caracteres.", "Aviso", 2);
        } else if (cidade.length() > 45) {
            Msg.exibirMensagem("A cidade pode ter no máximo 45 caracteres.", "Aviso", 2);
        } else if (bairro.length() > 45) {
            Msg.exibirMensagem("O bairro pode ter no máximo 45 caracteres.", "Aviso", 2);
        } else if (rua.length() > 45) {
            Msg.exibirMensagem("A rua pode ter no máximo 45 caracteres.", "Aviso", 2);
        } else if (numero.length() > 10) {
            Msg.exibirMensagem("O número pode ter no máximo 10 caracteres.", "Aviso", 2);
        } else {
            
            Endereco e = enderecosDoUsuario.get(jComboBoxEnderecos.getSelectedIndex());

            e.setIdentificador(jTextFieldIdentificadorEndereco.getText());

            e.setEstado((String) jComboBoxEstados.getSelectedItem());
            e.setCidade(jTextFieldCidade.getText());
            e.setBairro(jTextFieldBairro.getText());
            e.setRua(jTextFieldRua.getText());
            e.setNumero(jTextFieldNumero.getText());

            if (!jTextFieldComplemento.getText().isBlank()) {
                if (jTextFieldComplemento.getText().length() > 45) {
                    Msg.exibirMensagem("O complemento pode ter no máximo 45 caracteres.", "Aviso", 2);
                } else {
                    e.setComplemento(jTextFieldComplemento.getText());
                }
            }

            LojaController lc = new LojaController();

            if (lc.salvarEndereco(usuario, e)) {
                Msg.exibirMensagem("Endereço salvo com sucesso.", "Sucesso!", 1);
                carregarEnderecos();
                if (carrinho != null) {
                    carrinho.carregarEnderecos();
                    carrinho = null;
                }
            }
        }
    }//GEN-LAST:event_jButtonSalvarEnderecoActionPerformed

    private void jButtonExcluirEnderecoSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirEnderecoSelecionadoActionPerformed
        if (new LojaController().excluirEndereco(enderecosDoUsuario.get(jComboBoxEnderecos.getSelectedIndex()))) {
            Msg.exibirMensagem("Endereço excluido com sucesso.", "Sucesso!", 1);
            carregarEnderecos();
        }
    }//GEN-LAST:event_jButtonExcluirEnderecoSelecionadoActionPerformed

    private void jButtonCriarNovoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarNovoEnderecoActionPerformed
        if (LojaController.adicionarEndereco(usuario)) {
            carregarEnderecos();
            jTextFieldIdentificadorEndereco.requestFocus();
            jTextFieldIdentificadorEndereco.selectAll();
        }
    }//GEN-LAST:event_jButtonCriarNovoEnderecoActionPerformed

    private void jLabelMeusPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMeusPedidosMouseClicked
        setEnabled(false);
        new MeusPedidos(this, usuario);
    }//GEN-LAST:event_jLabelMeusPedidosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarNome;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonCriarNovoEndereco;
    private javax.swing.JButton jButtonExcluirEnderecoSelecionado;
    private javax.swing.JButton jButtonPrimeira;
    private javax.swing.JButton jButtonProxima;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvarEndereco;
    private javax.swing.JButton jButtonSalvarSenha;
    private javax.swing.JButton jButtonUltima;
    private javax.swing.JComboBox<String> jComboBoxEnderecos;
    private javax.swing.JComboBox<String> jComboBoxEstados;
    public javax.swing.JDialog jDialogConfig;
    private javax.swing.JLabel jLabelAdicionarProduto;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCarrinho;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelConfirmarNovaSenha;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmailTip;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelExemploIdentificador;
    private javax.swing.JLabel jLabelIdentificadorEndereco;
    private javax.swing.JLabel jLabelMeusPedidos;
    private javax.swing.JLabel jLabelNenhumEnderecoCadastrado;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNovaSenha;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelNumeroPagina;
    private javax.swing.JLabel jLabelQtdTotalNoCarrinho;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSemProduto;
    private javax.swing.JLabel jLabelSenhaAtual;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelCamposEndereco;
    private javax.swing.JPanel jPanelEndereco;
    private javax.swing.JPanel jPanelNavBar;
    private javax.swing.JPanel jPanelNomeEmail;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JPanel jPanelSenha;
    private javax.swing.JPasswordField jPasswordFieldConfirmarNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldSenhaAtual;
    private javax.swing.JScrollPane jScrollPaneProdutos;
    public javax.swing.JTabbedPane jTabbedPaneOpcoes;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIdentificadorEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRua;
    // End of variables declaration//GEN-END:variables
}
