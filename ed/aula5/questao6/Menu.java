package aula5.questao6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Tamanho da fila: ");
            Fila fila = new Fila(scanner.nextInt());

            menu:
            while(true) {
                System.out.println("1- Cadastrar número");
                System.out.println("2- Mostrar números pares");
                System.out.println("3- Excluir número");
                System.out.println("4- Exibir a fila completa");
                System.out.println("5- Sair");
        
                System.out.print("\n--> ");
        
                
                switch(scanner.nextInt()) {
                    case 1:
                        System.out.print("\nNúmero a ser cadastrado: ");
                        fila.cadastrarNumero(scanner.nextInt());
                        break;
                    case 2:
                        fila.mostrarNumerosPares();
                        break;
                    case 3:
                        fila.excluirNumero();
                        break;
                    case 4:
                        fila.exibirFilaCompleta();
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
