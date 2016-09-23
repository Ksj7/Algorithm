/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.05
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */
 
#include <cstdio>

using namespace std;

int main() {
	int total = 0; bool is = false;
	int temp; int sign;
	while ( scanf("%d\n%c", &temp,&sign) != EOF) {
		if (is) {
			total -= temp;
		}
		else total += temp;
		if (sign == '-') is = true;
	}
	printf("%d", total);
}