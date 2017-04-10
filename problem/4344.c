#include <stdio.h>
int main() {
	int n, i, test, input[1001], num;
	double result , mid;
	scanf("%d", &test);
	while (test--) {
		result = 0; num = 0;
		scanf("%d", &n);
		for (i = 0; i < n; i++) {
			scanf("%d", &input[i]);
			result += 1.0 * input[i];
		}
		mid = result / (double)n;
		for (i = 0; i < n; i++) {
			if (mid < input[i])
				num++;
		}
		printf("%.3f%%\n", ((double)num / (double)n) * 100.0);
	}
	return 0;
}