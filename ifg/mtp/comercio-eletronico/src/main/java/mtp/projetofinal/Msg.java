package mtp.projetofinal;

import javax.swing.JOptionPane;

/**
 * Usada para criar janelas rápidas com mensagens de erro, sucesso, informação, etc. <hr><br>
 * 
 * Atualmente utilizando o JOptionPane
 * 
 * @author luiz
 */
public class Msg {
    
     /**
     * <h3>Tipos de mensagem</h3>
     *  ERRO = 0 <br>
     *  INFORMAÇÃO = 1 <br>
     *  AVISO = 2
     *  
     * @param mensagem corpo da mensagem
     * @param titulo título da mensagem
     * @param tipo tiípo da mensagem
     */
    public static void exibirMensagem(String mensagem, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
}
