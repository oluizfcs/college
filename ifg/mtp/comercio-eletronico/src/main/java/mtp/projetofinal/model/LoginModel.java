package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.Msg;

/**
 *
 * @author luiz
 */
public class LoginModel extends Conexao {
    
    private String email, senha;
    
    private final HashMap<String, String> usuario = new HashMap<>();
    
    public Boolean validarLogin(HashMap<String, String> dados) {
        
        this.email = dados.get("email");
        this.senha = dados.get("senha");
        
        if(this.camposPreenchidos()) {
            this.buscarUsuario();
            if(!usuario.isEmpty()) {
                return this.senhaCorreta();
            }
        }
        
        return false;
    }
    
    private Boolean camposPreenchidos() {
        if(this.email.equals("") | this.senha.equals("")) {
            Msg.exibirMensagem("Todos os campos devem ser preenchidos", "Aviso", 2);
            return false;
        } else {
            return true;
        }
    }
    
    private void buscarUsuario() {
        try {
            Connection conn = super.getConnection();
        
            PreparedStatement stmt = conn.prepareStatement("SELECT nome, email, senha FROM usuario WHERE email = ?");
            stmt.setString(1, this.email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                this.usuario.put("nome", rs.getString(1));
                this.usuario.put("email", rs.getString(2));
                this.usuario.put("senha", rs.getString(3));
                stmt.close();
            } else {
                Msg.exibirMensagem("Usuário ou senha incorretos", "Aviso", 2);
                stmt.close();
            }
        } catch(SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }
    }
    
    private Boolean senhaCorreta() {
        if(this.senha.equals(this.usuario.get("senha"))) {
            return true;
        } else {
            Msg.exibirMensagem("Usuário ou senha incorretos", "Aviso", 2);
            return false;
        }
    }
    
    public HashMap getUsuario() {
        return this.usuario;
    }
}
