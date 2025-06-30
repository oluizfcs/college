package aula2;
class MediaPonderada {
    public static void main(String[] args) {
        int nota1 = 6, nota2 = 3, nota3 = 10;
        int peso1 = 1, peso2 = 2, peso3 = 3;

        int notaFinal = ((nota1 * peso1) + (nota2 * peso2) + (nota3 * peso3)) / (peso1 + peso2 + peso3);

        System.out.print("Média Ponderada: " + notaFinal);
    }
}