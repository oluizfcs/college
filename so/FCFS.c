#include <stdio.h>
#include <stdlib.h>

typedef struct Processo {
	int pid;
	int tempo_execucao;
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

void add_processo(int pid, int tempo_execucao) {

	Processo *novo_processo = (Processo*)malloc(sizeof(Processo));
	No *novo_no = (No*)malloc(sizeof(No));
	if(novo_processo == NULL || novo_no == NULL) {
		printf("sem memória");
		exit(1);
	}

	novo_processo->pid = pid;
	novo_processo->tempo_execucao = tempo_execucao;
	novo_no->processo = novo_processo;
	novo_no->proximo = NULL;

    inserir_na_fila(novo_no);
}

int executar_processo() {
    if(fila.proximo == NULL) {
        printf("O processador está ocioso. tempo de atividade: %d\n\n", tempo_total);
        return 1;
    } else {
        
        No *executando = fila.proximo;
        fila.proximo = executando->proximo;
        
        printf("PID %d: executado em %d\n", executando->processo->pid, executando->processo->tempo_execucao);

        tempo_total += executando->processo->tempo_execucao;
        
        free(executando->processo);
        free(executando);

        return 0;
    }
}

int main()
{
    add_processo(2, 5);
    add_processo(10, 15);
    executar_processo();
    executar_processo();
    add_processo(25, 3);
    executar_processo();
    executar_processo();
    
    add_processo(2995, 31);
    add_processo(9528, 9);
    while(executar_processo() != 1);

	return 0;
}

