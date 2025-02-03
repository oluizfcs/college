package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para apagar registros no banco de dados.
 *
 * @author luiz
 */
public class Delete extends Conexao {

    private Object objeto;
    private String query;
    private Object[][] condicoes = null;

    public void apagar(Object objeto, Object[][] condicoes) {
        this.objeto = objeto;
        this.condicoes = condicoes;

        construirQuery();
        executarQuery();

        this.objeto = null;
        this.condicoes = null;
    }

    /**
     * Cria a query de exclusão
     */
    private void construirQuery() {

        String tabela = objeto.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        StringBuilder sb = new StringBuilder("DELETE FROM " + tabela);

        // excluir com condições
        if (this.condicoes != null) {

            sb.append(" WHERE " + String.valueOf(this.condicoes[0][0]) + " = ?");

            if (this.condicoes.length > 1) {
                for (int i = 1; i < this.condicoes.length; i++) {
                    sb.append(" AND " + this.condicoes[i][0] + " = ?");
                }
            }
        }

        this.query = sb.toString();
    }

    /**
     * Executa a query de exclusão
     */
    private void executarQuery() {
        Connection conn = super.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(query);

            for (int i = 0; i < condicoes.length; i++) {
                stmt.setObject(i + 1, condicoes[i][1]);
            }

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Delete.executarQuery(): " + e.getMessage(), "Erro SQL", 0);
        }
    }
}
