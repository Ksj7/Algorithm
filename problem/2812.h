/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.12
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>
#include <queue>
using namespace std;
int main() {
	int n, k;
	char a[500001];
	deque<int> q;
	scanf("%d %d", &n, &k);
	scanf("%s", a );
	for (int i = 0; i < k ; i++) {
		while (!q.empty() && q.back() < a[i]) q.pop_back();
		q.push_back(a[i]);
	}

		for (int i = k; i < n; i++) {
			
			while (!q.empty() && q.back() < a[i] ) q.pop_back();
			q.push_back(a[i]);
			printf("%c", q.front());
			q.pop_front();
			
		}
	
}