package mtp.projetofinal.controller;

import mtp.projetofinal.model.Carrinho;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
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
        Delete d = new Delete();

        Carrinho c = new Carrinho();

        int qtdPedidos = c.getQuantidadeDePedidos(produto.getId());

        if (qtdPedidos > 0) {
            Msg.exibirMensagem("Não foi possível excluir esse produto pois ele possui " + qtdPedidos + " pedido(s)", "Aviso", 2);
            return false;
        } else {
            c.removerDeTodosOsCarrinhos(produto.getId());
            d.apagar(produto);
            return d.getResult();
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

        Carrinho c = new Carrinho();

        int idcarrinho = c.getCarrinhoId(idusuario);

        if (idcarrinho != -1) { // já exise carrinho, adicionando no existente

            int quantidade = c.getQuantidadeProduto(idcarrinho, idproduto);

            if (quantidade == 0) {
                return c.inserirProdutoNoCarrinho(idcarrinho, idproduto, 1);
            } else {
                return c.alterarQuantidadeDoProduto(idcarrinho, idproduto, quantidade + 1);
            }

        } else { // ainda não existe carrinho, criando um novo
            c.criarCarrinho(idusuario);
            return this.adicionarCarrinho(idusuario, idproduto);
        }
    }

    // todo
    public Produto[] getProdutosCarrinho(Usuario usuario) {

        return null;
    }
}
