#include <stdio.h>
#include <stdlib.h>

#define QUANTUM 1

typedef struct Processo {
	int pid;
	int tempo_execucao;
	int prioridade;
} Processo;

typedef struct No {
	Processo *processo;
	struct No *proximo;
} No;

No fila = {NULL, NULL}; // apenas inicializando
int tempo_total = 0;
int tempo_ocioso = 0;

void inserir_na_fila(No *novo_no) {
    No *tmp = &fila;

    while(tmp->proximo != NULL) {
        tmp = tmp->proximo;
    }
    
    tmp->proximo = novo_no;
}

void add_processo(int pid, int tempo_execucao, int prioridade) {

	Processo *novo_processo = (Processo*)malloc(sizeof(Processo));
	No *novo_no = (No*)malloc(sizeof(No));
	if(novo_processo == NULL || novo_no == NULL) {
		printf("sem memória");
		exit(1);
	}

	novo_processo->pid = pid;
	novo_processo->tempo_execucao = tempo_execucao;
	novo_processo->prioridade = prioridade;
	novo_no->processo = novo_processo;
	novo_no->proximo = NULL;

    inserir_na_fila(novo_no);
}

int executar_processos() {
    printf("PID | Prioridade\n");
    while(fila.proximo != NULL) {
        
        No *executando = fila.proximo;
        fila.proximo = executando->proximo;
        
        int tempo_execucao = QUANTUM * executando->processo->prioridade;
        
        if(executando->processo->tempo_execucao >= tempo_execucao) {
            executando->processo->tempo_execucao -= tempo_execucao;
            printf("  %d       %d    : executado por %ds\n", executando->processo->pid,
                executando->processo->prioridade, tempo_execucao);
            tempo_total += tempo_execucao;
            
            executando->proximo = NULL;
            inserir_na_fila(executando);
        } else {
            int tempo = executando->processo->tempo_execucao;
            tempo_ocioso += tempo_execucao - tempo;
            printf("  %d       %d    : executado por %ds e finalizado. (ocioso %ds)\n",
                executando->processo->pid, executando->processo->prioridade, tempo, tempo_execucao - tempo);
            tempo_total += tempo;
            free(executando->processo);
            free(executando);
        }
    }

    printf("\nO processador trabalhou por %ds e ficou ocioso por %ds", tempo_total, tempo_ocioso);
}

int main()
{
    // pid, tempo_execucao, prioridade
    add_processo(1, 5, 2);
    add_processo(2, 1, 5);
    add_processo(3, 3, 6);
    add_processo(4, 3, 6);
    add_processo(5, 9, 2);
    
    executar_processos();

	return 0;
}