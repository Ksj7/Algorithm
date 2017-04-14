#include <stdio.h>
#include <stdlib.h>

int compare(void *first, void *second) {
	if (*(int*)first > *(int*)second) return 1;
	else if (*(int*)first < *(int*)second) return -1;
	else return 0;
}

int main() {
	int input[1001] = { 0, };
	int length[1001] = { -1, };
	int max, num, i, j;
	scanf("%d", &num);
	for (i = 1; i <= num; i++) {
		scanf("%d", &input[i]);
	}
	for (i = num; i >= 1; i--) {
		max = 0;
		for (j = i; j <= num; j++) {
			if (input[i] > input[j])
				if (max < length[j])
					max = length[j];
		}
		length[i] = max + 1;
	}
	qsort(length + 1, num, sizeof(int), compare);
	printf("%d", length[num]);
	
	return 0;
}