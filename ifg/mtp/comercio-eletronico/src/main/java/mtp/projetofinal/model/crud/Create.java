package mtp.projetofinal.model.crud;

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
    private HashMap<String, Object> dados;
    
    // Quantidade de valores a serem inseridos;
    private int size;
    
    // Query a ser executada
    private String query;
    
    // Contém o resultado da inserção
    private int result;

    /**
     * Inicia o processo de inserir um novo registro no banco
     * 
     * @param tabela nome da tabela onde os dados serão inseridos
     * @param dados relação chave-valor entre as colunas da tabela
     */
    public void inserir(String tabela, HashMap<String, Object> dados) {

        this.tabela = tabela;
        this.dados = dados;
        this.size = dados.values().size();

        this.construirQuery();
        this.executarQuery();
    }

    /**
     * Trabalha o HashMap de dados para construir a string de query dinâmicamente
     */
    private void construirQuery() {
        
        String colunas = " (" + String.join(", ", dados.keySet()) + ") ";
        
        String interrogacoes = ( "(" + String.join(", ", Collections.nCopies(this.size, "?")) + ")");
        
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
            for(Object valor : dados.values()) {
                stmt.setObject(i, valor);
                i++;
            }
        } catch (SQLException e) {
            Msg.exibirMensagem(e.getMessage(), "Erro SQL", 0);
        }
    }
    
    /**
     * Informa se a inserção foi bem sucedida ou não
     * @return 
     */
    public Boolean getResult() {
        
        return this.result != 0;
    }
}
