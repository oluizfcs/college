package aula2.exercicios;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Quantos números você deseja digitar? ");
        int qtd = in.nextInt();

        double soma = 0;

        for(int i = 1; i <= qtd; i += 1) {

            System.out.print("Número " + i + ": ");
            soma += in.nextInt();
        }

        System.out.print("Média: " + String.format("%.2f", (soma / qtd)));

        in.close();
    }
}
