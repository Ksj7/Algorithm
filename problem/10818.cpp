#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;
int main() {
	int n;
	scanf("%d", &n);
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	auto min = min_element(a.begin(), a.end());
	auto max = max_element(a.begin(), a.end());
	printf("%d %d", *min, *max);
}