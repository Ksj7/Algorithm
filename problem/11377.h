/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.19
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <vector>
#include <cstdio>
#include <algorithm>
using namespace std;

int t, s, k;
struct Flow {
	int n, source, sink;
	vector<vector<int> > graph;
	vector<bool> check;
	vector<int> pred;
	Flow(int n) : n(n) {
		graph.resize(n);
		check.resize(n);
		pred.resize(n, -1);
	};
	void addEdge(int head, int tail) {
		graph[head].push_back(tail);
	}
	bool dfs(int head) {
		if (head == -1) return true;
		for (int next : graph[head]) {
			if (check[next]) continue;
			check[next] = true;
			if (dfs(pred[next])) {
				pred[next] = head;
				return true;
			}
		}
		return false;
	}
	int flow() {
		int rlt = 0;
		for (int i = 0; i<n; i++) {
			fill(check.begin(), check.end(), false);
			if (dfs(i)) {
				rlt++;
			}
		}
		int cnt = 0;// 한바퀴 더 돌아 남아있는 엣지를 더 선택하고 그 갯수가 k개가 되면 멈춤
		for (int i = 0; i < n; i++) {
			fill(check.begin(), check.end(), false);
			if (dfs(i)) {
				cnt++;
				rlt++;
			}
			if (cnt == k) break;
		}
		return rlt;
	}
};

int main() {
	int x = 0;
	scanf("%d %d %d", &t, &s ,&k);
	Flow f(max(t, s) + 1);
	for (int i = 1; i <= t; i++) {
		int idx;
		scanf("%d", &idx);
		while (idx--) {
			int link;
			scanf("%d", &link);	
			f.addEdge(i, link);
		}
	}
	printf("%d", f.flow());
}