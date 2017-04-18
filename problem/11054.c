#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int compare(void *first, void *second) {
	if (*(int*)first > *(int*)second) return 1;
	else if (*(int*)first < *(int*)second) return -1;
	else return 0;
}
int main(void) {
	int arr[1001] = { 0, };
	int len[1001] = { 0, };
	int len_2[1001] = { 0, };
	int i, j, n, max;
	scanf("%d", &n);
	for (i = 1; i <= n; i++)
		scanf("%d", &arr[i]);

	for (i = 1; i <= n; i++) {
		max = 0;
		for (j = 1; j <= i; j++) {
			if (arr[i] > arr[j]) {
				max = MAX(len[j], max);
			}
		}
		len[i] = max + 1;
		
	}
	for (i = n; i >= 1; i--) {
		max = 0;
		for (j = i; j <= n; j++) {
			if (arr[i] > arr[j]) {
				max = MAX(len_2[j], max);
			}
		}
		len_2[i] = max + 1;
	}

	for (i = 1; i <= n; i++)
		len_2[i] += len[i];
	qsort(len_2 + 1, n, sizeof(int), compare);
	printf("%d\n", len_2[n] - 1);
}