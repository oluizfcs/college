import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Servidor {

    public static ArrayList<String> gabarito;
    
    public static void main(String[] args) throws IOException {

        gabarito = Professor.processarQuestoes(new Scanner(new File("gabarito.txt")));
        
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Aguardando questões para corrigir através da porta 12345!");
        
        while(true) {
            Socket cliente = servidor.accept();
            Thread thread = new Thread(new Professor(cliente));
            thread.start();
        }
    }
}

class Professor implements Runnable {
    
    Socket aluno;
    
    public Professor(Socket aluno) {
        this.aluno = aluno;
    }
    
    @Override
    public void run() {
        System.out.println("\nQuestões recebidas de " + aluno.getInetAddress().getHostAddress());

        try {
            Scanner entrada = new Scanner(aluno.getInputStream());

            System.out.println("Corrigindo questões...");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Interrompido");
            }

            ArrayList<String> respostas = Professor.processarQuestoes(entrada);

            int acertos = 0;
            int erros = 0;

            for(int i = 0; i < Servidor.gabarito.size(); i++) {
                for(int j = 0; j <= 4; j++) {
                    if(respostas.get(i).charAt(j) == Servidor.gabarito.get(i).charAt(j)) {
                        acertos++;
                    } else {
                        erros++;
                    }
                }
            }
            System.out.println((acertos - erros) + " pontos");
            PrintStream saida = new PrintStream(aluno.getOutputStream());
            saida.println(acertos + "-" + erros);

            entrada.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<String> processarQuestoes(Scanner sc) {
        ArrayList<String> questoes = new ArrayList<>();

        while(sc.hasNextLine()) {
            String[] questao = sc.nextLine().split("-");
            questoes.add(Integer.parseInt(questao[0]) - 1, questao[1]);
        }

        return questoes;
    }
}