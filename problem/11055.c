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
	int len[1001] = { -1, };
	int n, i, j , max_value;
	scanf("%d", &n);
	for(i = 1; i <= n; i++)
		scanf("%d", &arr[i]);
	for (i = 1; i <= n; i++) {
		max_value = 0;
		for (j = 1; j < i; j++) {
			if(arr[i] > arr[j])
				max_value = MAX(len[j], max_value);
		}
		len[i] = max_value + arr[i];
	}
	qsort(len + 1, n, sizeof(int), compare);
	printf("%d", len[n]);
}

