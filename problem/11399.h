/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.05
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

int concat(const vector<int> lengths) {
	priority_queue<int> pq;
	for (int i = 0; i < lengths.size(); i++) {
		pq.push(-lengths[i]);
	}
	int ret = 0;
	int temp = 0;

	while (pq.size() >= 1) {
		int min1 = pq.top(); pq.pop();
		ret += min1;
		temp += ret;
	}
	return temp*-1;
}


int main() {
	int n; int temp;
	scanf("%d", &n);
	vector<int> s;
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		s.push_back(temp);
	}
	printf("%d ", concat(s));

}