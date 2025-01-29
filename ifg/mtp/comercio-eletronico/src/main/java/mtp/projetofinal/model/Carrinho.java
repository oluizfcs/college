package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mtp.projetofinal.utils.Msg;

/**
 *
 * @author luiz
 */
public class Carrinho extends Conexao {

    Connection conn;

    /**
     * Cria um novo carrinho, responsável pela maior parte das interações entre
     * usuario-pedido-produto no banco de dados.
     */
    public Carrinho() {
        this.conn = super.getConnection();
    }

    /**
     * Com base no id do usuário, verifica se o mesmo possui algum pedido com
     * status "No Carrinho".
     *
     * @param idusuario
     * @return idpedido
     */
    public int getCarrinhoId(int idusuario) {

        int idpedido = -1;

        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT id FROM pedido WHERE idusuario = ? AND idstatus = 1;");
            stmt.setInt(1, idusuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idpedido = rs.getInt(1);
            }

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.getCarrinhoId(): " + e.getMessage(), "Erro SQL", 0);
        }

        return idpedido;
    }

    /**
     * Verifica se determinado produto está no carrinho e retorna a quantidade
     * de unidades que foram pedidas dele
     *
     * @param idcarrinho
     * @param idproduto
     * @return 0 caso o produto não esteja no carrinho<br>ou a quantidade
     * unidades dele no carrinho
     */
    public int getQuantidadeProduto(int idcarrinho, int idproduto) {

        int quantidade = 0;

        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT quantidade FROM pedido_produto WHERE idpedido = ? AND idproduto = ?");
            stmt.setInt(1, idcarrinho);
            stmt.setInt(2, idproduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                quantidade = rs.getInt(1);
            }

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.getQuantidadeProduto(): " + e.getMessage(), "Erro SQL", 0);
        }

        return quantidade;
    }

    /**
     * Altera a quantidade de produtos no Carrinho;
     *
     * @param idcarrinho
     * @param idproduto
     * @param quantidade
     * @return true deu certo<br> false não deu certo
     */
    public Boolean alterarQuantidadeDoProduto(int idcarrinho, int idproduto, int quantidade) {

        Boolean deuCerto = false;

        try {
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE pedido_produto SET quantidade = ? WHERE idpedido = ? AND idproduto = ?;");
            stmt.setInt(1, quantidade);
            stmt.setInt(2, idcarrinho);
            stmt.setInt(3, idproduto);

            if (stmt.executeUpdate() != 0) {
                deuCerto = true;
            }

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.alterarQuantidadeDoProduto(): " + e.getMessage(), "Erro SQL", 0);
        }

        return deuCerto;
    }

    /**
     * Insere o produto desejado no pedido com status de "No Carrinho"
     *
     * @param idcarrinho
     * @param idproduto
     * @param quantidade
     * @return true deu certo<br> false não deu certo
     */
    public Boolean inserirProdutoNoCarrinho(int idcarrinho, int idproduto, int quantidade) {

        Boolean deuCerto = false;

        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO pedido_produto (idpedido, idproduto, quantidade) VALUES (?, ?, ?);");
            stmt.setInt(1, idcarrinho);
            stmt.setInt(2, idproduto);
            stmt.setInt(3, quantidade);

            if (stmt.executeUpdate() != 0) {
                deuCerto = true;
            }

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.inserirProdutoNoCarrinho(): " + e.getMessage(), "Erro SQL", 0);
        }

        return deuCerto;
    }

    /**
     * Insere um novo pedido com idstatus "No Carrinho".
     *
     * @param idusuario
     */
    public void criarCarrinho(int idusuario) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO pedido (idusuario, idstatus) VALUES (?, 1);");
            stmt.setInt(1, idusuario);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.criarCarrinho(): " + e.getMessage(), "Erro SQL", 0);
        }
    }

    /**
     * Busca quantos pedidos um determinado produto possui.
     *
     * @param idproduto
     * @return quantos pedidos o produto tem
     */
    public int getQuantidadeDePedidos(int idproduto) {

        int qtd = 0;

        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT COUNT(idproduto) FROM pedido_produto JOIN pedido ON idpedido = pedido.id WHERE idstatus = 2 AND pedido_produto.idproduto = ?;");
            stmt.setInt(1, idproduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                qtd = rs.getInt(1);
            }

            stmt.close();
        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.getQuantidadeDePedidos(): " + e.getMessage(), "Erro SQL", 0);
        }

        return qtd;
    }

    /**
     * Remove todas os registros pedido_produto contendo o id informado
     *
     * @param idproduto o id do produto a ser removido dos carrinhos
     */
    public void removerDeTodosOsCarrinhos(int idproduto) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM pedido_produto WHERE idproduto = ?");
            stmt.setInt(1, idproduto);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.removerDeTodosOsCarrinhos(): " + e.getMessage(), "Erro SQL", 0);
        }
    }
}
