/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.24
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>
long long d[101][10];
int n;
int main() {
	scanf("%d", &n);
	for (int i = 1; i <= 9; i++) d[1][i] = 1ll;
	for (int i = 2; i <= n; i++)
		for (int j = 0; j <= 9; j++) {
			d[i][j] = 0;
			if (j != 0) d[i][j] += d[i - 1][j - 1];
			if (j != 9) d[i][j] += d[i - 1][j + 1];
		    d[i][j] %= 1000000000;
        }
	long long res = 0;
	for (int i = 0; i <= 9; i++) res += d[n][i];
	printf("%d", res%1000000000);
}