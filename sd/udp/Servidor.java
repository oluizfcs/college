/*
 * Servidor.java
 *
 * Created on 17 de Maio de 2006, 11:27
 *
 * Servidor ECHO: fica em aguardo de solicitação de algum cliente. Quando recebe
 * simplesmente devolve a mensagem. Funcionamento: tiro unico
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {

    public static void main(String args[]) {

        DatagramSocket s = null;

        try {
            s = new DatagramSocket(6789); // cria um socket UDP

            byte[] buffer = new byte[1000];

            System.out.println("\n\n*** Servidor aguardando request");

            while (true) {

                // cria datagrama para recepcionar solicitação do cliente
                DatagramPacket req = new DatagramPacket(buffer, buffer.length);

                s.receive(req);

                System.out.println("*** Request recebido de: " + req.getAddress() + ":" + req.getPort());

                String mensagem = new String(req.getData(), 0, req.getLength());

                System.out.println("Mensagem recebida: " + mensagem);

                char[] megasnem = new char[mensagem.length()];

                for (int i = mensagem.length() - 1; i >= 0; i--) {
                    megasnem[mensagem.length() - i - 1] = mensagem.charAt(i);
                }

                String mensagemInvertida = new String(megasnem);

                System.out.println("Mensagem invertida: " + mensagemInvertida);

                // envia resposta
                DatagramPacket resp = new DatagramPacket(mensagemInvertida.getBytes(), mensagemInvertida.length(),
                        req.getAddress(), req.getPort());
                s.send(resp);

            }
        } catch (SocketException e) {
            System.out.println("Erro de socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro envio/recepcao pacote: " + e.getMessage());
        } finally {
            if (s != null)
                s.close();
        }
    }
}