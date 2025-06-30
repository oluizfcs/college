#include <stdio.h>
#include <stdlib.h>

#define QUANTUM 10

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
int tempo_ocioso = 0;

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

int executar_processos() {
    while(fila.proximo != NULL) {
        
        No *executando = fila.proximo;
        fila.proximo = executando->proximo;
        
        if(executando->processo->tempo_execucao >= QUANTUM) {
            executando->processo->tempo_execucao -= QUANTUM;
            printf("PID %d: executado por %ds\n", executando->processo->pid, QUANTUM);
            tempo_total += QUANTUM;
            
            executando->proximo = NULL;
            inserir_na_fila(executando);
        } else {
            int tempo = executando->processo->tempo_execucao;
            tempo_ocioso += QUANTUM - tempo;
            printf("PID %d: executado por %ds e finalizado. (Processador ocioso por %ds)\n",
                executando->processo->pid, tempo, QUANTUM - tempo);
            tempo_total += tempo;
            free(executando->processo);
            free(executando);
        }
    }

    printf("\nO processador trabalhou por %ds e ficou ocioso por %ds", tempo_total, tempo_ocioso);
}

int main()
{
    add_processo(12, 5);
    add_processo(34, 15);
    add_processo(56, 3);
    add_processo(78, 31);
    add_processo(90, 9);
    
    executar_processos();

	return 0;
}