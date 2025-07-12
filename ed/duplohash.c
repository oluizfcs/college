#include <stdio.h>
#include <stdlib.h>

int tamanho = 10;
#define PASSO 5
#define FATOR_DE_CARGA 0.75
#define VAZIO 0
#define REMOVIDO -1

typedef struct node {
    int chave;
    char valor[100];
} Node;

Node* tabela;

int hash1(int chave) {
    int resultado = chave % tamanho;
    printf("\n hash1: %d %% %d = %d", chave, tamanho, resultado);
    return resultado;
}

int hash2(int chave) {
    int resultado = PASSO - (chave % PASSO);
    printf("\n hash2: %d - (%d %% %d) = %d", PASSO, chave, PASSO, resultado);
    return resultado;
}

float calcular_preenchimento() {
    float indices_ocupados = 0;
    for(int i = 0; i < tamanho; i++) {
        if(tabela[i].chave != VAZIO && tabela[i].chave != REMOVIDO) {
            indices_ocupados = indices_ocupados + 1.0;
        }
    }

    return indices_ocupados / tamanho;
}

void mostrar_indices() {
    for(int i = 0; i < tamanho; i++) {
        if(tabela[i].chave != VAZIO) {
            printf("\n[%d]: [%d -> %s]", i, tabela[i].chave, tabela[i].valor);
        } else {
            printf("\n[%d]: ", i);
        }
    }
    printf("\n");
}

void expandir() {
    int tamanho_antigo = tamanho;
    tamanho = tamanho * 2;
    
    Node* nova_tabela = (Node*)malloc(tamanho * sizeof(Node));
    
    //rehash
    for (int i = 0; i < tamanho_antigo; i++) {
        if (tabela[i].chave != VAZIO && tabela[i].chave != REMOVIDO) {
            Node n = tabela[i];

            int h1 = hash1(n.chave);
            int h2 = hash2(n.chave);
            int j = 0, indice;

            do {
                indice = (h1 + j * h2) % tamanho;
                j++;
            } while (nova_tabela[indice].chave != 0);

            nova_tabela[indice] = n;
        }
    }

    free(tabela);
    tabela = nova_tabela;

    printf("\ntabela expandida para %d posições.\n", tamanho);
    mostrar_indices();
}

void inserir(Node n) {
    
    printf("\n\n\n\n\n\ninserindo [%d -> %s]", n.chave, n.valor);
    
    int indice = 0;

    int h1 = hash1(n.chave);
    int h2 = hash2(n.chave);
    
    int i = 0;
    do {
        indice = (h1 + i * h2) % tamanho;
        printf("\n (%d + %d * %d) %% %d = %d", h1, i, h2, tamanho, indice);
        i++;
    } while (tabela[indice].chave != VAZIO && tabela[indice].chave != REMOVIDO);
    
    tabela[indice] = n;
    
    printf("\n%d inserida no índice %d\n", n.chave, indice);
    mostrar_indices();
    
    
    float preenchimento = calcular_preenchimento();
    
    if(preenchimento >= FATOR_DE_CARGA) {
        printf("A tabela está %.0f%% preenchida e deve expandir\n", preenchimento * 100);
        expandir();
    }
}

Node* buscar(int chave) {
    int h1 = hash1(chave);
    int h2 = hash2(chave);

    int i = 0;
    int indice;

    do {
        indice = (h1 + i * h2) % tamanho;

        if (tabela[indice].chave == VAZIO) {
            return NULL;
        }

        if (tabela[indice].chave == chave) {
            return &tabela[indice];
        }

        i++;
    } while (i < tamanho);

    return NULL;
}

void remover(int chave) {
    int h1 = hash1(chave);
    int h2 = hash2(chave);

    int i = 0;
    int indice;

    do {
        indice = (h1 + i * h2) % tamanho;

        if (tabela[indice].chave == VAZIO) {
            printf("\nChave %d não encontrada para remoção.\n", chave);
            return;
        }

        if (tabela[indice].chave == chave) {
            tabela[indice].chave = REMOVIDO;
            printf("\nChave %d removida do índice %d.\n", chave, indice);
            return;
        }

        i++;
    } while (i < tamanho);

    printf("Chave %d não encontrada para remoção.\n", chave);
}

int main() {
    tabela = (Node*)malloc(tamanho * sizeof(Node));

    inserir((Node){123456789, "Ana"});
    inserir((Node){987654321, "Bruno"});
    inserir((Node){111222333, "Carlos"});
    inserir((Node){444555666, "Diana"});
    inserir((Node){333222111, "Eduardo"});
    inserir((Node){555666777, "Fernanda"});
    inserir((Node){888999000, "Gabriel"});
    inserir((Node){999888777, "Helena"});
    inserir((Node){101010101, "Igor"});
    inserir((Node){202020202, "Julia"});
    inserir((Node){303030303, "Kleber"});
    inserir((Node){404040404, "Laura"});
    inserir((Node){505050505, "Marcos"});
    inserir((Node){606060606, "Natalia"});
    inserir((Node){707070707, "Otavio"});
    
    // printf("\n\nbusca:\n");
    // Node* resultado = buscar(999888777);
    // if(resultado == NULL) {
    //     printf("\nChave não encontrada");
    // } else {
    //     printf("\nvalor da chave: %s", resultado->valor);
    // }

    free(tabela);
    return 0;
}