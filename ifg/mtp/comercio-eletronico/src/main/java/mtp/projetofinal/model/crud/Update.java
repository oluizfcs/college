package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import mtp.projetofinal.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para realizar atualizações no banco de dados.
 *
 * @author luiz
 */
public class Update extends Conexao {

    private Object obj, whereValor;
    private String whereColuna, tabela, query;
    private final HashMap<String, Object> dados = new HashMap<>();
    private int result;

    /**
     * Recebe um objeto e com base na sua classe, procura a tabela no banco de
     * dados para realizar as atualizações
     *
     * @param obj Quem será atualizado
     * @param whereColuna Qual coluna o identifica
     * @param whereValor Qual valor o identifica
     */
    public void atualizar(Object obj, String whereColuna, Object whereValor) {
        this.obj = obj;
        this.whereColuna = whereColuna;
        this.whereValor = whereValor;

        this.tabela = obj.getClass().getSimpleName().toLowerCase();

        this.construirQuery();
        this.executarQuery();
    }

    /**
     * Cria a query de atualização
     */
    private void construirQuery() {

        StringBuilder sb = new StringBuilder("UPDATE " + this.tabela + " SET ");

        for (Field f : this.obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                this.dados.put(f.getName(), f.get(this.obj));
            } catch (IllegalAccessException e) {
                Msg.exibirMensagem(e.getMessage(), "Erro de reflexão", 0);
            }
        }

        sb.append(String.join(" = ?, ", this.dados.keySet()));

        sb.append(" = ? WHERE " + this.whereColuna + " = ?");

        this.query = sb.toString();
    }

    /**
     * Executa a query de atualização
     */
    private void executarQuery() {

        Connection conn = super.getConnection();

        try {

            PreparedStatement stmt = conn.prepareStatement(this.query);

            int i = 1;
            for (String dado : this.dados.keySet()) {
                stmt.setObject(i, this.dados.get(dado));
                i++;
            }
            stmt.setObject(i, this.whereValor);

            this.result = stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }

    }

    /**
     * Verifica se algum registro do banco de dados foi afetado com a query
     * 
     * @return true - caso tenha afetado pelo menos 1<br>false - caso não tenha afetado nenhum
     */
    public boolean getResult() {
        return this.result != 0;
    }
}
