package mtp.projetofinal.model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.utils.Msg;

/**
 *
 * @author luiz
 */
public class Pedido {

    private Integer id;
    private Integer idusuario;
    private Integer idendereco;
    private BigDecimal valortotal;
    private Integer idstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(Integer idendereco) {
        this.idendereco = idendereco;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Integer getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Integer idstatus) {
        this.idstatus = idstatus;
    }

    public HashMap<Produto, Integer> produtos() {

        HashMap<Produto, Integer> produtos = new HashMap<>();

        String query = """
            SELECT  produto.id, produto.nome, produto.descricao, produto.preco, produto.foto, pedido_produto.quantidade
            FROM produto
            JOIN pedido_produto ON produto.id = pedido_produto.idproduto
            JOIN pedido ON pedido.id = pedido_produto.idpedido
            WHERE idpedido = ?
        """;

        try (PreparedStatement stmt = Conexao.getConnection().prepareStatement(query)) {
            
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                
                while (rs.next()) {
                    
                    Produto p = new Produto();
                    
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setPreco(rs.getBigDecimal("preco"));
                    p.setFoto(rs.getString("foto"));
                    
                    produtos.put(p, rs.getInt("quantidade"));
                }
            }
            
        } catch (SQLException e) {
            Msg.exibirMensagem("Pedido.produtos(): " + e.getMessage(), "Erro SQL", 0);
        }

        return produtos;
    }

    public Endereco endereco() {

        Read r = new Read();

        r.ler(new Endereco(), "id", idendereco);

        return (Endereco) r.getResult().get(0);
    }
}
