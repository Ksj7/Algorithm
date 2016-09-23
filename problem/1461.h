/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.18
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	vector<int> v;
	vector<int> s;
	vector<int> a;
	int n, m; int temp;
	int m_n = 0, a_n = 0;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &temp);
		if(temp<0) s.push_back(temp),m_n++;
		else a.push_back(temp),a_n++;
	}
	sort(s.begin(), s.end());
	sort(a.begin(), a.end());
	reverse(a.begin(), a.end());
	int idx = 0; int k = m-1;
	for (int i = 0; i < m_n; i++) {
		v.push_back(s[i]);
		while (k-- ) i++;
		k = m - 1;
	}
	for (int i = 0; i < a_n; i++) {
		v.push_back(a[i]);
		while (k--) i++;
		k = m - 1;
	}
	int top_a = (a_n > 0) ? a[0] : 0;
	int top_m = (m_n > 0) ? -1*v[0] : 0;
	int top = (top_a > top_m) ? a[0] : v[0];
	int res = 0;
	for (int i = 0; i < v.size(); i++) {
		if (top == v[i]) {
			if(v[i] < 0) res += (v[i]*-1);
			else res += v[i];
		}
		else {
			if (v[i] > 0) res += (v[i] * 2);
			else res += (v[i] * -2);
		}
	}

	printf("%d", res);

}