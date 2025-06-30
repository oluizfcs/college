import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LerNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira quantos números quiser e digite uma letra quando quiser parar.");
        while (true) {
            try {
                numeros.add(scanner.nextInt());

            } catch(InputMismatchException e) {
                break;
            }
        }

        System.out.print("Números inseridos: [");
        for (int i = 0; i < numeros.size(); i++) {
            if(!(i+1 == numeros.size())) {
                System.out.print(numeros.get(i) + ", ");
            } else {
                System.out.println(numeros.get(i) + "]");
            }
        }

        scanner.close();
    }
}