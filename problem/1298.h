/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.01
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <string>
#include <map>
#include <queue>
using namespace std;
struct MaximumFlow {
	int n;
	int source, sink;
	vector<vector<int>> graph;
	vector<bool> check;
	vector<int> pred;
	MaximumFlow(int n) : n(n) {
		graph.resize(n);
		check.resize(n);
		pred.resize(n, -1);
	};
	void add_edge(int u, int v) {
		graph[u].push_back(v);
	}
	bool dfs(int x) {
		if (x == -1) return true;
		for (int next : graph[x]) {
			if (check[next]) continue;
			check[next] = true;
			if (dfs(pred[next])) {
				pred[next] = x;
				return true;
			}
		}
		return false;
	}
	int flow() {
		int ans = 0;
		for (int i = 0; i<n; i++) {
			fill(check.begin(), check.end(), false);
			if (dfs(i)) {
				ans += 1;
			}
		}
		return ans;
	}
};

int main() {
	int n;
	int num;
	int x;
	int y;

	scanf("%d %d", &n , &num);

	MaximumFlow mf(max(n, num));
	for (int i = 0; i < num; i++) {
		scanf("%d %d", &x, &y);
		mf.add_edge(x-1, y-1);
	}
	printf("%d", mf.flow());
	return 0;
}