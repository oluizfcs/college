package aula3;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(4);

        pilha.push("A");
        pilha.push("C");
        pilha.push("B");
        pilha.pop();
        pilha.push("F");
        pilha.pop();
        pilha.pop();

        pilha.peek();

        pilha.list();
    }
}
