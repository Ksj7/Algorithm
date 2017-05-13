#include <algorithm>
#include <vector>
#include <cstdio>
#include <queue>
using namespace std;
vector<vector<int> > a;
int n , m , start;
void dfs(int x , vector<int> &check) {
	check[x] = true;
	printf("%d ", x);
	for (int i = 0; i < a[x].size(); i++) {
		if (check[a[x][i]] == false) {
			dfs(a[x][i], check);
		}
	}
}
void bfs(int s) {
	vector<int> check(n + 1);
	queue<int> q;
	check[s] = true; q.push(s);
	while (!q.empty()) {
		int x = q.front(); q.pop();
		printf("%d ", x);
		for (int i = 0; i< a[x].size(); i++) {
			if (check[a[x][i]] == false) {
				check[a[x][i]] = true;
				q.push(a[x][i]);
			}
		}
	}
}
int main() {
	scanf("%d %d %d", &n, &m, &start);
	a.resize(n + 1);
	vector<int> check(n + 1);
	for (int i = 0; i < m; i++) {
		int u, v;
		scanf("%d %d", &u, &v);
		a[u].push_back(v); a[v].push_back(u);
	}
	for (int i = 1; i <= n; i++)
		sort(a[i].begin(), a[i].end());

	dfs(start, check);
	printf("\n");
	bfs(start);

}