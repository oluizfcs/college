import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket cliente = new Socket("127.0.0.1", 12345);
        File arquivo = new File("arquivo.txt");
		
		System.out.println("O cliente se conectou ao servidor!");

		Scanner sc = new Scanner(arquivo);
		
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		while (sc.hasNextLine()) {
			saida.println(sc.nextLine());
		}

		saida.close();
		sc.close();
        cliente.close();
	}
}