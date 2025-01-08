package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.Msg;

/**
 * Valida as informações presentes nos campos do formulário de cadastro
 * 
 * @author luiz
 */
public class CadastroModel extends Conexao {
    
    // Valores dos campos
    private String nome, email, senha, confirmarSenha;
    
    /**
     * Confere se todas as validações foram atendidas
     * 
     * @param dados as informações recebidas da controller
     * @return 
     */
    public boolean validar(HashMap dados) {

        this.nome = (String) dados.get("nome");
        this.email = (String) dados.get("email");
        this.senha = (String) dados.get("senha");
        this.confirmarSenha = (String) dados.get("confirmarSenha");
        
        return this.camposPreenchidos() && this.senhasCoincidem() && this.emailValido();  
    }
    
    /**
     * Verifica se todos os campos foram preenchidos
     */
    private boolean camposPreenchidos() {
        
        if (this.nome.equals("") || this.email.equals("") || this.senha.equals("")) {
            Msg.exibirMensagem("Todos os campos devem ser preenchidos", "Aviso", 2);
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Verifica se as senhas coincidem 
     */
    private boolean senhasCoincidem() {
        if (!this.senha.equals(this.confirmarSenha)) {
            Msg.exibirMensagem("As senhas não coincidem", "Aviso", 2);
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Verifica se o e-mail que o usuário está tentando cadastrar já existe no banco de dados
     * @return true o email não foi cadastrado anteriormente <br> false o email já existe no banco
     */
    private boolean emailValido() {
        Connection conn = super.getConnection();
        
        Boolean emailExiste = false;
        
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT email FROM usuario WHERE email = ?");
            stmt.setString(1, this.email);
            ResultSet rs = stmt.executeQuery();
            emailExiste = rs.next();
            stmt.close();
        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }
        
        if(emailExiste) {
            Msg.exibirMensagem("Este e-mail já foi cadastrado anteriormente. Vá para a página de login!", "Aviso", 2);
        }
        
        return !emailExiste;
    }
}
