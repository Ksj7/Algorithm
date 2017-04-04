#include <cstdio>
#include <vector>
using namespace std;
int main(void) {
	vector<long long> arr;
	arr.resize(101);
	int i, n, test;
	scanf("%d", &test);
	arr[1] = 1;
	arr[2] = 1;
	arr[3] = 1;
	arr[4] = 2;
	arr[5] = 2;
	for (i = 6; i <= 100; i++) {
		arr[i] = arr[i - 3] + arr[i - 2];
	}
	while (test--) {
		scanf("%d", &n);
		printf("%lld\n", arr[n]);
	}
}