package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        try {
            System.out.print("n1: ");
            calc.setNumero1(scanner.nextDouble());
            System.out.print("\nn2: ");
            calc.setNumero2(scanner.nextDouble());

            switch(scanner.next()) {
                case "1":
                    System.out.println("soma = " + calc.somar());
                    break;
                case "2":
                    System.out.println("diferença = " + calc.subtrair());
                    break;
                case "3":
                    System.out.println("produto = " + calc.multiplicar());
                    break;
                case "4":
                    System.out.println("razão = " + calc.dividir());
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }

            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Somar " + calc.getNumero1() + " com " + calc.getNumero2());
            System.out.println("2 - Subtrair " + calc.getNumero2() + " de " + calc.getNumero1());
            System.out.println("3 - Multiplicar " + calc.getNumero1() + " por " + calc.getNumero2());
            System.out.println("4 - Dividir " + calc.getNumero1() + " por " + calc.getNumero2());

        } catch (InputMismatchException e) {
            System.out.println("Apenas números");
        }
        
        scanner.close();
    }
}
