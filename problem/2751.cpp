#include <algorithm>
#include <vector>
#include <cstdio>
using namespace std;
int main() {
	vector<int> a;
	int n, temp;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		a.push_back(temp);
	}
	sort(a.begin(), a.end());
	for(int i = 0 ; i < n; i++)
		printf("%d\n", a[i]);
}