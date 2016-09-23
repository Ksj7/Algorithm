/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.23
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>

int n, t, d[12] = { 1,2,4, };
int temp;
int main() {
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);	
		for (int i = 3; i < n; i++) {
			if (d[i] != 0) continue;
			d[i] += (d[i - 3] + d[i - 2] + d[i - 1]);
		}
		printf("%d\n", d[n-1]);
	}
}