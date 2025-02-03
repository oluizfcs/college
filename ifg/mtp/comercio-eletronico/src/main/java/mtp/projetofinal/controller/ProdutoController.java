package mtp.projetofinal.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import mtp.projetofinal.model.Carrinho;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.PedidoProduto;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.crud.Create;
import mtp.projetofinal.model.crud.Delete;
import mtp.projetofinal.model.crud.Update;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.utils.Msg;

/**
 *
 * @author luiz
 */
public class ProdutoController {

    private Produto produto;

    /**
     * Cuida da exclusão do produto
     *
     * @param produto qual produto será excluido
     * @return true a exclusão deu certo <br> a exclusão não deu certo
     */
    public static Boolean excluir(Produto produto) {

        int qtdPedidos = new Carrinho().getQuantidadeDePedidos(produto.getId());

        if (qtdPedidos > 0) {

            Msg.exibirMensagem("Não foi possível excluir esse produto pois ele possui " + qtdPedidos + " pedido(s)", "Aviso", 2);

            return false;

        } else {

            Delete d = new Delete();

            d.apagar(new PedidoProduto(), new Object[][]{{"idproduto", produto.getId()}});
            d.apagar(produto, new Object[][] {{"id", produto.getId()}});

            return true;
        }
    }

    /**
     * Cuida da alteração das informações do produto
     *
     * @param produto qual produto será editado
     * @return true a alteração deu certo <br> a alteração deu errado
     */
    public boolean editarProduto(Produto produto) {
        Update u = new Update();

        this.produto = produto;

        u.atualizar(produto, "id", produto.getId());

        return u.getResult();
    }

    /**
     * Busca o produto com as informações atualizadas e o retorna
     *
     * @return o produto atualizado
     */
    public Produto getProdutoAtualizado() {
        Read r = new Read();

        r.ler(this.produto, "id", this.produto.getId());

        Produto p = (Produto) r.getResult().get(0);

        return p;
    }

    /**
     * Coloca um produto no carrinho do usuário desejado.
     *
     * @param idusuario
     * @param idproduto
     * @return true deu certo<br> false não deu certo
     */
    public Boolean adicionarCarrinho(int idusuario, int idproduto) {

        Read r = new Read();

        r.ler(new Pedido(), new Object[][]{{"idusuario", idusuario}, {"idstatus", 1}});

        if (!r.getResult().isEmpty()) { // já existe carrinho, adicionando no existente.

            Pedido pedido = (Pedido) r.getResult().get(0);

            r.ler(new PedidoProduto(), new Object[][]{{"idpedido", pedido.getId()}, {"idproduto", idproduto}});

            if (r.getResult().isEmpty()) { // Esse produto ainda não está no carrinho

                PedidoProduto pp = new PedidoProduto();

                pp.setIdpedido(pedido.getId());
                pp.setIdproduto(idproduto);
                pp.setQuantidade(1);

                new Create().inserir(pp);

                return true;

            } else { // O produto já está no carrinho, aumentando quantidade.

                PedidoProduto pp = (PedidoProduto) r.getResult().get(0);

                pp.setQuantidade(pp.getQuantidade() + 1);

                Update u = new Update();

                u.atualizar(pp, new Object[][]{{"idpedido", pp.getIdpedido()}, {"idproduto", pp.getIdproduto()}});

                return u.getResult();
            }

        } else { // criando o "carrinho" antes de adicionar o produto

            Pedido p = new Pedido();

            p.setIdstatus(1);
            p.setIdusuario(idusuario);
            p.setValortotal(BigDecimal.ZERO);

            new Create().inserir(p);

            return adicionarCarrinho(idusuario, idproduto);
        }
    }

    /**
     * Busca os produtos no carrinho de usuário x, caso não tenha carrinho, cria
     * antes.
     *
     * @param idusuario
     * @return Produto, Quantidade
     */
    public HashMap<Produto, Integer> getProdutosNoCarrinho(int idusuario) {

        Read r = new Read();

        r.ler(new Pedido(), new Object[][] {{"idusuario", idusuario}, {"idstatus", 1}});

        if (!r.getResult().isEmpty()) {
            
            return new Carrinho().getProdutos(idusuario);
            
        } else {
            
            Pedido p = new Pedido();

            p.setIdstatus(1);
            p.setIdusuario(idusuario);
            p.setValortotal(BigDecimal.ZERO);

            new Create().inserir(p);
            
            return getProdutosNoCarrinho(idusuario);
        }
    }
}
