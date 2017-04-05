#include <cstdio>
#include <vector>
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
using namespace std;
int main(void) {
	
	vector<vector<int>> v , v2;
	v.resize(1001);
	for (int i = 0; i < 1001; i++) {
		v[i].resize(1001);
	}
	int i, n, m, j;
	scanf("%d %d", &n, &m);
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++)
			scanf("%d", &v[i][j]);
	}
	v2 = v;
	for (i = 0; i < n-1; i++) {
		for (j = 0; j < m; j++) {
			v2[i + 1][j] = MAX(v[i + 1][j] + v2[i][j], v2[i + 1][j]);
			if (j == m - 1) continue;
			v2[i + 1][j + 1] = MAX(v[i + 1][j + 1] + v2[i][j], v2[i + 1][j + 1]);
			v2[i][j + 1] = MAX(v[i][j + 1] + v2[i][j], v2[i][j + 1]);
		}
	}
	for (j = 0; j < m-1; j++) {
		v2[i][j + 1] = MAX(v2[i][j] + v[i][j + 1], v2[i][j + 1]);
	}

	printf("%d", v2[n - 1][m - 1]);

}