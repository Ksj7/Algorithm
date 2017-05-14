#include <algorithm>
#include <vector>
#include <cstdio>
#include <queue>
using namespace std;
vector<vector<int> > a;
vector<int > check;
int test, n, cnt;
void dfs(int x) {
	check[x] = true;
	for (int i = 0; i<a[x].size(); i++) {
		int y = a[x][i];
		if (check[y] == false) {
			dfs(y);
		}
	}
}
int main() {
	scanf("%d", &test);
	while (test) {
		cnt = 0; a.clear(); check.clear();
		scanf("%d", &n);
		a.resize(n + 1);
		check.resize(n + 1);
		for (int i = 1; i <= n; i++) {
			int u;
			scanf("%d", &u);
			a[u].push_back(i);
			a[i].push_back(u);
		}
		for (int i = 1; i <= n; i++)
			sort(a[i].begin(), a[i].end());
		for (int i = 1; i <= n; i++) {
			if (check[i] == false) {
				dfs(i);
				cnt++;
			}
		}
		
		printf("%d\n", cnt);
		test--;
	}
}