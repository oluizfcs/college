package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para realizar inserções no banco de dados
 *
 * @author luiz
 */
public class Create {

    private Object obj;

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

        this.obj = objeto;

        construirQuery();
        executarQuery();

        this.obj = null;
    }

    /**
     * Trabalha o HashMap de dados para construir a string de query
     * dinâmicamente
     */
    private void construirQuery() {

        dados.clear();

        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                this.dados.put(f.getName(), f.get(obj));
            } catch (IllegalAccessException e) {
                Msg.exibirMensagem(e.getMessage(), "Erro de Reflexão", 0);
            }
        }

        // Exceções
        dados.remove("id");
        dados.remove("admin");
        dados.remove("idendereco");

        String tabela = obj.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        String colunas = " (" + String.join(", ", dados.keySet()) + ") ";

        String interrogacoes = ("(" + String.join(", ", Collections.nCopies(dados.size(), "?")) + ")");

        query = ("INSERT INTO " + tabela + colunas + "VALUES" + interrogacoes);
    }

    /**
     * Executa a query de inserção
     */
    private void executarQuery() {
        
        try (PreparedStatement stmt = Conexao.getConnection().prepareStatement(query)) {
            
            setarParametros(stmt);
            
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            Msg.exibirMensagem("Create.executarQuery(): " + e.getMessage(), "Erro SQL", 0);
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
            Msg.exibirMensagem("Create.setarParametros(): " + e.getMessage(), "Erro SQL", 0);
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
