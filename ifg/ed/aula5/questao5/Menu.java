package aula5.questao5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Tamanho da pilha: ");
            Pilha pilha = new Pilha(scanner.nextInt());

            menu:
            while(true) {
                System.out.println("1- Cadastrar número");
                System.out.println("2- Mostrar números pares");
                System.out.println("3- Excluir número");
                System.out.println("4- Exibir a pilha completa");
                System.out.println("5- Sair");
        
                System.out.print("\n--> ");
        
                
                switch(scanner.nextInt()) {
                    case 1:
                        System.out.print("\nNúmero a ser cadastrado: ");
                        pilha.cadastrarNumero(scanner.nextInt());
                        break;
                    case 2:
                        pilha.mostrarNumerosPares();
                        break;
                    case 3:
                        pilha.excluirNumero();
                        break;
                    case 4:
                        pilha.exibirPilhaCompleta();
                        break;
                    case 5:
                        System.out.print("----------------------- \nFim da execução.");
                        break menu;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch(InputMismatchException e) {
            System.out.print("Erro: apenas números inteiros");
        }

        scanner.close();
    }
}
