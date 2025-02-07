package mtp.projetofinal.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.model.crud.Update;

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

    public void atualizarProdutosCarrinho(HashMap<Produto, Integer> produtos, Usuario usuario) {

        Integer idpedido = usuario.pegarIdCarrinho();

        Update u = new Update();

        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {

            Produto produto = (Produto) entry.getKey();

            PedidoProduto pp = new PedidoProduto();

            pp.setIdpedido(idpedido);
            pp.setIdproduto(produto.getId());
            pp.setQuantidade(entry.getValue());

            u.atualizar(pp, new Object[][]{{"idpedido", idpedido}, {"idproduto", produto.getId()}});
        }
    }

    public void finalizarCompra() {

        setIdstatus(2);

        Update u = new Update();

        u.atualizar(this, "id", id);

    }
}
