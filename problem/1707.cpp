#include <algorithm>
#include <vector>
#include <cstdio>
#include <queue>
using namespace std;
vector<vector<int> > a;
vector<int > check;
int test, n, m, no;
void bfs(int start) {
	queue<int> q;
	int color;
	if (!check[start]) {
		check[start] = 1;
	}
	q.push(start);
	while (!q.empty()) {
		int x = q.front(); q.pop();
		color = check[x];
		for (int i = 0; i< a[x].size(); i++) {
			int sub_color = (color == 1) ? 2 : 1;
			if (!check[a[x][i]]) {
				check[a[x][i]] = sub_color;
				q.push(a[x][i]);
			}
		}
	}
}
int main() {
	scanf("%d", &test);
	while (test) {
		no = false; a.clear(); check.clear();
		scanf("%d %d", &n, &m);
		a.resize(n + 1);
		check.resize(n + 1);
		for (int i = 0; i < m; i++) {
			int u, v;
			scanf("%d %d", &u, &v);
			a[u].push_back(v);
			a[v].push_back(u);
		}
		for (int i = 1; i <= n; i++)
			sort(a[i].begin(), a[i].end());
		for (int i = 1; i <= n; i++) {
			if (!check[i]) {
				bfs(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int x = 0; x < a[i].size(); x++) {
				int j = a[i][x];
				if (check[i] == check[j]) {
					no = true;
				}
			}
		}

		printf("%s\n", no ? "NO" : "YES");
		test--;
	}
}