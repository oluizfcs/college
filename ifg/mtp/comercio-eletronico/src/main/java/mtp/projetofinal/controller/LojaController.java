package mtp.projetofinal.controller;

import java.util.ArrayList;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Create;
import mtp.projetofinal.model.crud.Update;
import mtp.projetofinal.model.crud.Read;

/**
 *
 * @author luiz
 */
public class LojaController {

    private Usuario usuario;

    /**
     * Com base no e-mail do usuário recebido, envia para a model atualizá-lo.
     *
     * @param usuario um usuário com nome ou senha modificado
     * @return true - deu certo<br>false - deu errado
     */
    public Boolean alterarDados(Usuario usuario) {

        Update u = new Update();

        u.atualizar(usuario, "email", usuario.getEmail());

        if (u.getResult()) {
            Read r = new Read();
            r.ler(usuario, "email", usuario.getEmail());
            this.usuario = (Usuario) r.getResult().get(0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna o usuário atualizado
     *
     * @return o usuário atualizado
     */
    public Usuario getUsuarioAtualizado() {
        return this.usuario;
    }

    /**
     * Te dá uma lista de produtos
     *
     * @param pagina qual página será buscada
     * @param qtd quantos produtos terá na lista
     * @return a lista contendo a qtd de produtos desejada
     */
    public static ArrayList<Object> getProdutos(int pagina, int qtd) {
        Read r = new Read();
        r.ler(new Produto(), pagina, qtd);
        return r.getResult();
    }

    /**
     * Cadastra um novo produto no banco de dados com base nas informações
     * passadas pela view
     *
     * @param produto o produto a ser cadastrado
     * @return true cadastrou com sucesso <br> false falha ao cadastrar
     */
    public Boolean novoProduto(Produto produto) {
        Create c = new Create();

        c.inserir(produto);

        return c.getResult();
    }
}
