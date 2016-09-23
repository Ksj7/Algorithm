/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.17
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include <cstdio>

int main() {
	bool arr[11] = { false, };
	int num;
	int n, s, r;
	int temp;
	scanf("%d %d %d", &n, &s, &r);
	num = s;
	for (int i = 0; i < s; i++) {
		scanf("%d", &temp);
		arr[temp] = true;
	}
	for (int i = 0; i < r; i++) {
		scanf("%d", &temp);
		if (arr[temp] == true) {
			num--;
			arr[temp] = false;
			continue;
		}
		else if (arr[temp - 1] == true ) {
			arr[temp - 1] = false;
			num--;
		}
		else if (arr[temp + 1] == true) {
			arr[temp + 1] = false;
			num--;
		}
	}
	printf("%d", num);
 }