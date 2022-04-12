#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>

int ID;
int *PRAVO;
int *ZASTAVICA;

void KO (int i, int j);
void KO_exit (int i, int j);

void proces (int i)
{
	int k, m, j;

	if (i == 0) {
		j = 1;
	} else if (i == 1) {
		j = 0;
	}

	for (k = 1; k <= 5; k++) {
		KO (i, j);
		for (m = 1; m <= 5; m++) {
			printf("Proces: %d, K.O. br: %d, (%d/5)\n", i + 1, k, m);
			sleep(1);
		}
		KO_exit (i, j);
	}
}

void KO (int i, int j)
{
	ZASTAVICA[i] = 1;

	while (ZASTAVICA[j] != 0) {
		if (*PRAVO == j) {
			ZASTAVICA[i] = 0;
			while (*PRAVO == j);
				ZASTAVICA[i] = 1;
		}
	}
}

void KO_exit (int i, int j)
{
	*PRAVO = j;
	ZASTAVICA[i] = 0;
}

void clear (int sig)
{
	(void) shmdt((char *) PRAVO);
	(void) shmdt((char *) ZASTAVICA);
	(void) shmctl(ID, IPC_RMID, NULL);
	exit(0);
}

int main(int argc, char *argv[])
{
	int i, status;

	ID = shmget(IPC_PRIVATE, sizeof(int)*100, 0600);

	if (ID == -1)
		exit(1);

	PRAVO = (int *) shmat(ID, NULL, 0);
	*PRAVO = 0;
	ZASTAVICA = (int *) shmat(ID, NULL, 0) + 1;

	for (i = 0; i < 2; i++)
		ZASTAVICA[i] = 0;

	sigset (SIGINT, clear);

	for (i = 0; i < 2; i++) {
		status = fork();
		if (status == 0) {
			proces(i);
			exit(0);
		} else if (status == -1) {
			printf("Stvaranje procesa neuspjelo!\n");
			exit(0);
		}
	}

	for (i = 0; i < 2; i++)
		wait(NULL);

	return 0;
}
