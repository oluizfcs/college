package aula3;

class Pilha {
    
    String[] vetor;
    int topo;

    Pilha(int tamanho) {
        vetor = new String[tamanho];
        topo = 0;
    }

    void push(String no) {
        if (!isFull()) {
            vetor[topo] = no;
            topo++;
            System.out.println(no);
        } else {
            System.out.println("Não consegui colocar o nó, pois a pilha está cheia");
        }
    }

    void pop() {
        if (!isEmpty()) {
            System.out.println(topo);
            System.out.print(vetor[topo]);
            vetor[topo] = null;
            topo--;
        } else {
            System.out.println("Não consegui remover, pois a pilha está vazia");
        }
    }

    String peek() {
        return vetor[topo];
    }

    boolean isEmpty() {
        return topo == -1;
    }

    boolean isFull() {
        return topo == (vetor.length);
    }

    void list() {
        System.out.println("--------------------");
        for (int i = (vetor.length - 1); i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
}