#include <stdio.h>
#include <signal.h>

#define N 6    /* broj razina prekida */

int OZNAKA_CEKANJA[N];
int PRIORITET[N];
int TEKUCI_PRIORITET;

int sig[]={SIGUSR1, SIGUSR2, SIGPROF, SIGTTIN, SIGINT};

void zabrani_prekidanje() {
	int i;
	for(i = 0; i < 5; i++)
		sighold(sig[i]);
}

void dozvoli_prekidanje() {
	int i;
	for(i = 0; i < 5; i++)
		sigrelse(sig[i]);
}

void obrada_prekida(int i) {

	int x, j;

	switch (i) {
		case 1:
			printf("-   P   -   -   -   -\n");
			for(j = 1; j < 6; j++){
				sleep(1);
				printf("-   %d   -   -   -   -\n", j);
			}
			printf("-   K   -   -   -   -\n");
			break;

		case 2:
			printf("-   -   P   -   -   -\n");
			for(j = 1; j < 6; j++){
				sleep(1);
				printf("-   -   %d   -   -   -\n", j);
			}
			printf("-   -   K   -   -   -\n");
			break;

		case 3:
			printf("-   -   -   P   -   -\n");
			for(j = 1; j < 6; j++){
				sleep(1);
				printf("-   -   -   %d   -   -\n", j);
			}
			printf("-   -   -   K   -   -\n");
			break;

		case 4:
			printf("-   -   -   -   P   -\n");
			for(j = 1; j < 6; j++){
				sleep(1);
				printf("-   -   -   -   %d   -\n", j);
			}
			printf("-   -   -   -   K   -\n");
			break;

		case 5:
			printf("-   -   -   -   -   P\n");
			for(j = 1; j < 6; j++){
				sleep(1);
				printf("-   -   -   -   -   %d\n", j);
			}
			printf("-   -   -   -   -   K\n");
			break;

		default:
			break;

		sleep(1);
		/* no break */
	}


   /* obrada se simulira trošenjem vremena,
      obrada traje 5 sekundi, ispis treba biti svake sekunde */
}

void prekidna_rutina(int sig) {

	int n = 1;
	int x, j;
	zabrani_prekidanje();

	switch(sig) {
		case SIGUSR1:
			n = 1;
			printf("-   X   -   -   -   -\n");
			break;
		case SIGUSR2:
			n = 2;
			printf("-   -   X   -   -   -\n");
			break;
		case SIGPROF:
			n = 3;
			printf("-   -   -   X   -   -\n");
			break;
		case SIGTTIN:
			n = 4;
			printf("-   -   -   -   X   -\n");
			break;
		case SIGINT:
			n = 4;
			printf("-   -   -   -   -   X\n");
			break;
		default:
			break;
	}

	OZNAKA_CEKANJA[n]++;

	do {

		/* odredi prekid najveceg prioriteta koji ceka na obradu */
		x = 0;

		for (j = TEKUCI_PRIORITET + 1; j < N; j++)
			if (OZNAKA_CEKANJA[j] != 0)
				x = j;
		/* ako postoji prekid koji ceka i prioritetniji je od trenutnog posla, idi u obradu */
		if (x > 0) {
			OZNAKA_CEKANJA[x]--;
			PRIORITET[x] = TEKUCI_PRIORITET;
			TEKUCI_PRIORITET = x;
			dozvoli_prekidanje();
			obrada_prekida(x);
			zabrani_prekidanje();
			TEKUCI_PRIORITET = PRIORITET[x];
		}
	} while (x > 0);
	dozvoli_prekidanje();
}

int main (void) {

	int delay = 1;

	sigset (SIGUSR1, prekidna_rutina);
	sigset (SIGUSR2, prekidna_rutina);
	sigset (SIGPROF, prekidna_rutina);
	sigset (SIGTTIN, prekidna_rutina);
	sigset (SIGINT, prekidna_rutina);

	printf("Proces obrade prekida, PID=%d\n", getpid());
	printf("\nGP S1  S2  S3  S4  S5\n_____________________");

	while (delay != 11) {
		sleep(1);
		printf("\n%d   -   -   -   -   -",delay);
		delay++;
	}

   /* troši vrijeme da se ima šta prekinuti - 10 s */
	printf ("\nZavrsio osnovni program\n");
	return 0;
}
