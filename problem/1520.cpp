#include <iostream>

using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int map[501][501];
int visit[501][501];
int m, n;
int next_x, next_y;

int dfs(int x, int y) {
	if (x == 1 && y == 1) {
		return 1;
	}
	if (visit[x][y] != -1)
		return visit[x][y];

	visit[x][y] = 0;
	for (int i = 0; i < 4; i++) {
		next_x = x + dx[i];
		next_y = y + dy[i];
		if (next_x >= 1 && next_x <= m && next_y >= 1 && next_y <= n) {
			if (map[next_x][next_y] > map[x][y]) {
				visit[x][y] += dfs(next_x, next_y);
			}
		}
	}

	return visit[x][y];
}

int main()
{
	cin >> m >> n;

	for (int i = 1; i <= m; i++)
		for (int j = 1; j <= n; j++) {
			cin >> map[i][j];
			visit[i][j] = -1;
		}
	cout << dfs(m, n) << endl;

	return 0;
}