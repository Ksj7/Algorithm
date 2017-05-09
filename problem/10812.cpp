#include<cstdio>
#include<vector>
#include <algorithm>
using namespace std;
vector<int> bucket;
int n, m, start, mid, fin;
int main() {
	scanf("%d %d", &n, &m);
	bucket.resize(n);
	for (int i = 0; i < n; i++) {
		bucket[i] = i + 1;
	}
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &start, &fin, &mid);
		rotate(bucket.begin() + start - 1, bucket.begin() + mid - 1, bucket.begin() + fin);
	}
	for (int i = 0; i < n; i++) {
		printf("%d ", bucket[i]);
	}
	return 0;
}