/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.05
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include<cstdio>
#include<vector>

using namespace std;

int main() {
	int k; int n; int temp;
	vector<int> arr;
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if(k> temp)
			arr.push_back(temp);
	}
	int ret = 0;
	for (int i = arr.size()-1; i>=0 ; ) {
		if (arr[i] <= k) {
			k -= arr[i];
			ret++;
		}
		else i--;
	}
	printf("%d", ret);
	return 0;
}