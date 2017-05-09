#include <iostream>
#include<vector>
#include <algorithm>
using namespace std;
vector<int> bucket;
int n, m, idx, idx2;
int main() {
	cin >> n >> m;
	bucket.resize(n);
	for (int i = 0; i < n; i++) {
		bucket[i] = i + 1;
	}
	for (int i = 0; i < m; i++) {
		cin >> idx >> idx2;
		swap(bucket[idx - 1], bucket[idx2 - 1]);
	}
	for (int i = 0; i < n; i++) {
		cout <<  bucket[i] << ' ';
	}
	return 0;
}
