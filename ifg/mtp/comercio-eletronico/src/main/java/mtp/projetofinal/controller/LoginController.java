package mtp.projetofinal.controller;

import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Read;

/**
 *
 * @author luiz
 */
public class LoginController {

    Usuario usuarioParaLogar, usuarioDoBanco;

    /**
     * Pega os dados da view e conversa com a model para efetuar o login
     *
     * @param email
     * @param senha
     * @return true se der certo <br> false se der errado
     */
    public Boolean login(String email, String senha) {

        this.usuarioParaLogar = new Usuario();

        this.usuarioParaLogar.setEmail(email);
        this.usuarioParaLogar.setSenha(senha);

        Read r = new Read();

        r.ler(this.usuarioParaLogar, "email", email);

        if (!r.getResult().isEmpty()) {

            this.usuarioDoBanco = (Usuario) r.getResult().get(0);

            if (this.senhaCorreta()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica se a senha coincide com a do banco de dados.
     *
     * @return true caso coincida <br> false caso não coincida
     */
    private Boolean senhaCorreta() {
        return this.usuarioParaLogar.getSenha().equals(this.usuarioDoBanco.getSenha());
    }

    /**
     * Devolve um usuário para a view
     *
     * @return usuário que foi retornado do banco de dados
     */
    public Usuario getUsuario() {
        return this.usuarioDoBanco;
    }
}
