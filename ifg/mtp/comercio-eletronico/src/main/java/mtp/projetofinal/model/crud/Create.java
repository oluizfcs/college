package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import mtp.projetofinal.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para realizar inserções no banco de dados
 *
 * @author luiz
 */
public class Create extends Conexao {

    // Nome da tabela
    private String tabela;

    // Dados a serem inseridos
    private final HashMap<String, Object> dados = new HashMap<>();

    // Query a ser executada
    private String query;

    // Contém o resultado da inserção
    private int result;

    /**
     * Inicia o processo de inserir um novo registro no banco
     *
     * @param objeto quem será inserido no banco de dados
     */
    public void inserir(Object objeto) {

        this.tabela = objeto.getClass().getSimpleName().toLowerCase();

        for (Field f : objeto.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                this.dados.put(f.getName(), f.get(objeto));
            } catch (IllegalAccessException e) {
                Msg.exibirMensagem(e.getMessage(), "Erro de Reflexão", 0);
            }
        }
        
        this.dados.remove("id");

        this.construirQuery();
        this.executarQuery();
    }

    /**
     * Trabalha o HashMap de dados para construir a string de query
     * dinâmicamente
     */
    private void construirQuery() {

        String colunas = " (" + String.join(", ", dados.keySet()) + ") ";

        String interrogacoes = ("(" + String.join(", ", Collections.nCopies(this.dados.size(), "?")) + ")");

        this.query = ("INSERT INTO " + this.tabela + colunas + "VALUES" + interrogacoes);
    }

    /**
     * Executa a query de inserção
     */
    private void executarQuery() {
        try {
            
            Connection conn = super.getConnection();

            PreparedStatement stmt = conn.prepareStatement(this.query);
            this.setarParametros(stmt);
            this.result = stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }

    }

    /**
     * Vincula as indices das ? com os valores a serem inseridos na query
     *
     * @param stmt
     */
    private void setarParametros(PreparedStatement stmt) {

        int i = 1;
        try {
            for (Object valor : dados.values()) {
                stmt.setObject(i, valor);
                i++;
            }
        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }
    }

    /**
     * Informa se a inserção foi bem sucedida ou não
     *
     * @return
     */
    public Boolean getResult() {

        return this.result != 0;
    }
}
