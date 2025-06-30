package aula5.questao4;

import java.util.Scanner;

public class LerDezNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];
        int indiceAtual = 0, numeroAtual;

        for(int i = 0; i < numeros.length; i++) {

            numeroAtual = sc.nextInt();

            if(numeroAtual % 2 == 0) {
                numeros[indiceAtual] = numeroAtual;
                indiceAtual++;
            } else {

                if(indiceAtual == 0) {
                    System.out.println("A pilha está vazia.");
                } else {
                    numeros[indiceAtual - 1] = 0;
                    indiceAtual--;
                }
            }
        }

        // Exibição
        if(indiceAtual != 0) {
            System.out.println("------------------------------------");
            for(int i = 0; i < numeros.length; i++) {

                if(numeros[i] != 0) {
                    System.out.print(numeros[i] + " ");
                } else {
                    System.out.print("_ ");
                }
            }
        }

        sc.close();
    }
}