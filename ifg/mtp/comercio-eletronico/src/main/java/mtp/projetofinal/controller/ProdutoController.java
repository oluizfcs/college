package mtp.projetofinal.controller;

import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.crud.Delete;
import mtp.projetofinal.model.crud.Update;
import mtp.projetofinal.model.crud.Read;

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

        d.apagar(produto);

        return d.getResult();
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

}
