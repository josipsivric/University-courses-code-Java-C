#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <sys/shm.h>
#include <sys/sem.h>
#include <unistd.h>
#include <values.h>


#define NPROC 3

#define CITAJ	0
#define PUN	1
#define PRAZAN	2
#define PISI	3
#define PROIZV  4

int SID;
int SEMID;

typedef struct{
	int ULAZ;
	int IZLAZ;
	char M[5];
} container;
container *cont;

void GetSem(int nsem);
int StartVal(int semafor, int vrijednost);
int SemOp(int semafor, int operacija);
void ClearSem(void);
void WaitBsem(int nsem);
void WaitOsem(int nsem);
void SetBsem(int nsem);
void SetOsem(int nsem);
void proizvodjac(int brproiz);
void potrosac();
void EndClr();



int main(void) {
	int br_proc = 0;

	SID = shmget(IPC_PRIVATE, sizeof(cont), 0600);
	if (SID == -1) {
		perror("Error: Nema zajednicke memorije!\n");
		exit(1);
	}

	cont = (container *) shmat(SID, NULL, 0);

	GetSem(5);

	cont->ULAZ = 0;
	cont->IZLAZ = 0;
	StartVal(CITAJ,1);
	StartVal(PUN,5);
	StartVal(PISI,1);
	StartVal(PRAZAN,0);
	StartVal(PROIZV,0);

	sigset(SIGINT, EndClr);

	br_proc = 0;
	while (br_proc < (NPROC - 1)) {
		switch (fork()) {
			case 0:
				proizvodjac(br_proc+1);
				exit(0);
			case -1:
				printf("Ne mogu stvoriti proces 'Proizvodjac'!\n");
				exit(1);
			default:
				br_proc++;
				break;
		}
	}

	while (br_proc < NPROC) {
		switch (fork()) {
			case 0:
				potrosac();
				exit(0);
			case -1:
				printf("Ne mogu stvoriti proces 'Potrosac'!\n");
				exit(1);
			default:
				br_proc++;
				break;

		}
	}

	while (br_proc--)
		wait(NULL);

	EndClr();

	return 0;
}

void GetSem(int nsem) {
	SEMID = semget(IPC_PRIVATE, nsem, 0600);
	if (SEMID == -1) {
		perror("Ne mogu dobiti semafore!\n");
		exit(1);
	}
}

int StartVal(int semafor, int vrijednost) {
	return semctl(SEMID, semafor, SETVAL, vrijednost);
}

int SemOp(int semafor, int operacija) {
	struct sembuf sbuf;
	sbuf.sem_num = semafor;
	sbuf.sem_op  = operacija;
	sbuf.sem_flg = 0;
	return semop(SEMID, &sbuf, 1);
}


void WaitBsem(int nsem) {
	SemOp(nsem, -1);
}

void WaitOsem(int nsem) {
	SemOp(nsem, -1);
}

void SetBsem(int nsem) {
	StartVal(nsem, 1);
}

void SetOsem(int nsem) {
	SemOp(nsem, 1);
}


void potrosac() {
	sleep(1);
	int i = 0, nfin = 2;
	char strn[200];

	while (nfin) {
		WaitOsem(PRAZAN);
		printf("POTROSAC <- %c \n", cont->M[cont->IZLAZ]);
		strn[i] = cont->M[cont->IZLAZ];
		if (!cont->M[cont->IZLAZ]) {
			nfin--;
			i--;
		}
		cont->IZLAZ = (cont->IZLAZ + 1) % 5;
		SetOsem(PUN);
		i++;
	}
	printf("\nPrimljeno je %s\n\n", strn);
}


void proizvodjac(int brproiz) {
	char input[100];
	int i = 0;

	WaitBsem(CITAJ);
	printf("Unesi znakove proizvodjaca %d :\n", brproiz);
	scanf("%s", input);
	SetBsem(CITAJ);

	if (brproiz == 2)
                WaitBsem(PROIZV);
        else
                SetBsem(PROIZV);

	do {
		WaitOsem(PUN);
		WaitBsem(PISI);
		cont->M[cont->ULAZ] = input[i];
		printf("PROIZVODJAC %d -> %c \n", brproiz, cont->M[cont->ULAZ]);
		cont->ULAZ = (cont->ULAZ + 1) % 5;
		SetBsem(PISI);
		SetOsem(PRAZAN);
		sleep(1);
	} while (input[i++]);
}

void ClearSem(void) {
	(void) semctl(SEMID, 0, IPC_RMID, 0);
}

void EndClr() {
	shmdt((container *) cont);
	shmctl(SID, IPC_RMID, NULL);
	ClearSem();
	printf("Ociscena memorija i semafori!\n");
	exit(1);
}
