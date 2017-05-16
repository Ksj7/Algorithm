#include <algorithm>
#include <vector>
#include <cstdio>
#include <cmath>
using namespace std;
vector<int > check(1000001);
vector<int > level(10);
int n,m;
int impow(int value, int r) {
	int result = 1;
	for (int i = 0; i < r; i++) {
		result *= value;
	}
	return result;
}

int next(int a, int p) {
	int hun_thou = a / 100000;
	int ten_thou = a % 100000 / 10000;
	int thou = a % 100000 % 10000 / 1000;
	int hun = a % 100000 % 10000 % 1000 / 100;
	int ten = a % 100000 % 10000 % 1000 % 100 / 10;
	int one = a % 100000 % 10000 % 1000 % 100 % 10;
	if (!level[hun_thou])
		level[hun_thou] = impow(hun_thou, p);
	if (!level[ten_thou])
		level[ten_thou] = impow(ten_thou, p);
	if (!level[thou])
		level[thou] = impow(thou, p);
	if (!level[hun])
		level[hun] = impow(hun, p);
	if(!level[ten])
		level[ten] = impow(ten, p);
	if (!level[one])
		level[one] = impow(one, p);
	return level[hun_thou] + level[ten_thou] + level[thou] + level[hun] + level[ten] + level[one];
}
int length(int a, int p, int cnt) {
	if (check[a] != 0) {
		return check[a] - 1;
	}
	check[a] = cnt;
	int b = next(a, p);
	return length(b, p, cnt + 1);
}
int main() {
	scanf("%d %d", &n , &m);
	printf("%d", length(n, m, 1));
}