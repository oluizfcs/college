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

void inserir_na_fila(Processo *novo_processo, No *novo_no) {
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

    inserir_na_fila(novo_processo, novo_no);
}

No *procurar_menor_tempo() {
    
    No *tmp = &fila;
    No *anterior_menor_tempo = &fila;
    
    while(tmp->proximo->proximo != NULL) {
        if(tmp->proximo->proximo->processo->tempo_execucao < tmp->proximo->processo->tempo_execucao) {
            anterior_menor_tempo = tmp->proximo;
        }
        tmp = tmp->proximo;
    }
    
    return anterior_menor_tempo;
}

int executar_processo() {
    
    if(fila.proximo != NULL) {
        
        No *anterior_menor_tempo = procurar_menor_tempo();
        No *executando = anterior_menor_tempo->proximo;
        
        printf("PID %d: executado em %ds\n", executando->processo->pid, executando->processo->tempo_execucao);
    
        tempo_total += executando->processo->tempo_execucao;
        
        anterior_menor_tempo->proximo = anterior_menor_tempo->proximo->proximo;
        
        free(executando->processo);
        free(executando);
    
        return 0;

    } else {
        printf("O processador está ocioso. tempo de atividade: %ds\n\n", tempo_total);
        return 1;
    }
}

int main()
{
    add_processo(2, 5);
    add_processo(10, 15);
    add_processo(25, 3);
    executar_processo();
    executar_processo();
    executar_processo();
    executar_processo();
    
    add_processo(2995, 31);
    add_processo(9528, 9);
    while(executar_processo() != 1);

	return 0;
}