package mtp.projetofinal.model.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

abstract class Conexao {

    private final String url = "jdbc:postgresql://localhost/mtp";
    private final String user = "postgres";
    private final String password = "postgres";
    private Connection conn;

    /**
     * Método para conexão com o banco de dados.
     *
     * Carrega o driver e cria a conexão com o BD.
     */
    private void conectar() {
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Retorna a conexão com o banco de dados.
     * @return Connection objeto de conexão com o banco de dados 
     */
    protected Connection getConnection() {
        conectar();
        return this.conn;
    }
}
