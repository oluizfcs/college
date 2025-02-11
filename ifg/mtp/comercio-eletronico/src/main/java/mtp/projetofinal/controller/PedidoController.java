package mtp.projetofinal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mtp.projetofinal.model.Carrinho;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.PedidoProduto;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.model.crud.Update;

/**
 *
 * @author luizf
 */
public class PedidoController {

    /**
     * Salva os produtos e suas quantidades atualizadas após intervenção do
     * usuário na aplicação
     *
     * @param produtos Relação entre objeto Produto e a quantidade deles no
     * carrinho
     * @param usuario Usuário dono do carrinho em questão
     */
    public static void atualizarProdutosCarrinho(HashMap<Produto, Integer> produtos, Usuario usuario) {

        Integer idpedido = UsuarioController.getIdCarrinho(usuario);

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

    /**
     * Remove o pedido do carrinho e passa ele para a lista de pedidos
     * finalizados.
     *
     * @param pedido
     */
    public static void finalizarCompra(Pedido pedido) {

        pedido.setIdstatus(2);

        new Update().atualizar(pedido, "id", pedido.getId());
    }

    /**
     * Verifica se o produto está no carrinho do usuário
     *
     * @param usuario
     * @param produto
     * @return true caso esteja<br> false caso não esteja.
     */
    public static Boolean produtoEstaNoCarrinho(Usuario usuario, Produto produto) {

        Integer idcarrinho = UsuarioController.getIdCarrinho(usuario);

        if (idcarrinho != null) {
            return new Carrinho().produtoEstaNoCarrinho(produto.getId(), idcarrinho);
        }

        return false;
    }
    
    public static ArrayList<Pedido> getPedidos(Usuario usuario) {
        
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        Read r = new Read();
        r.ler(new Pedido(), new Object[][] {{"idusuario", usuario.getId()}, {"idstatus", 2}});
        
        for(Object obj : r.getResult()) {
            Pedido p = (Pedido) obj;
            
            pedidos.add(p);
        }
        
        if(pedidos.isEmpty()) {
            return null;
        } else {
            return pedidos;
        }
    }
}
