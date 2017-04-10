#include <stdio.h>

int main() {
	int input;
	int N, X, i;
	scanf("%d %d", &N, &X);
	for (i = 0; i < N; i++) {
		scanf("%d", &input);
		if (X > input) printf("%d ", input);
	}
	return 0;
}