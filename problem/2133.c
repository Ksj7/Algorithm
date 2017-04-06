#include <stdio.h>
#include <stdlib.h>

int main(void) {

	int box[31] = { 0, };
	int n, i, j;
	scanf("%d", &n);
	box[0] = 1; box[2] = 3;
	if (n % 2 == 1) printf("0");
	else {
		for (i = 4; i <= n; i+=2) {
			box[i] = 3*box[i-2];
			for (j = i - 4; j >= 0; j -= 2) {
				box[i] += box[j] * 2;
			}
		}
		printf("%d", box[n]);
	}
}

