package mtp.projetofinal.controller;

import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Read;

/**
 *
 * @author luiz
 */
public class LoginController {

    Usuario usuario;

    /**
     * Pega os dados da view e conversa com a model para efetuar o login
     *
     * @param email
     * @param senha
     * @return true se der certo <br> false se der errado
     */
    public Boolean login(String email, String senha) {

        this.usuario = new Usuario();
        
        this.usuario.setEmail(email);
        this.usuario.setSenha(senha);
        
        Read r = new Read();
        
        r.ler(usuario, "email", email);
        
        if(!r.getResult().isEmpty()) {
            
            Usuario u = (Usuario) r.getResult().get(0);
            this.usuario.setNome(u.getNome());
            
            return true;
        }
        
        return false;
    }
    
    /**
     * Devolve um usuário para a view
     *
     * @return
     */
    public Usuario getUsuario() {
        return this.usuario;
    }
}
