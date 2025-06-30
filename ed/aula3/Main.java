package aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira uma palavra para ser invertida");
        String palavra = sc.next();

        Pilha pilha = new Pilha(palavra.length());

        for(int i = 0; i < palavra.length(); i++) {
            String s = String.valueOf(palavra.charAt(i));
            pilha.push(s);
        }

        for(int i = 1; i <= palavra.length(); i++) {
            pilha.pop();
        }

        sc.close();
    }
}
