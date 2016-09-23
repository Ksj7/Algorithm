/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.23
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>
#include <algorithm>
int n;
int d[1001];
int c[1001];
using namespace std;
int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d", &c[i]);
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++)
			d[i] = max(d[i], d[i - j] + c[j]);
	}
	printf("%d",d[n]);
}