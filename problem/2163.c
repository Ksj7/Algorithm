#include <stdio.h>
#include <stdlib.h>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
int main(void) {
	int arr[301][301] = { 0, };
	int j, i, n, m;
	scanf("%d %d", &n, &m);
	arr[1][1] = 0;
	for (i = 1; i <= n; i++) {
		arr[i][1] = i - 1;
		for (j = 2; j <= m; j++) {
			arr[i][j] = arr[i][j - 1] + arr[i][1] + 1;
		}
	}
	printf("%d", arr[n][m]);
}