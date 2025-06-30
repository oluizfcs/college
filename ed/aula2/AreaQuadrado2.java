package aula2;
import java.util.Scanner;

public class AreaQuadrado2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Insira o tamanho do lado do quadrado: ");
        int lado = in.nextInt();

        System.out.print("Dobro da área: " + ((lado * lado) * 2));

        in.close();
    }
}