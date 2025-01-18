package mtp.projetofinal.view;

import mtp.projetofinal.PanelProduto;
import java.util.ArrayList;
import mtp.projetofinal.controller.LojaController;
import mtp.projetofinal.Msg;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;

/**
 *
 * @author luiz
 */
public class Loja extends javax.swing.JFrame {

    private Usuario usuario;
    private ArrayList<Object> produtos;
    private int paginaAtual = 1;
    private int qtdItens = 9;

    /**
     * Creates new form Loja
     *
     * @param usuario Dados do usuário logado
     * @param paginaAtual
     * @param qtdItens
     */
    public Loja(Usuario usuario, int paginaAtual, int qtdItens) {
        this.usuario = usuario;
        this.paginaAtual = paginaAtual;
        this.qtdItens = qtdItens;

        initComponents();

        jLabelAdicionarProduto.setVisible(usuario.getAdmin());

        jLabelUsername.setText(usuario.getNome());
        jTextFieldNome.setText(usuario.getNome());
        jTextFieldEmail.setText(usuario.getEmail());

        // Faz com que a barra de rolagem desca mais rápido
        jScrollPaneProdutos.getVerticalScrollBar().setUnitIncrement(16);

        this.produtos = LojaController.getProdutos(this.paginaAtual, this.qtdItens);

        // Lógica para mostrar os botões de navegação das páginas
        jButtonProxima.setVisible(this.produtos.size() == this.qtdItens);
        jButtonAnterior.setVisible(this.paginaAtual != 1);

        // Verifica se existem produtos
        if (this.produtos.isEmpty()) {
            jLabelSemProduto.setVisible(true);
        } else {
            jLabelSemProduto.setVisible(false);
            carregarProdutos();
        }

        setVisible(true);
    }

    /**
     * Exibe 9 produtos, um por um dentro panel de produtos dentro do
     * scrollpanel
     */
    private void carregarProdutos() {
        int width = 230;
        int height = 280;
        int x = 0;
        int y = 0;
        int z = 1;
        for (Object obj : this.produtos) {

            if (x == 3) {
                x = 0;
                y++;
                z = 1;
            }

            Produto p = (Produto) obj;
            PanelProduto pp = new PanelProduto(p, this.usuario);
            pp.setSize(width, height);
            pp.setLocation((width * x) + 50 * z, (height * y) + (50 * (y + 1)));
            jPanelProdutos.add(pp);
            x++;
            z++;
        }
    }

    /**
     * Abre a janela novamente para atualizar as informações (não consegui fazer
     * de outra forma)
     */
    private void atualizarCompontentes() {
        new Loja(this.usuario, this.paginaAtual, this.qtdItens);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogConfig = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jLabelTitulo = new javax.swing.JLabel();
        jDialogAddProduto = new javax.swing.JDialog();
        jPanelAddProduto = new javax.swing.JPanel();
        jLabelNomeProduto = new javax.swing.JLabel();
        jTextFieldNomeProduto = new javax.swing.JTextField();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelFoto = new javax.swing.JLabel();
        jButtonCarregarArquivo = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelarProduto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelInfo = new javax.swing.JLabel();
        jPanelNavBar = new javax.swing.JPanel();
        jLabelUsername = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelConfig = new javax.swing.JLabel();
        jLabelCarrinho = new javax.swing.JLabel();
        jLabelAdicionarProduto = new javax.swing.JLabel();
        jScrollPaneProdutos = new javax.swing.JScrollPane();
        jPanelProdutos = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        jButtonProxima = new javax.swing.JButton();
        jLabelSemProduto = new javax.swing.JLabel();

        jDialogConfig.setTitle("Configurações");
        jDialogConfig.setMinimumSize(new java.awt.Dimension(505, 467));
        jDialogConfig.setModal(true);
        jDialogConfig.setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

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
                .addGap(41, 41, 41)
                .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                        .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelEmailTip))
                        .addContainerGap(264, Short.MAX_VALUE))
                    .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                        .addComponent(jButtonAlterarNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(63, 63, 63))))
        );
        jPanelNomeEmailLayout.setVerticalGroup(
            jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNomeEmailLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmailTip)
                .addGap(46, 46, 46)
                .addGroup(jPanelNomeEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterarNome)
                    .addComponent(jButtonCancelar))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Nome e Email", jPanelNomeEmail);

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
                        .addContainerGap(309, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanelSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvarSenha)
                    .addComponent(jButtonCancelar1))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Senha", jPanelSenha);

        jLabelTitulo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabelTitulo.setText("Alteração de dados");

        javax.swing.GroupLayout jDialogConfigLayout = new javax.swing.GroupLayout(jDialogConfig.getContentPane());
        jDialogConfig.getContentPane().setLayout(jDialogConfigLayout);
        jDialogConfigLayout.setHorizontalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jDialogConfigLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogConfigLayout.setVerticalGroup(
            jDialogConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogConfigLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jDialogAddProduto.setTitle("Adicionar Produto");
        jDialogAddProduto.setLocationByPlatform(true);
        jDialogAddProduto.setMinimumSize(new java.awt.Dimension(550, 433));
        jDialogAddProduto.setModal(true);
        jDialogAddProduto.setResizable(false);

        jPanelAddProduto.setBackground(new java.awt.Color(255, 255, 255));

        jLabelNomeProduto.setText("Nome do Produto:");

        jLabelDescricao.setText("Descrição");

        jLabelPreco.setText("Preço R$:");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setLineWrap(true);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelFoto.setText("Foto (opcional)");

        jButtonCarregarArquivo.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCarregarArquivo.setText("Carregar Arquivo");

        jButtonAdicionar.setBackground(new java.awt.Color(81, 95, 255));
        jButtonAdicionar.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonCancelarProduto.setBackground(new java.awt.Color(254, 255, 255));
        jButtonCancelarProduto.setText("Cancelar");
        jButtonCancelarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarProdutoActionPerformed(evt);
            }
        });

        jLabelInfo.setFont(new java.awt.Font("Liberation Sans", 0, 11)); // NOI18N
        jLabelInfo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelInfo.setText("Utilize . (ponto) para as casas decimais");

        javax.swing.GroupLayout jPanelAddProdutoLayout = new javax.swing.GroupLayout(jPanelAddProduto);
        jPanelAddProduto.setLayout(jPanelAddProdutoLayout);
        jPanelAddProdutoLayout.setHorizontalGroup(
            jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                        .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescricao)
                            .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                                .addComponent(jLabelPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelNomeProduto)
                            .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddProdutoLayout.createSequentialGroup()
                        .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAddProdutoLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddProdutoLayout.createSequentialGroup()
                                        .addComponent(jLabelFoto)
                                        .addGap(23, 23, 23)))))
                        .addGap(51, 51, 51))))
            .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jButtonAdicionar)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonCancelarProduto))
                    .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabelInfo)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelAddProdutoLayout.setVerticalGroup(
            jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelNomeProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                        .addComponent(jLabelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAddProdutoLayout.createSequentialGroup()
                        .addComponent(jLabelFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(39, 39, 39)
                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPreco)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionar)
                    .addComponent(jButtonCancelarProduto))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jDialogAddProdutoLayout = new javax.swing.GroupLayout(jDialogAddProduto.getContentPane());
        jDialogAddProduto.getContentPane().setLayout(jDialogAddProdutoLayout);
        jDialogAddProdutoLayout.setHorizontalGroup(
            jDialogAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAddProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddProdutoLayout.setVerticalGroup(
            jDialogAddProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAddProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comercio Eletrônico");
        setMaximumSize(new java.awt.Dimension(900, 2147483647));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

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
        jLabelConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelConfigMouseClicked(evt);
            }
        });

        jLabelCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrinho.png"))); // NOI18N
        jLabelCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelAdicionarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adicionar.png"))); // NOI18N
        jLabelAdicionarProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAdicionarProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNavBarLayout = new javax.swing.GroupLayout(jPanelNavBar);
        jPanelNavBar.setLayout(jPanelNavBarLayout);
        jPanelNavBarLayout.setHorizontalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavBarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsername)
                    .addComponent(jButtonSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAdicionarProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelCarrinho)
                .addGap(24, 24, 24))
        );
        jPanelNavBarLayout.setVerticalGroup(
            jPanelNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(jLabelCarrinho)))
                .addGap(10, 10, 10))
        );

        jScrollPaneProdutos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelProdutos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProdutos.setMinimumSize(new java.awt.Dimension(900, 1100));
        jPanelProdutos.setPreferredSize(new java.awt.Dimension(900, 1100));

        jButtonAnterior.setBackground(new java.awt.Color(255, 255, 254));
        jButtonAnterior.setText("Anterior");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonProxima.setBackground(new java.awt.Color(255, 254, 255));
        jButtonProxima.setText("Proxima");
        jButtonProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximaActionPerformed(evt);
            }
        });

        jLabelSemProduto.setText("Não há produtos a serem exibidos");

        javax.swing.GroupLayout jPanelProdutosLayout = new javax.swing.GroupLayout(jPanelProdutos);
        jPanelProdutos.setLayout(jPanelProdutosLayout);
        jPanelProdutosLayout.setHorizontalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jButtonAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(jButtonProxima)
                .addGap(226, 226, 226))
            .addGroup(jPanelProdutosLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabelSemProduto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProdutosLayout.setVerticalGroup(
            jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProdutosLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabelSemProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 906, Short.MAX_VALUE)
                .addGroup(jPanelProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonProxima))
                .addGap(21, 21, 21))
        );

        jScrollPaneProdutos.setViewportView(jPanelProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Volta para a tela inicial
     */
    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        new TelaInicial();
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * Mostra o dialog de configurações
     */
    private void jLabelConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelConfigMouseClicked
        jDialogConfig.setLocationRelativeTo(this);
        jDialogConfig.setVisible(true);
    }//GEN-LAST:event_jLabelConfigMouseClicked

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

        if (!nome.equals("")) {

            this.usuario.setNome(nome);

            LojaController lc = new LojaController();

            if (lc.alterarDados(this.usuario)) {
                Msg.exibirMensagem("Nome alterado com sucesso!", "Sucesso!", 1);
                this.usuario = lc.getUsuarioAtualizado();
                jLabelUsername.setText(this.usuario.getNome());
            }
        } else {
            Msg.exibirMensagem("O campo nome não pode estar vazio", "Aviso", 2);
        }

    }//GEN-LAST:event_jButtonAlterarNomeActionPerformed

    /**
     * Valida os campos e manda os dados para a controller
     */
    private void jButtonSalvarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarSenhaActionPerformed
        String senhaAtual = String.valueOf(jPasswordFieldSenhaAtual.getPassword());
        String novaSenha = String.valueOf(jPasswordFieldNovaSenha.getPassword());
        String confirmarNovaSenha = String.valueOf(jPasswordFieldConfirmarNovaSenha.getPassword());

        if (senhaAtual.equals("") || novaSenha.equals("") || confirmarNovaSenha.equals("")) {
            Msg.exibirMensagem("Todos os campos devem estar preenchidos", "Aviso", 2);
        } else if (!senhaAtual.equals(this.usuario.getSenha())) {
            Msg.exibirMensagem("A senha atual está incorreta!", "Aviso", 2);
        } else if (!novaSenha.equals(confirmarNovaSenha)) {
            Msg.exibirMensagem("A senha nova não coincide", "Aviso", 2);
        } else {
            LojaController lc = new LojaController();

            this.usuario.setSenha(novaSenha);

            if (lc.alterarDados(this.usuario)) {
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
        jDialogAddProduto.setLocationRelativeTo(this);
        jDialogAddProduto.setVisible(true);
    }//GEN-LAST:event_jLabelAdicionarProdutoMouseClicked

    /**
     * Valida os campos e manda os dados para a controller adicionar um novo
     * produto
     */
    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        try {

            Produto p = new Produto();
            p.setNome(jTextFieldNomeProduto.getText());
            p.setDescricao(jTextAreaDescricao.getText());

            p.setPreco(Float.parseFloat(jTextFieldPreco.getText()));

            if (p.getNome().isBlank() || p.getDescricao().isBlank()) {
                Msg.exibirMensagem("Nome e descrição são obrigatórios", "Aviso", 2);
            } else {
                LojaController lc = new LojaController();

                if (lc.novoProduto(p)) {
                    Msg.exibirMensagem("Produto adicionado com sucesso!", "Sucesso", 1);
                    jDialogAddProduto.setVisible(false);
                    this.paginaAtual = 1;
                    this.atualizarCompontentes();
                }
            }
        } catch (NumberFormatException e) {
            Msg.exibirMensagem("O valor inserido no campo Preço é inválido", "Aviso", 2);
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    /**
     * fecha a tela de adicionar produto
     */
    private void jButtonCancelarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarProdutoActionPerformed
        jDialogAddProduto.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarProdutoActionPerformed

    /**
     * Volta uma página
     */
    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        this.paginaAtual--;
        this.atualizarCompontentes();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    /**
     * Avança uma página
     */
    private void jButtonProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximaActionPerformed
        this.paginaAtual++;
        this.atualizarCompontentes();
    }//GEN-LAST:event_jButtonProximaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterarNome;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelar1;
    private javax.swing.JButton jButtonCancelarProduto;
    private javax.swing.JButton jButtonCarregarArquivo;
    private javax.swing.JButton jButtonProxima;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvarSenha;
    private javax.swing.JDialog jDialogAddProduto;
    private javax.swing.JDialog jDialogConfig;
    private javax.swing.JLabel jLabelAdicionarProduto;
    private javax.swing.JLabel jLabelCarrinho;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelConfirmarNovaSenha;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmailTip;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeProduto;
    private javax.swing.JLabel jLabelNovaSenha;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelSemProduto;
    private javax.swing.JLabel jLabelSenhaAtual;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelAddProduto;
    private javax.swing.JPanel jPanelNavBar;
    private javax.swing.JPanel jPanelNomeEmail;
    private javax.swing.JPanel jPanelProdutos;
    private javax.swing.JPanel jPanelSenha;
    private javax.swing.JPasswordField jPasswordFieldConfirmarNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldNovaSenha;
    private javax.swing.JPasswordField jPasswordFieldSenhaAtual;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneProdutos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeProduto;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
