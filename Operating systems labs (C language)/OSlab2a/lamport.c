#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <malloc.h>

int *SEARCH;
int *NUM;
int N;

void KO (int i);
void KO_exit (int i);

void *thread (void *i)
{
	int j, k, m;

	j = *((int *)i);

	for (k = 1; k <= 5; k++) {
		KO (j);
		for (m = 1; m <= 5; m++){
			printf("Dretva: %d, K.O. br: %d, (%d/5)\n",j + 1, k, m);
			sleep(1);
		}
		KO_exit(j);
	}
}

void KO (int i)
{
	int j, k, m;
	m = 0;
	SEARCH[i] = 1;
	for (k = 0; k <= N - 1; k++) {
		if (NUM[k] > m) {
			m = NUM[k];
		}
	}
	NUM[i] = m + 1;
	SEARCH[i] = 0;
	for (j = 0; j <= N - 1; j++){
		while (SEARCH[j] != 0);
			while (NUM[j] != 0 && (NUM[j] < NUM[i] || (NUM[j] == NUM[i] && j < i)));
	}
}

void KO_exit (int i)
{
	NUM[i] = 0;
}

int main(int argc, char *argv[])
{
	int i, *br;
	pthread_t *t;

	if (argv[1] != NULL)
		N = atoi(argv[1]);
	else {
		printf("Niste unijeli argument!\n");
		exit(0);
	}

	SEARCH = (int *) malloc (N * sizeof(int));
	NUM = (int *) malloc (N * sizeof(int));
	br = (int *) malloc (N * sizeof(int));
	t = (pthread_t *) malloc (N * sizeof(pthread_t));

	for (i = 0; i <= N - 1; i++) {
		SEARCH[i] = 0;
		NUM[i] = 0;
	}

	for (i = 0; i <= N - 1; i++) {
		br[i] = i;
		sleep(1);
		if (pthread_create(&t[i], NULL, thread, ((void *)&br[i]))) {
			printf("Problem kod stvaranja dretve! Dretva nije stvorena!\n");
			exit(1);
		}
	}
	for (i = 0; i <= N - 1; i++) {
		pthread_join(t[i], NULL);
	}

	free(SEARCH);
	free(NUM);
	free(br);
	free(t);

	return 0;
}
