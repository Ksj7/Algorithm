#include <stdio.h>
#include <stdlib.h>

int compare(void *first, void *second) {
	if (*(int*)first > *(int*)second) return 1;
	else if (*(int*)first < *(int*)second) return -1;
	else return 0;
}

int main() {
	int input[3];
	scanf("%d %d %d", &input[0], &input[1], &input[2]);
	qsort(input, 3, sizeof(int), compare);
	printf("%d", input[1]);
	return 0;
}