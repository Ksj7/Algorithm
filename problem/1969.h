/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.06
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
#include <cstdio>

using namespace std;
int main() {
	int n; int m;
	const int A = 65;
	const int C = 67;
	const int G = 71;
	const int T = 84;
		scanf("%d %d", &n, &m);
		char arr[1001][51];
		int num[51][5] = { 0, };


		for (int i = 0; i < n; i++) {
			scanf("%s",arr[i]);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j][i] == A)
					num[i][0]++;
				else if (arr[j][i] == C)
					num[i][1]++;
				else if (arr[j][i] == G)
					num[i][2]++;
				else if(arr[j][i] == T)
					num[i][3]++;
			}
		}
		int most[51][2];
		int ans = 0;
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < 4; i++) {
				if (most[j][0] < num[j][i] && num[j][i] != 0) {
					most[j][0] = num[j][i];
					switch (i)
					{
					case 0 :
						most[j][1] = A;
						break;
					case 1:
						most[j][1] = C;
						break;
					case 2 :
						most[j][1] = G;
						break;
					case 3 :
						most[j][1] = T;
						break;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (most[j][1] != arr[i][j])
					ans++;
			}
		}

		for (int i = 0; i < m; i++) {
			printf("%c", most[i][1]);
		}
		printf("\n%d", ans);
	
}
