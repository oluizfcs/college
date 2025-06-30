#include <stdio.h>
#include <stdlib.h>

typedef struct Processo {
	int pid;
	int prioridade;
} Processo;

typedef struct No {
	Processo *processo;
	struct No *proximo;
} No;

No fila = {NULL, NULL}; // apenas inicializando
int tempo_total = 0;

void inserir_na_fila(No *novo_no) {
    No *tmp = &fila;

    while(tmp->proximo != NULL) {
        tmp = tmp->proximo;
    }
    
    tmp->proximo = novo_no;
}

void add_processo(int pid, int prioridade) {

	Processo *novo_processo = (Processo*)malloc(sizeof(Processo));
	No *novo_no = (No*)malloc(sizeof(No));
	if(novo_processo == NULL || novo_no == NULL) {
		printf("sem memória");
		exit(1);
	}

	novo_processo->pid = pid;
	novo_processo->prioridade = prioridade;
	novo_no->processo = novo_processo;
	novo_no->proximo = NULL;

    inserir_na_fila(novo_no);
}

No *procurar_maior_prioridade() {
    No *tmp = &fila;
    No *anterior_maior_prioridade = &fila;
    int maior_prioridade = -1;

    while (tmp->proximo != NULL) {
        if (tmp->proximo->processo->prioridade > maior_prioridade) {
            maior_prioridade = tmp->proximo->processo->prioridade;
            anterior_maior_prioridade = tmp;
        }
        tmp = tmp->proximo;
    }

    return anterior_maior_prioridade;
}

int executar_processo() {
    
    if(fila.proximo != NULL) {
        
        No *anterior_maior_prioridade = procurar_maior_prioridade();
        No *executando = anterior_maior_prioridade->proximo;
        
        printf("PID %d: executado. prioridade: %d\n", executando->processo->pid, executando->processo->prioridade);
        
        anterior_maior_prioridade->proximo = anterior_maior_prioridade->proximo->proximo;
        
        free(executando->processo);
        free(executando);
    
        return 0;

    } else {
        printf("\n Todos os processos foram executados");
        return 1;
    }
}

int main()
{
    add_processo(1, 5);
    add_processo(2, 15);
    add_processo(3, 3);
    add_processo(4, 31);
    add_processo(5, 9);
    
    while(executar_processo() != 1);

	return 0;
}