/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.16
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
	int n, m, k;
	scanf("%d %d %d", &n, &m, &k);
	int temp_k = k;
	
	vector<int> v;
	int temp_n = n;
	if (m+k-1<= n && n<= m*k){
		m -= 1;
		while (temp_k) {
			printf("%d ", temp_k--);
		}
		temp_k = k;
		while (temp_k != n) {
			v.push_back((++temp_k));
		}
		sort(v.begin(), v.end());
		int num = m;
		int v_size = v.size();
		int grp = 0; int last = 0; int res = 0;
		while (last != v.size()) {
			res = (v_size/num) + (v_size%num);
			if (res > k) res = k ;
			grp += res;
			for (int i = grp - 1; i >= last; i--) printf("%d ", v[i]);
			last += res;
			num--;
			v_size -= res;
		}
	}
	else { printf("-1"); }
}        
    