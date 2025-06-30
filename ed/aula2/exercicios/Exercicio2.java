package aula2.exercicios;

// import java.util.Arrays;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("Quantos números você deseja digitar? ");
        int qtd = in.nextInt(), maior = 0, menor;
        int[] numeros = new int[qtd];

        
        for(int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = in.nextInt();
        }
        
        menor = numeros[0];
        // System.err.println(Arrays.toString(numeros));

        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] > maior) {
                maior = numeros[i];
            }

            if(numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        System.out.println("O maior número é: " + maior);
        System.out.println("O menor número é: " + menor);

        in.close();
    }
}
