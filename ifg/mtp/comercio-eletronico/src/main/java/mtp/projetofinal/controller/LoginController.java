package mtp.projetofinal.controller;

import java.util.HashMap;
import mtp.projetofinal.model.LoginModel;

/**
 *
 * @author luiz
 */
public class LoginController {
    
    HashMap<String, String> usuario;
    
    public Boolean login(HashMap dados) {
        
        LoginModel lm = new LoginModel();
        
        if(lm.validarLogin(dados)) {
            
            this.usuario = lm.getUsuario();
            return true;
        } else {
            return false;
        }
    }
    
    public HashMap getUsuario() {
        return this.usuario;
    }
}
