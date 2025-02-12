package mtp.projetofinal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import mtp.projetofinal.utils.Msg;

/**
 * Responsável por estabelecer uma conexão com o banco de dados.
 *
 * @author luiz
 */
public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost/comercio_eletronico";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection conn;

    private Conexao() {
    }

    /**
     * @return Conexão com o banco de dados
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                Msg.exibirMensagem("Não há conexão com o banco de dados. Encerrando Sistema." + e.getMessage(), "ERRO FATAL", 0);
                System.exit(1);
            }
        }
        return conn;
    }
}
