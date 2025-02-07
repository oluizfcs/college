package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para realizar atualizações no banco de dados.
 *
 * @author luiz
 */
public class Update extends Conexao {

    private Object obj, whereValor;
    private String whereColuna = null, query;
    private final HashMap<String, Object> dados = new HashMap<>();
    private int result;
    private Object[][] condicoes = null;

    /**
     * Recebe um objeto e com base na sua classe, procura a tabela no banco de
     * dados para realizar as atualizações com uma condição
     *
     * @param obj Quem será atualizado
     * @param whereColuna Qual coluna o identifica
     * @param whereValor Qual valor o identifica
     */
    public void atualizar(Object obj, String whereColuna, Object whereValor) {
        this.obj = obj;
        this.whereColuna = whereColuna;
        this.whereValor = whereValor;

        this.construirQuery();
        this.executarQuery();

        this.obj = null;
        this.whereColuna = null;
        this.whereValor = null;
    }

    /**
     * Recebe um objeto e com base na sua classe, procura a tabela no banco de
     * dados para realizar as atualizações com múltiplas condições
     *
     * @param obj Quem será atualizado
     * @param condicoes WHERE e AND
     */
    public void atualizar(Object obj, Object[][] condicoes) {
        this.obj = obj;
        this.condicoes = condicoes;

        this.construirQuery();
        this.executarQuery();

        this.obj = null;
        this.condicoes = null;
    }

    /**
     * Cria a query de atualização
     */
    private void construirQuery() {

        String tabela = obj.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        StringBuilder sb = new StringBuilder("UPDATE " + tabela + " SET ");

        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                dados.put(f.getName(), f.get(obj));
            } catch (IllegalAccessException e) {
                Msg.exibirMensagem(e.getMessage(), "Erro de reflexão", 0);
            }
        }

        sb.append(String.join(" = ?, ", dados.keySet()));
        sb.append(" = ?");

        if (whereColuna != null) {
            sb.append(" WHERE " + whereColuna + " = ?");

        } else if (condicoes != null) {
            sb.append(" WHERE " + String.valueOf(condicoes[0][0]) + " = ?");

            if (condicoes.length > 1) {
                for (int i = 1; i < condicoes.length; i++) {
                    sb.append(" AND " + condicoes[i][0] + " = ?");
                }
            }
        }

        query = sb.toString();
    }

    /**
     * Executa a query de atualização
     */
    private void executarQuery() {

        Connection conn = super.getConnection();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            int i = 1;
            for (String dado : dados.keySet()) {
                stmt.setObject(i, dados.get(dado));
                i++;
            }
            
            if(whereValor != null) {
                stmt.setObject(dados.size() + 1, whereValor);
            } else if(condicoes != null) {
                for(int j = 0; j < condicoes.length; j++) {
                    stmt.setObject(dados.size() + 1 + j, condicoes[j][1]);;
                }
            }

            result = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Update.executarQuery(): " + e.getMessage(), "Erro SQL", 0);
        }

    }

    /**
     * Verifica se algum registro do banco de dados foi afetado com a query
     *
     * @return true - caso tenha afetado pelo menos 1<br>false - caso não tenha
     * afetado nenhum
     */
    public boolean getResult() {
        return result != 0;
    }
}
