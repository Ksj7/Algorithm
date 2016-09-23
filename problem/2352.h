/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.09
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>
#include <utility>
#include <algorithm>
using namespace std;
int main() {
	int n; pair<int, int> p[40001];
	scanf("%d", &n);
	int temp;
	for (int i = 1; i <= n; i++) {
		scanf("%d", &temp);
		p[i] = make_pair(temp,i);
	}
	sort(p + 1, p + n + 1);
	int val;
	int most = 0;
	int a[40001] = {0,};
	for (int i = 1; i <= n; i++) {
		val = 0;
		for (int j = 1; j <= p[i].second; j++) {
			if (val < a[j]) val = a[j] ;
		}
		a[p[i].second] = ++val;
		if (val > most) most = val;
	}
	printf("%d", most);
}