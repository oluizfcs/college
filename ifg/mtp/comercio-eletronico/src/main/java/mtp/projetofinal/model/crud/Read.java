package mtp.projetofinal.model.crud;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mtp.projetofinal.utils.Msg;
import mtp.projetofinal.model.Conexao;

/**
 * Classe genérica para realizar buscas no banco de dados
 *
 * @author luiz
 */
public class Read extends Conexao {

    private final ArrayList<String> colunas = new ArrayList<>();
    private String tabela, query, whereColuna;
    private Object obj = null, whereValor;
    private final ArrayList<Object> resultado = new ArrayList<>();
    private int pagina = -1, qtdItens;

    /**
     * Busca todos os atributos de um objeto no banco de dados na tabela
     * referente ao nome da classe.
     *
     * @param obj O objeto que será buscado
     * @param pagina O número da página a ser exibida
     * @param qtdItens quantidade de itens que será mostrada por página.
     */
    public void ler(Object obj, int pagina, int qtdItens) {
        this.obj = obj;
        this.pagina = pagina;
        this.qtdItens = qtdItens;

        this.construirQuery();
        this.executarQuery();
    }

    /**
     * Busca todos os atributos de um objeto no banco de dados na tabela
     * referente ao nome da classe, com a condição desejada.
     *
     * @param obj Objeto que será buscado
     * @param whereColuna Coluna de identificação
     * @param whereValor Valor de identificação
     */
    public void ler(Object obj, String whereColuna, Object whereValor) {
        this.obj = obj;
        this.whereColuna = whereColuna;
        this.whereValor = whereValor;

        this.construirQuery();
        this.executarQuery();
    }

    /**
     * Verifica quantos registros existem de determinado objeto
     *
     * @param obj quem será contado
     * @return a quantidade de registros encontrados
     */
    public int ler(Object obj) {

        int qtd = 0;

        this.tabela = obj.getClass().getSimpleName().toLowerCase();

        this.query = "SELECT count(*) FROM " + this.tabela;

        try {

            Connection conn = super.getConnection();

            PreparedStatement stmt = conn.prepareStatement(this.query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            qtd = rs.getInt(1);

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }

        return qtd;
    }

    /**
     * Cria a query de seleção com base nas informações do objeto, como nome da
     * classe e atributos.
     */
    private void construirQuery() {

        this.tabela = this.obj.getClass().getSimpleName().toLowerCase();

        for (Field f : obj.getClass().getDeclaredFields()) {
            this.colunas.add(f.getName());
        }

        StringBuilder sb = new StringBuilder("SELECT " + String.join(", ", colunas) + " FROM " + tabela);

        if (this.whereColuna != null) {
            sb.append(" WHERE " + this.whereColuna + " = ?");
        }

        sb.append(" ORDER BY id DESC");

        // paginação
        if (this.pagina != -1) {
            sb.append(" LIMIT " + this.qtdItens + " OFFSET " + (this.qtdItens * (this.pagina - 1)));
        }

        this.query = sb.toString();
    }

    /**
     * Executa a query de busca.
     */
    private void executarQuery() {
        try {

            Connection conn = super.getConnection();

            PreparedStatement stmt = conn.prepareStatement(this.query);
            if (this.whereColuna != null) {
                stmt.setObject(1, this.whereValor);
            }

            ResultSet rs = stmt.executeQuery();

            this.percorerResultSet(rs);

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        } catch (IllegalAccessException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro de acesso", 0);
        } catch (InvocationTargetException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro de chamada de método", 0);
        } catch (NoSuchMethodException e) {
            Msg.exibirMensagem(e.getMessage(), "Método não encontrado", 0);
        } catch (InstantiationException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro ao instanciar", 0);
        }
    }

    /**
     * esse daqui faz mágica
     * <hr>
     * Só funciona pois:<br>
     * - A query é construida na ordem que os atributos foram declarados.<br>
     * - O resultSet devolve as colunas buscadas nesta mesma ordem.
     *
     * @param rs
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     */
    private void percorerResultSet(ResultSet rs) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        while (rs.next()) {

            // Utiliza uma nova instância do objeto a cada registro descoberto
            Object objetoNovo = this.obj.getClass().getDeclaredConstructor().newInstance();

            // Contador que serve apenas para acessar o resultSet
            int i = 1;

            // Percorre cada coluna (atributo do objeto)
            for (String coluna : this.colunas) {

                // Percorre cada método do objeto
                for (Method m : this.obj.getClass().getMethods()) {

                    // Filtra os setters
                    if (m.getName().startsWith("set")) {

                        // Deixa a primeira letra da coluna (atributo) maiúscula
                        String colunaCapitalizada = coluna.substring(0, 1).toUpperCase() + coluna.substring(1);

                        // Verifica se o método tem o mesmo nome da coluna (atributo) que está sendo percorrida no primeiro for
                        if (m.getName().startsWith("set" + colunaCapitalizada)) {

                            // Executa o setter passando como único parâmetro o valor do result set
                            m.invoke(objetoNovo, rs.getObject(i));
                            i++;
                        }
                    }
                }
            }

            this.resultado.add(objetoNovo);
        }
    }

    /**
     * Entrega todos os registros encontrados
     *
     * @return lista de objetos contendo cada registro encontrado
     */
    public ArrayList<Object> getResult() {
        return this.resultado;
    }
}
