#include <algorithm>
#include <vector>
#include <cstdio>
#include <queue>
using namespace std;
vector<vector<int> > a;
vector<int > check;
int n, m, cnt = 0;
void bfs(int start) {
	queue<int> q;
	if (check[start] == true) return;
	check[start] = true; q.push(start); cnt++;
	while (!q.empty()) {
		int x = q.front(); q.pop();
		if (check[x] == false) cnt++;
		for (int i = 0; i< a[x].size(); i++) {
			if (check[a[x][i]] == false) {
				check[a[x][i]] = true;
				q.push(a[x][i]);
			}
		}
	}
}
int main() {
	scanf("%d %d", &n, &m);
	a.resize(n + 1);
	check.resize(n + 1);
	for (int i = 0; i < m; i++) {
		int u, v;
		scanf("%d %d", &u, &v);
		a[u].push_back(v); a[v].push_back(u);
	}
	for (int i = 1; i <= n; i++)
		sort(a[i].begin(), a[i].end());
	for (int i = 1; i <= n; i++) {
		bfs(i);
	}
	printf("%d", cnt);
}