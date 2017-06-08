#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;
int main() {
	int n, temp;
	scanf("%d", &n);
	vector<int> a(10001);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		a[temp] += 1;
	}
	for (int i = 1; i <= 10000; i++)
		for (int j = 0; j < a[i]; j++)
			printf("%d\n", i);
}