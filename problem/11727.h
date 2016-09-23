/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.23
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include<cstdio>

int n, d[1001];
int main() {
	scanf("%d", &n);
	d[1] = 1;
	d[2] = 3;
	for (int i = 3; i <= n; i++) {
		d[i] += ((d[i - 2]*2 + d[i - 1]) % 10007);
	}
	printf("%d", d[n]);
}