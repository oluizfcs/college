package mtp.projetofinal.controller;

import java.util.ArrayList;
import mtp.projetofinal.model.Endereco;
import mtp.projetofinal.model.Pedido;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Create;
import mtp.projetofinal.model.crud.Read;
import mtp.projetofinal.utils.Msg;

/**
 *
 * @author luizf
 */
public class UsuarioController {

    /**
     * Recebe os dados da View e manda para a Model validar, caso tenha dado
     * certo, passa essa informação de volta para a view.
     *
     * @param usuario contém os dados a serem cadastrados
     * @return true caso o cadastro tenha dado certo<br>false caso não tenha
     * dado certo
     */
    public static boolean cadastrar(Usuario usuario) {

        Read r = new Read();
        r.ler(usuario, "email", usuario.getEmail());

        if (!r.getResult().isEmpty()) {

            Msg.exibirMensagem("Este email já foi cadastrado!", "Aviso", 2);
            return false;

        } else {

            Create c = new Create();

            c.inserir(usuario);

            return c.getResult();
        }

    }

    /**
     * Pega os dados da view e conversa com a model para efetuar o login
     *
     * @param usuario
     * @return true se der certo <br> false se der errado
     */
    public static Usuario login(Usuario usuario) {

        Read r = new Read();

        r.ler(usuario, "email", usuario.getEmail());

        if (!r.getResult().isEmpty()) {

            Usuario usuarioDoBanco = (Usuario) r.getResult().get(0);

            if(usuario.getSenha().equals(usuarioDoBanco.getSenha())) {
                
                return usuarioDoBanco;
            }
        }

        return null;
    }

    /**
     *
     * @param usuario
     * @return todos os endereços do usuário
     */
    public static ArrayList<Endereco> getEnderecos(Usuario usuario) {

        ArrayList<Endereco> enderecos = new ArrayList<>();

        Read r = new Read();

        r.ler(new Endereco(), "idusuario", usuario.getId());

        for (Object obj : r.getResult()) {

            Endereco e = (Endereco) obj;

            enderecos.add(e);
        }

        return enderecos;
    }

    /**
     * Busca o id do carrinho do usuário
     * 
     * @param usuario
     * @return idpedido correspondente ao carrinho
     */
    public static Integer getIdCarrinho(Usuario usuario) {
        Read r = new Read();

        r.ler(new Pedido(), new Object[][]{{"idusuario", usuario.getId()}, {"idstatus", 1}});

        if (!r.getResult().isEmpty()) {
            Pedido p = (Pedido) r.getResult().get(0);
            return p.getId();
        } else {
            return null;
        }
    }
}
