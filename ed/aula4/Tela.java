package aula4;

public class Tela {
    public static void main(String[] args) {
        Lista lista = new Lista(4);

        lista.imprimirTodos();

        lista.inserirFinal(38);
        lista.imprimirTodos();

        lista.inserirFinal(27);
        lista.imprimirTodos();

        lista.inserirInicio(1);
        lista.imprimirTodos();

        lista.inserirEm(1, 555);
        lista.imprimirTodos();

        lista.inserirEm(1, 959);
        lista.imprimirTodos();

        lista.remover(1);
        lista.imprimirTodos();

    }
}