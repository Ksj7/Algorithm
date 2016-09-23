/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.22
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include<cstdio>
#include<algorithm>
#include<vector>
using namespace std;

struct a {
	int q, w, num;
};
a x[200001];
int arr[200001];
int idx[200001];
bool compare(a d1, a d2) {
	return d1.w < d2.w;
}
int main() {
	int n; 
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &x[i].q, &x[i].w);
		x[i].num = i;
	}
	sort(x+1, x + n+1, compare);
	int j = 0; int res = 0;
	for (int i = 1; i <= n; i++) {
		if (x[i].w != x[i - 1].w ) {
			for (; j < i; j++)
				res += x[j].w, arr[x[j].q] += x[j].w;
		}
		idx[x[i].num] = res - arr[x[i].q];
	}
	for (int i = 1; i <= n; i++)
		printf("%d\n", idx[i]);
}