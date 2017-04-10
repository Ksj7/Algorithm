#include <stdio.h>
int main() {
	int n, i, max = 0, input[1001];
	double result = 0, test;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &input[i]);
		if (max < input[i]) max = input[i];
	}
	for (i = 0; i < n; i++) {
		test = (double)input[i] / (double)max;
		test *= 100.0;
		result += test;
	}
	printf("%.2f", result / n);
	return 0;
}