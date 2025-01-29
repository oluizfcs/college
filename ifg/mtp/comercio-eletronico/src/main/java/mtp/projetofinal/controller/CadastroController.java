package mtp.projetofinal.controller;

import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Usuario;
import mtp.projetofinal.model.crud.Create;
import mtp.projetofinal.model.crud.Read;

/**
 * Supervisiona o processo de cadastrar novos usuários no banco de dados
 *
 * @author luizf
 */
public class CadastroController {

    Usuario usuario;
    
    /**
     * Recebe os dados da View e manda para a Model validar, caso tenha dado
     * certo, passa essa informação de volta para a view.
     *
     * @param usuario contém os dados a serem cadastrados
     * @return true caso o cadastro tenha dado certo<br>false caso não tenha
     * dado certo
     */
    public boolean cadastrar(Usuario usuario) {

        this.usuario = usuario;
        
        if (this.emailExiste()) {
            
            Msg.exibirMensagem("Este email já foi cadastrado!", "Aviso", 2);
            return false;
            
        } else {
            
            Create c = new Create();

            c.inserir(usuario);

            return c.getResult();
        }

    }

    /**
     * Verifica se o e-mail que o usuário está tentando cadastrar já existe no
     * banco de dados
     *
     * @return false o email não foi cadastrado anteriormente <br> true o email
     * já existe no banco
     */
    private boolean emailExiste() {
        Read r = new Read();
        r.ler(this.usuario, "email", this.usuario.getEmail());
        
        return !r.getResult().isEmpty();
    }
}
