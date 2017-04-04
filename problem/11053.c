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
	int i, n , j, max_length;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (i = 0; i < n; i++) {
		max_length = 0;
		for (j = 0; j < i; j++) {
			if ( arr[j] < arr[i] )   {
				if (max_length < len[j])
					max_length = len[j];
			}
		}
		len[i] = max_length+1;
	}

	qsort(len, n, sizeof(int), compare);
	printf("%d", len[n-1]);
}