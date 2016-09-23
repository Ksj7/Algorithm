/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.13
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>
#include <queue>

using namespace std;
priority_queue<int> q;
int main() {
	int n; int temp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		q.push(-temp);
	} 
	int count;
	int ans = 0;
	while (!q.empty()) {
		count = (q.top()*-1);
		temp = count * (q.size());
		q.pop();
		if (ans  < temp)  ans = temp;
	}
	printf("%d", ans);
}