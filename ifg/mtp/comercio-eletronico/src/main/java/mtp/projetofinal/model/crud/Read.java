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
    private String tabela, whereColuna = null;
    private Object obj = null, whereValor;
    private final ArrayList<Object> resultado = new ArrayList<>();
    private Object[][] condicoes = null;
    private StringBuilder query;

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

        this.construirQuery();
        query.append(" LIMIT " + qtdItens + " OFFSET " + (qtdItens * (pagina - 1)));
        this.executarQuery();

        this.obj = null;
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

        this.whereColuna = null;
        this.whereValor = null;
        this.obj = null;
    }

    /**
     * Busca todos os atributos de um objeto no banco de dados na tabela
     * referente ao nome da classe, com as condições desejadas.
     *
     * @param obj Objeto que será buscado
     * @param condicoes WHERE e AND
     */
    public void ler(Object obj, Object[][] condicoes) {
        this.obj = obj;
        this.condicoes = condicoes;

        this.construirQuery();
        this.executarQuery();

        this.obj = null;
        this.condicoes = null;
    }

    /**
     * Verifica quantos registros existem de determinado objeto
     *
     * @param obj quem será contado
     * @return a quantidade de registros encontrados
     */
    public int ler(Object obj) {

        int qtd = 0;

        // Nome da classe do objeto em camel_case
        tabela = obj.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        try {

            Connection conn = super.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM " + tabela);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            qtd = rs.getInt(1);

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Read.ler(Object obj): " + e.getMessage(), "Erro SQL", 0);
        }

        return qtd;
    }

    /**
     * Cria a query de seleção com base nas informações do objeto, como nome da
     * classe e atributos.
     */
    private void construirQuery() {

        this.tabela = obj.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

        this.colunas.clear();

        for (Field f : obj.getClass().getDeclaredFields()) {
            this.colunas.add(f.getName());
        }

        StringBuilder query = new StringBuilder("SELECT " + String.join(", ", colunas) + " FROM " + tabela);

        // Ler com uma condição só
        if (this.whereColuna != null) {
            query.append(" WHERE " + this.whereColuna + " = ?");

        } else if (condicoes != null) { // com múltiplas condições
            query.append(" WHERE " + String.valueOf(this.condicoes[0][0]) + " = ?");

            if (this.condicoes.length > 1) {
                for (int i = 1; i < this.condicoes.length; i++) {
                    query.append(" AND " + this.condicoes[i][0] + " = ?");
                }
            }
        }

        if (this.colunas.contains("id")) {
            query.append(" ORDER BY id DESC");
        }

        this.query = query;
    }

    /**
     * Executa a query de busca.
     */
    private void executarQuery() {
        try {

            Connection conn = super.getConnection();

            PreparedStatement stmt = conn.prepareStatement(query.toString());

            if (this.whereColuna != null) {
                stmt.setObject(1, this.whereValor);
            } else if (condicoes != null) {
                for (int i = 0; i < condicoes.length; i++) {

                    stmt.setObject(i + 1, condicoes[i][1]);
                }
            }

            ResultSet rs = stmt.executeQuery();

            this.percorerResultSet(rs);

            stmt.close();

        } catch (SQLException e) {
            Msg.exibirMensagem("Read.executarQuery(): " + e.getMessage(), "Erro SQL", 0);
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
     * Cria um novo objeto para cada registro encontrado e atribui seus valores.
     *
     * @param rs
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     */
    private void percorerResultSet(ResultSet rs) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        this.resultado.clear();

        while (rs.next()) {

            Object objetoNovo = this.obj.getClass().getDeclaredConstructor().newInstance();

            for (String coluna : this.colunas) {

                for (Method m : this.obj.getClass().getMethods()) {

                    if (m.getName().startsWith("set")) {

                        // Deixa a primeira letra da coluna (atributo) maiúscula
                        String colunaCapitalizada = coluna.substring(0, 1).toUpperCase() + coluna.substring(1);

                        // Verifica se o método tem o mesmo nome da coluna (atributo) que está sendo percorrida no primeiro for
                        if (m.getName().equals("set" + colunaCapitalizada)) {

                            // Executa o setter passando como único parâmetro o valor do result set
                            m.invoke(objetoNovo, rs.getObject(coluna));
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
