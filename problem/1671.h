/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.01.30
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
			for (int j = 0; j<2; j++) {
				fill(check.begin(), check.end(), false);
				if (dfs(i)) {
					ans += 1;
				}
			}
		}
		return ans;
	}
};

int main() {
	int n;
	double x;
	double y;
	double z;
	double a[1001][3];
	int cnt = 0;
	scanf("%d", &n);
	MaximumFlow mf(n);
	for (int i = 0; i < n; i++) {
		scanf("%lf %lf %lf", &x, &y, &z);
		a[i][0] = x;
		a[i][1] = y;
		a[i][2] = z;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if ((a[j][0] <= a[i][0]) && (a[j][1] <= a[i][1]) && (a[j][2] <= a[i][2])) {
				if (a[j][0] == a[i][0] && a[j][1] == a[i][1] && a[j][2] == a[i][2]) {
					if (i > j)
						mf.add_edge(i, j);
				}
				else mf.add_edge(i, j);
			}
		}
	}
	printf("%d", n - mf.flow());
	return 0;
}
