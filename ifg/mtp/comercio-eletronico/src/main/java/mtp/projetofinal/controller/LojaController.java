package mtp.projetofinal.controller;

import java.util.ArrayList;
import mtp.projetofinal.model.Produto;
import mtp.projetofinal.model.Usuario;
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
    
    public static ArrayList<Object> getProdutos() {
        Read r = new Read();
        r.ler(new Produto());
        return r.getResult();
    }
}
