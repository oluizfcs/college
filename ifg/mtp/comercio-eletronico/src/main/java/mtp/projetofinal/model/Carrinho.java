package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.utils.Msg;

/**
 * Model responsável por cuidar de algumas das queries dos pedidos.á
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
     * Busca quantos pedidos um determinado produto possui.
     *
     * @param idproduto
     * @return quantos pedidos o produto tem
     */
    public int getQuantidadeDePedidos(int idproduto) {

        int qtd = 0;

        try {

            PreparedStatement stmt = this.conn.prepareStatement("""
                SELECT COUNT(idproduto) 
                FROM pedido_produto
                JOIN pedido ON idpedido = pedido.id
                WHERE idstatus = 2 AND pedido_produto.idproduto = ?
            """);

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
     * Busca os produtos no carrinho do usuário x
     *
     * @param idusuario
     * @return ArrayList dos produtos com as quantidades
     */
    public HashMap<Produto, Integer> getProdutos(int idusuario) {

        HashMap<Produto, Integer> produtos = new HashMap<>();

        try {

            PreparedStatement stmt = this.conn.prepareStatement("""
                SELECT  produto.id, produto.nome, produto.descricao, produto.preco, produto.foto, pedido_produto.quantidade
                FROM produto
                JOIN pedido_produto ON produto.id = pedido_produto.idproduto
                JOIN pedido ON pedido.id = pedido_produto.idpedido
                WHERE idusuario = ? AND idstatus = 1
            """);

            stmt.setInt(1, idusuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();

                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setFoto(rs.getString("foto"));

                produtos.put(p, rs.getInt("quantidade"));
            }

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Carrinho.getQuantidadeDePedidos(): " + e.getMessage(), "Erro SQL", 0);
        }

        return produtos;
    }
}
