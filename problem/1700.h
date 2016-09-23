/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.11
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>

int main() {
	int n; int m;
	int cnt = 0;
	int arr[101];
	int socket[101];
	int num = 0;
	scanf("%d %d", &n , &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &arr[i]);
	}
	bool diff;
	for (int i = 0; i < m; i++) {
		diff = true;
		for (int k = 0; k < num; k++) {
			if (socket[k] == arr[i]) {
				diff = false;
				break;
			}
		}//콘센트에 있는 것들 걸러냄
		if (diff) {//콘센트에 없는거 //1. 콘센트가 남았을 경우 2.콘센트가 남지 않았을 경우(사용이 늦은것을 골라내야함)
			if (num < n)
				socket[num++] = arr[i];//콘센트가 남아있을 경우
			else {//콘센트를 빼야하는경우
				int max = 0; int idx; int u;int  j;
				for (u = 0; u < n; u++){
					for (j = i + 1; j < m; j++)
						if (arr[j] == socket[u])
							break;
					if (j > max) max = j, idx = u;
				}	socket[idx] = arr[i];
					cnt++;
			}
		}
	}
	printf("%d", cnt);

}