/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.03
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>

using namespace std;

int n;
int m;
const int MAX = 100000;
int arr[MAX + 1];

int main() {
	scanf("%d", &n);
	while (n--) {
		int temp;
		int temp2;
		scanf("%d", &m);
		for (int i = 0; i < m; i++) {
			scanf("%d %d", &temp, &temp2);
			arr[temp-1] = temp2;
		}
		int count = 1; int b_min = arr[0];
		for (int i = 1; i < m; i++) {
			if (b_min > arr[i]) {
				count++;
				b_min = arr[i];
			}
		}
		printf("%d\n", count);
	}
}
