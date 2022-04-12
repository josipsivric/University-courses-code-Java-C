#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <time.h>

int pid = 0;

void prekidna_rutina(int sig) {
	kill(pid, SIGKILL);
	exit(0);
}

int main(int argc, char *argv[]){

	int wait, randomSignal;
	srand((unsigned)time(NULL));

	if (argv[1] != NULL)
		pid = atoi(argv[1]);
	else {
		printf("Neispravan unos parametara! Zadajte ispravno PID procesa!\n");
		exit(0);
	}

	sigset(SIGINT, prekidna_rutina);

	while(1) {
		wait = rand() % 5 + 3; /* odspavaj 3-7 sekundi */

		while((wait = sleep(wait)) != 0) {
			randomSignal = rand() % 4 + 1; /* slučajno odaberi jedan signal (od 4) */

			switch(randomSignal) {	/* pošalji odabrani signal procesu 'pid' funkcijom kill*/
				case 1:
					kill(pid, SIGUSR1);
					break;
				case 2:
					kill(pid, SIGUSR2);
					break;
				case 3:
					kill(pid, SIGPROF); /* Profiling timer expired. */
					break;
				case 4:
					kill(pid, SIGTTIN); /* Background process attempting read.*/
					break;
				default:
					printf("Greska!\n");
					break;
			}
		}
	}

	return 0;
}
