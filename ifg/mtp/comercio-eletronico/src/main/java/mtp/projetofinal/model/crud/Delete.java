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
    private String tabela;
    private int id = -1;
    private Boolean result = false;

    /**
     * Recebe um objeto e a partir do seu id, o apaga.
     *
     * @param objeto o objeto a ser apagado
     */
    public void apagar(Object objeto) {
        this.objeto = objeto;
        this.tabela = objeto.getClass().getSimpleName().toLowerCase();
        this.id = getObjectId();

        executarQuery();
    }

    /**
     * Executa o método getId do objeto a ser deletado.
     *
     * @return o id do objeto
     */
    private int getObjectId() {
        int objectId = -1;
        try {
            Method m = this.objeto.getClass().getMethod("getId");

            objectId = (int) m.invoke(this.objeto);
        } catch (NoSuchMethodException e) {
            Msg.exibirMensagem("Não existe método getId", "Erro", 0);
        } catch (IllegalAccessException e) {
            Msg.exibirMensagem("Não foi possível acessar o método getId", "Erro", 0);
        } catch (InvocationTargetException e) {
            Msg.exibirMensagem("Erro ao invocar o método getId", "Erro", 0);
        }

        for (Field f : this.objeto.getClass().getDeclaredFields()) {
            f.setAccessible(true);

        }

        return objectId;
    }

    /**
     * Executa a query de exclusão
     */
    private void executarQuery() {
        Connection conn = super.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + this.tabela + " WHERE id =  ?");
            if (this.id != -1) {
                stmt.setInt(1, this.id);
                stmt.executeUpdate();
                this.result = true;
                stmt.close();
            } else {
                Msg.exibirMensagem("Não foi possível excluir por um erro ao encontrar o id do objeto", "Erro", 0);
                stmt.close();
            }

        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }

    }

    /**
     * Informa se deu certo ou errado a exclusão
     *
     * @return true deu certo <br> false deu errado
     */
    public Boolean getResult() {
        return this.result;
    }
}
