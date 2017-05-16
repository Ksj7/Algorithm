#include<cstdio>
#include<vector>
using namespace std;
int t, n , x, num;
int main() {
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		vector<int> cnt(n + 1), step(n + 1), check(n + 1);
		num = 0;
		int h, r = 0;
		for (int i = 1; i <= n; i++) {
			scanf("%d", &step[i]);
			cnt[step[i]]++;
		}
		for (int i = 1; i <= n; i++) {
			x = i;
			while (!cnt[x] && !check[x]) {
				check[x] = true;
				cnt[step[x]]--;
				x = step[x];
				num++;
			}
		}
		printf("%d\n", num);
	}
	return 0;
}