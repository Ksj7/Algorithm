#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))

int compare(void *first, void *second) {
	if (*(int*)first > *(int*)second) return 1;
	else if (*(int*)first < *(int*)second) return -1;
	else return 0;
}

int main(void) {

	int box[1001] = { 0, };
	int len[1001] = { -1, };
	int i, n, j, max_length;
	scanf("%d", &n);
	for ( i = 1; i <= n; i++) {
		scanf("%d", &box[i]);
	}
	for (i = 1; i <= n; i++) {
		max_length = 0;
		for (j = 1; j <= i; j++) {
			if (box[i] > box[j]) {
				max_length = MAX(len[j], max_length);
			}
		}
		len[i] = max_length + 1;
	}
	qsort(len+1, n, sizeof(int), compare);
	printf("%d", len[n]);
}