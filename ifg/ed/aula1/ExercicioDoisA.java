package aula1;
import java.util.Scanner;

class ExercicioDoisA
{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Informe o salário:");
		double salario = in.nextDouble();
		System.out.println("Informe o aumento em %:");
		double aumento = in.nextDouble();
		double novoSalario = ((salario * aumento) / 100) + salario;
		System.out.println("O seu novo salário é de R$: " + novoSalario);
		in.close();
	}
}