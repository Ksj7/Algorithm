#include<cstdio>
#include<vector>
#include <algorithm>
using namespace std;
vector<int> bucket;
int n, m, idx, idx2;
int main() {
	scanf("%d %d", &n, &m);
	bucket.resize(n);
	for (int i = 0; i < n; i++) {
		bucket[i] = i + 1;
	}
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &idx, &idx2);
		reverse(bucket.begin()+idx-1, bucket.begin()+idx2);
	}
	for (int i = 0; i < n; i++) {
		printf("%d ", bucket[i]);
	}
	return 0;
}