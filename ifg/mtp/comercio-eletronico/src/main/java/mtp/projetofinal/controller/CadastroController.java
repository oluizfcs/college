package mtp.projetofinal.controller;

import java.util.HashMap;
import mtp.projetofinal.model.CadastroModel;
import mtp.projetofinal.model.crud.Create;

/**
 * Supervisiona o processo de cadastrar novos usuários no banco de dados
 * 
 * @author luizf
 */
public class CadastroController {
    
    /**
     * Recebe os dados da View e manda para a Model validar, caso tenha dado certo, passa essa informação de volta para a view.
     * @param dados as informaçãoes que foram preenchidas no formulário da view
     * @return true caso o cadastro tenha dado certo<br>false caso não tenha dado certo
     */
    public static boolean cadastrar(HashMap dados) {
        
        
        CadastroModel cm = new CadastroModel();
        
        if(cm.validar(dados)) {
            
            Create c = new Create();
            
            dados.remove("confirmarSenha");
            
            c.inserir("usuario", dados);
        
            return c.getResult();
        } else {
            return false;
        }
   
    }
}
