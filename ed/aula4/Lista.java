package aula4;

public class Lista {

    Integer[] vetor;
    int posFinal = 0;

    Lista(int tamanho) {
        vetor = new Integer[tamanho];
        System.out.println("\n \n \n \n \n");
    }

    boolean isEmpty() {
        return posFinal == 0;
    }

    boolean isFull() {
        return posFinal == vetor.length;
    }

    boolean inserirInicio(Integer numero) {
        if(isFull()){
            return false;
        }

        for(int i = posFinal; i > 0; i--) {

            vetor[i] = vetor[i-1];
        }
        posFinal++;
        vetor[0] = numero;
        return true;
    }

    boolean inserirFinal(Integer numero) {
        if(isFull()){
            return false;
        }
        vetor[posFinal] = numero;
        posFinal++;
        return true;
    }

    boolean inserirEm(int pos, Integer numero) {
        if(isFull()) {
            System.out.println("Não foi possível inserir " + numero + " na lista pois ela está cheia");
            return false;
        }

        
        if(posFinal < pos) {
            vetor[posFinal] = numero;
        } else {
            for(int i = posFinal; i > pos; i--) {
                vetor[i] = vetor[i-1];
            }
            vetor[pos] = numero;
        }

        posFinal++;
        return true;
    }

    boolean remover(int pos) {
        if(isEmpty()) {
        return false;
        }
        
        vetor[pos] = null;

        for(int i = pos; i < vetor.length; i++) {

            if(!(i == vetor.length - 1)) {

                vetor[i] = vetor[i + 1];
            } else {
                vetor[i] = null;
            }
        }

        return true;
    }

    void imprimirTodos() {
        System.out.print("[");
        for(int i = 0; i < vetor.length; i++) {
            if(i+1 == vetor.length) {
                System.out.print(vetor[i]);
            } else {
                System.out.print(vetor[i] + ", ");
            }
        }
        System.out.println("]");
    }

    Integer pesquisar(int pos) {
        return vetor[pos];
    }
}