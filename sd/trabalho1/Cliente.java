import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
            
            String caminhoDoArquivo;

            if(args.length < 1) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Digite o caminho do arquivo das suas respostas: ");
                caminhoDoArquivo = sc.nextLine();
                sc.close();
            } else {
                caminhoDoArquivo = args[0];
            }
            
            File arquivo = new File(caminhoDoArquivo);

            if(!arquivo.exists()) {
                System.out.println("Arquivo não encontrado!");
                return;
            }

            Socket cliente = new Socket("127.0.0.1", 12345);
            Scanner leitorArquivo = new Scanner(arquivo);
            PrintStream saida = new PrintStream(cliente.getOutputStream());

            while (leitorArquivo.hasNextLine()) {
                saida.println(leitorArquivo.nextLine());
            }

            cliente.shutdownOutput();
            long tempoInicio = System.nanoTime();
            System.out.println("Questões enviadas para correção");
            
            Scanner leitorResultado = new Scanner(cliente.getInputStream());
            System.out.println(leitorResultado.nextLine());
            System.out.println("Tempo de espera: " + (System.nanoTime() - tempoInicio)/1000000000 + "s");
            
            leitorArquivo.close();
            cliente.close();
            saida.close();
	}
}