package aula5.questao6;

public class Fila {

    private int[] vetor;
    private int topo;

    Fila(int tamanho) {
        this.vetor = new int[tamanho];
        this.topo = 0;
    }

    public void cadastrarNumero(int x) {
        if(isFull()) {
            System.out.println("O número não pode ser cadastrado pois a fila está cheia.");
        } else {
            this.vetor[this.topo] = x;
            this.topo++;
        }
    }

    public void mostrarNumerosPares() {
        System.out.print("Números pares: ");
        for(int i = 0; i < this.vetor.length; i++) {
            if(this.vetor[i] % 2 == 0) {
                System.out.print(this.vetor[i] + " ");
                System.out.println();
            }
        }
    }

    public void excluirNumero() {
        if(isEmpty()) {
            System.out.println("Não pude remover um número pois a fila está vazia.");
        } else {
            System.out.println("Número: " + this.vetor[0] + " excluido");
            for(int i = 0; i < (this.vetor.length -1); i++) {

                // arrumar aqui
                this.vetor[i] = this.vetor[i + 1];
            }
            this.topo--;
        }
    }

    public void exibirFilaCompleta() {
        System.out.print("[");
        for(int i = 0; i < this.vetor.length; i++) {

            if((i + 1) != this.vetor.length) {
                System.out.print(this.vetor[i] + ", ");
            } else {
                System.out.println(this.vetor[i] + "]");
            }
        }
    }

    private boolean isFull() {
        return this.topo == this.vetor.length;
    }

    private boolean isEmpty() {
        return this.topo == 0;
    }
}
