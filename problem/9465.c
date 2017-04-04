#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(void) {
	int arr[100001][2] = { 0, };
	int result[4][2] = { 0, };
	int i, j, n, test;
	scanf("%d", &test);
	while (test--) {
		scanf("%d", &n);
		result[1][0] = 0; result[1][1] = 0;
		result[2][0] = 0; result[2][1] = 0;
		result[3][0] = 0; result[3][0] = 0;
		for (i = 0; i <= 1; i++)
			for (j = 1; j <= n; j++)
				scanf("%d", &arr[j][i]);
		if (n == 1) printf("%d\n", MAX(arr[1][0], arr[1][1]));
		else if (n == 2) printf("%d\n", MAX(arr[1][0] + arr[2][1], arr[1][1] + arr[2][0]));
		else {
			result[1][0] = arr[1][0];
			result[1][1] = arr[1][1];
			result[2][0] += result[1][1] + arr[2][0];
			result[2][1] += result[1][0] + arr[2][1];
			for (i = 3; i <= n; i++) {
				result[3][0] = MAX(result[2][1] + arr[i][0], result[1][1] + arr[i][0]);
				result[3][1] = MAX(result[2][0] + arr[i][1], result[1][0] + arr[i][1]);
				result[1][0] = result[2][0];
				result[1][1] = result[2][1];
				result[2][0] = result[3][0];
				result[2][1] = result[3][1];
			}
			printf("%d\n", MAX(result[3][0], result[3][1]));
		}
	}
}