/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.07
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */


#include <cstdio>
#include <algorithm>

using namespace std;
pair<int, int> p[100001];
int main() {
	int n;  int m;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) {
		scanf("%d %d", &p[i].second, &p[i].first);//second : 무게
												  //first : 가격 
		p[i].second *= -1;
	}
	sort(p + 1, p + n + 1);//가격이 낮은 것을 기준으로 ,1부터 받았음으로 1을 더해줌
	int sum = 0; int fee = 0; //가격대가 같은 것들
	int mi = 0x7fffffff;//int max
	bool isPossible = false;
	for (int i = 1; i <= n; i++) {
		sum -= p[i].second;//-가 곱해져서 넣어져 있으므로 붙여서 더함,포문이 돌 때마다 가격이 높은 것이고 즉, 전의 것들은 꽁짜로 얻게됨(같은것은 제외 ->따라서 if문으로 조건을 만듦)
		if (p[i].first == p[i - 1].first) fee += p[i - 1].first;//같은 것의 경우 가격이 부과되어야 함.
		else fee = 0;//같지 않으면 현재것보다 싼것이므로 꽁짜다.
		if (sum >= m) {
			mi = min(mi, p[i].first + fee);//현재 가격에서 fee를 더한 값과 mi의 값을 비교해서 작은 값 선택
			isPossible = true;//채워야 하는 무게와 같아지거나 커졌을 경우(문제가 성립됨)
		}
	}
	printf("%d", isPossible ? mi : -1);
}