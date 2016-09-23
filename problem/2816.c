/*
 * Author: sujin Kim (Ksj7)
 * Date: 2016.02.10
 * email: sujin.kim1414@gmail.com
 *
 * https://github.com/Ksj7/Algorithm
 * https://www.acmicpc.net/problem/1707
 */

#include<stdio.h>
#include<string.h>
int n, a, b;
char arr[11];
int i;
int main() {
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		if (strcmp(arr, "KBS1")==0)
			a = i;
		else if (strcmp(arr, "KBS2")==0)
			b = i;
	}
	for (i = 0; i < a; i++) 
		printf("1");
	for (i = 0; i < a; i++) 
		printf("4");
	if (a > b) b++;//p1이 p2보다 뒤에있으므로 올라가면서 한 칸 밀렸기 때문에
	for (i = 0; i < b; i++) 
		printf("1"); b--;//첫번째 자리를 차지했으므로 두번째 자리까지만 채우면 됨
	for (i = 0; i < b; i++) 
		printf("4");
}
