package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import mtp.projetofinal.Msg;

public abstract class Conexao {

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

            this.conn = DriverManager.getConnection(this.url, this.user, this.password);

        } catch (ClassNotFoundException e) {
            Msg.exibirMensagem(e.getMessage(), "Classe não encontrada", 0);
        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }

    }

    /**
     * Retorna a conexão com o banco de dados.
     *
     * @return Connection objeto de conexão com o banco de dados
     */
    protected Connection getConnection() {
        conectar();
        return this.conn;
    }
}
